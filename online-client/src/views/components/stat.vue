<template>
    <a-row>
      <a-col :span="6">
        <a-statistic title="巡检次数" :value="planCount" style="margin-right: 50px" />
      </a-col>
      <a-col :span="6">
        <a-statistic title="用例失败数" :value="failedCaseCount"  :value-style="{ color: failedCaseCount>failedCaseCountBefore? 'red': 'green' }">
          <template #prefix >
            <arrow-up-outlined v-if="failedCaseCountBefore && failedCaseCount>failedCaseCountBefore"/>
            <arrow-down-outlined v-if="failedCaseCountBefore && failedCaseCount<failedCaseCountBefore"/>
          </template>
        </a-statistic>
      </a-col>
      <a-col :span="6">
        <a-statistic title="执行超长数(>3s)" :value="timeoutCaseCount" style="margin-right: 50px" :value-style="{ color: timeoutCaseCount>timeoutCaseCountBefore? 'red': 'green' }">
          <template #prefix >
            <arrow-up-outlined v-if="timeoutCaseCountBefore && timeoutCaseCount>timeoutCaseCountBefore"/>
            <arrow-down-outlined v-if="timeoutCaseCountBefore && timeoutCaseCount<timeoutCaseCountBefore"/>
          </template>
        </a-statistic>
      </a-col>
    </a-row>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { getH5Stat } from '@/api/index'
import { ArrowUpOutlined, ArrowDownOutlined } from '@ant-design/icons-vue'

const failedCaseCount = ref(0)
const timeoutCaseCount = ref(0)
const failedCaseCountBefore = ref(0)
const timeoutCaseCountBefore = ref(0)
const planCount = ref(0)
let _beginDate = 0
let _endDate = 0

const getData = (beginDate: number, endDate: number, group: number) => {
  const params = {
    beginDate: beginDate,
    endDate: endDate,
    group
  }
  getH5Stat(params).then((res: any) => {
    _beginDate = beginDate
    _endDate = endDate
    failedCaseCount.value = res.failedCaseCount
    timeoutCaseCount.value = res.timeoutCaseCount
    planCount.value = res.planCount
    failedCaseCountBefore.value = res.failedCaseCountBefore
    timeoutCaseCountBefore.value = res.timeoutCaseCountBefore
  })
}
defineExpose({
  getData
})
</script>
