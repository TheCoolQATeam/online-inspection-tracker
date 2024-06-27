<template>
    <div class="case">
      <h1>今日巡检记录</h1>
      <a-table :dataSource="dataSource" :columns="columns" :pagination="pagination"  class="case-list" :loading="loading"
        @change="handleTableChange">
        <template v-slot:bodyCell="{record, column}">
            <template v-if="column.dataIndex === 'passedNumRate'">
                <span :style="{ color: record.passedNum===record.totalNum? 'green': 'red' }">
                  {{ record.rate }}
                </span>
            </template>
        </template>
        </a-table>
    </div>
  </template>

<script lang="ts" setup>
import { reactive, ref, onMounted } from 'vue'
import { getTestPlanList } from '@/api/index'
import type { TestPlan } from '@/api/type'
import { msToMinutes } from '@/common/util'
import moment from 'moment'

const dataSource = ref<any[]>([])
const loading = ref(true)
const beginDate = ref(0)
const endDate = ref(0)

const columns = [
  {
    title: '巡检ID',
    dataIndex: 'id',
    key: 'id'
  }, {
    title: '用例总数',
    dataIndex: 'totalNum',
    key: 'totalNum'
  }, {
    title: '用例失败数',
    dataIndex: 'failedNum',
    key: 'failedNum'
  },
  {
    title: '用例成功率',
    dataIndex: 'passedNumRate',
    key: 'passedNumRate'
  },
  {
    title: '用例忽略数',
    dataIndex: 'skipedNum',
    key: 'skipedNum'
  },
  {
    title: '执行时间',
    dataIndex: 'beginTime',
    width: '170px',
    key: 'beginTime'
  },
  {
    title: '执行用时(分)',
    dataIndex: 'duration',
    key: 'duration',
    ellipsis: true,
    customRender: ({ record }: any) => msToMinutes(record.duration)
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
  loading.value = true
  const _pageNum = pageNum || pagination.pageNum
  const params = {
    beginDate: beginDate.value,
    endDate: endDate.value,
    pageNum: _pageNum,
    pageSize: pagination.pageSize
  }
  getTestPlanList(params).then((res: any) => {
    dataSource.value = res.list.map((item: TestPlan) => {
      const tmp: string = (item.passedNum / item.totalNum).toFixed(4);
      return {
        ...item,
        key: item.id, 
        rate: (Number(tmp) * 100).toFixed(2) + '%'
      }
    })
    pagination.total = res.total
    pagination.pageNum = _pageNum || 1
    pagination.current = _pageNum || 1
  }).catch(err => {
    console.log(err)
  }).finally(() => loading.value = false)
}
onMounted(() => {
  beginDate.value = Number(moment().format('YYYYMMDD'))
  endDate.value = Number(moment().format('YYYYMMDD'))
  getItems(1)
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
