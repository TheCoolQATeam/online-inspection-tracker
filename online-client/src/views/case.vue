<template>
    <div class="case">
        <a-descriptions title="用例基本情况" class="case-info">
          <a-descriptions-item label="id">{{ data.baseInfo.id }}</a-descriptions-item>
          <a-descriptions-item label="页面标题">{{ data.baseInfo.title }}</a-descriptions-item>
          <a-descriptions-item label="页面简介">{{ data.baseInfo.htmlinfo }}</a-descriptions-item>
          <a-descriptions-item label="业务线">{{ groups[data.baseInfo.groupId] }}</a-descriptions-item>
          <a-descriptions-item label="页面URL"><a :href="data.baseInfo.url" target="_blank">{{ data.baseInfo.url }}</a></a-descriptions-item>
        </a-descriptions>
        <h1 class="mt-20">近30天执行情况</h1>
      <a-table :dataSource="dataSource" :columns="columns" :pagination="pagination"  class="case-list"
        @change="handleTableChange">
        <template #bodyCell="{ column, record  }">
            <template v-if="column.dataIndex === 'states'">
                <span :style="{color: record.states==1 ? 'black':'red' }">{{ record.states==1 ? '成功': '失败' }}</span>
            </template>
            <template v-if="column.dataIndex === 'responseTime'">
                <a-tag :color="record.responseTime&&Number(record.responseTime)>3000 ? 'yellow':'green'">{{ record.responseTime }}</a-tag>
            </template>
        </template>
        </a-table>
    </div>
  </template>

<script lang="ts">
import { defineComponent, reactive, onMounted, ref } from 'vue'
import { getCaseInfo, getCaseBaseInfo } from '@/api/index'
import { useRoute } from 'vue-router'
import { groups } from '@/common/data'

export default defineComponent({
  name: 'h5MonitorCase',
  setup () {
    const dataSource = ref<any[]>([])
    const data = reactive({
      baseInfo: {}
    })
    const route = useRoute()
    const id = route.params?.id

    const columns = [
      {
        title: '执行ID',
        dataIndex: 'id',
        width: 150,
        key: 'id'
      },
      {
        title: '状态',
        dataIndex: 'states',
        width: 200,
        key: 'states'
      },
      {
        title: '创建时间',
        dataIndex: 'createTime',
        width: 160,
        key: 'createTime',
        ellipsis: true
        // customRender: ({ record }: any) => record && record.createTime ? moment(record.createTimes).format('YYYY-MM-DD HH:mm:ss') : ''
      },
      {
        title: '响应时长(ms)',
        dataIndex: 'responseTime',
        key: 'responseTime',
        width: 160
      },
      {
        title: '失败原因',
        dataIndex: 'failedReason',
        key: 'failedReason',
        ellipsis: true,
        customRender: ({ record }: any) => record.failedReason
      }
    ]

    const pagination = reactive({
      total: 0,
      pageNum: 1,
      pageSize: 10,
      current: 1,
      'show-total': (total: string) => `共 ${total} 条`
    })

    const handleTableChange = (p: any) => {
      pagination.pageNum = p.current
      getItems(p.current)
    }

    const getItems = (pageNum?: number) => {
      const _pageNum = pageNum || pagination.pageNum
      const params = {
        caseId: id,
        pageNum: _pageNum,
        pageSize: pagination.pageSize
      }
      getCaseInfo(params).then((res: any) => {
        dataSource.value = res.list.map((item: any) => {
          return {
            ...item,
            key: item.id
          }
        })
        pagination.total = res.total
        pagination.pageNum = _pageNum || 1
        pagination.current = _pageNum || 1
      }).catch(err => {
        console.log(err)
      })
    }

    const getBaseInfo = () => {
      const params = {
        caseId: id
      }
      getCaseBaseInfo(params).then((res: any) => {
        data.baseInfo = res
        console.log('data.baseInfo', data.baseInfo)
      }).catch(err => {
        console.log(err)
      })
    }

    onMounted(() => {
      getBaseInfo()
      getItems()
    })

    return {
      handleTableChange,
      dataSource,
      columns,
      pagination,
      id,
      data,
      groups
    }
  }
})
</script>

  <style lang="less">
.case-info {
  background-color: white;
  padding: 10px 20px;
}
  .case-list {
    margin-top: 10px;
  }
  </style>
