<template>
    <div class="case">
      <a-table :dataSource="dataSource" :columns="columns" :pagination="pagination"  class="case-list" :loading="loading"
        @change="handleTableChange">
        <template #bodyCell="{ column, record  }">
            <template v-if="column.dataIndex === 'states'">
                <span :style="{color: record.states==1 ? 'black':'red' }">{{ record.states==1 ? '成功': '失败' }}</span>
            </template>
            <template v-if="column.dataIndex === 'responseTime' && record.responseTime&&Number(record.responseTime)>3000 ">
                <a-tag color="yellow">{{ record.responseTime }}</a-tag>
            </template>
            <template v-if="column.dataIndex === 'caseId'">
              <a-button type="link" :href="'/case/info/'+ record.caseId"  target="__blank">{{ record.caseId }}</a-button>
            </template>
        </template>
        </a-table>
    </div>
  </template>

<script lang="ts" setup>
import { reactive, defineExpose, ref, defineProps } from 'vue'
import { getFailedCaseInfo } from '@/api/index'

const dataSource = ref<any[]>([])
const loading = ref(true)
let _beginDate = 0
let _endDate = 0
let _group = 1

const columns = [
  {
    title: '用例ID',
    dataIndex: 'caseId',
    key: 'caseId'
  }, {
    title: '标题',
    dataIndex: 'title',
    key: 'title'
  }, {
    title: '执行ID',
    dataIndex: 'id',
    key: 'id'
  },
  {
    title: '状态',
    dataIndex: 'states',
    key: 'states'
  },
  {
    title: '执行时间',
    dataIndex: 'createTime',
    width: '170px',
    key: 'createTime'
  },
  {
    title: '执行用时(ms)',
    dataIndex: 'responseTime',
    key: 'responseTime'
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
  getItems(_beginDate, _endDate, p.current, _group)
}

const getItems = (beginDate: number, endDate: number, pageNum: number, group: number) => {
  loading.value = true
  const _pageNum = pageNum || pagination.pageNum
  const params = {
    beginDate: beginDate || _beginDate,
    endDate: endDate || _endDate,
    pageNum: _pageNum,
    pageSize: pagination.pageSize,
    group
  }
  getFailedCaseInfo(params).then((res: any) => {
    dataSource.value = res.list.map((item: any) => {
      return {
        ...item,
        key: item.id
      }
    })
    _beginDate = beginDate
    _endDate = endDate
    _group = group
    pagination.total = res.total
    pagination.pageNum = _pageNum || 1
    pagination.current = _pageNum || 1
  }).catch(err => {
    console.log(err)
  }).finally(() => loading.value = false)
}
defineExpose({
  getItems
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
