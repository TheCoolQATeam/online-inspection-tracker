<template>
  <div>
  <h1 class="data-title">
    数据看板
    <a-dropdown class="ml-20">
      <template #overlay>
        <a-menu @click="handleMenuClick">
            <a-menu-item :key="key" v-for="(value, key) in groups">
              <UserOutlined />
              {{ value }}
            </a-menu-item>
        </a-menu>
      </template>
      <a-button>
        {{ selecttedGroup.value }}
        <DownOutlined />
      </a-button>
    </a-dropdown>
  </h1>
  <div class="data-panel">
    <p>
      <a-radio-group :value="range" button-style="solid" @change="hanleChangeTime">
        <a-radio-button value="yesterday" size="small">昨日</a-radio-button>
        <a-radio-button value="7days" size="small">近7日</a-radio-button>
        <a-radio-button value="30days" size="small">近30天</a-radio-button>
      </a-radio-group>
    </p>
  </div>
  <div class="data-top data-panel">
    <StatComponent :beginDate="beginDate" :endDate="endDate" ref="statComponentRef"></StatComponent>
  </div>
  <div class="data-case-failed data-panel">
    <h1>近期失败用例</h1>
    <CaseFailedComponent :beginDate="beginDate" :endDate="endDate" ref="caseFailedComponentRef"></CaseFailedComponent>
  </div>
  <div class="data-case-time data-panel">
    <h1>执行超长用例（>3s）</h1>
    <CaseTimeoutComponent :beginDate="beginDate" :endDate="endDate" ref="caseTimeoutComponentRef"></CaseTimeoutComponent>
  </div>
</div>
</template>
<script lang="ts">
import { defineComponent, ref, onMounted, reactive } from 'vue'
import CaseFailedComponent from './components/caseFailed.vue'
import CaseTimeoutComponent from './components/caseTimeout.vue'
import StatComponent from './components/stat.vue'
import moment from 'moment'
import { groups } from '@/common/data'

export default defineComponent({
  name: 'h5MonitorData',
  components: {
    CaseFailedComponent,
    CaseTimeoutComponent,
    StatComponent
  },
  setup () {
    const range = ref('7days')
    const selecttedGroup = reactive({
      key: 1,
      value: '分组A'
    })
    const beginDate = ref(0)
    const endDate = ref(0)
    const caseFailedComponentRef = ref<any>(null)
    const caseTimeoutComponentRef = ref<any>(null)
    const statComponentRef = ref<any>(null)

    const getRangeTime = (type: string) => {
      if (type === 'yesterday') {
        beginDate.value = Number(moment().subtract(1, 'day').format('YYYYMMDD'))
        endDate.value = Number(moment().subtract(1, 'day').format('YYYYMMDD'))
      } else if (type === '7days') {
        beginDate.value = Number(moment().subtract(6, 'day').format('YYYYMMDD'))
        endDate.value = Number(moment().format('YYYYMMDD'))
        console.log('7dats', beginDate.value)
      } else if (type === '30days') {
        beginDate.value = Number(moment().subtract(29, 'day').format('YYYYMMDD'))
        endDate.value = Number(moment().format('YYYYMMDD'))
        console.log('730dats', beginDate.value)
      }
    }

    const hanleChangeTime = (e: Event) => {
      const val = (e.target as HTMLInputElement).value
      range.value = val
      getRangeTime(val)
      getData(selecttedGroup.key)
    }
    getRangeTime(range.value)

    const getData = (group: number) => {
      statComponentRef.value.getData(beginDate.value, endDate.value, group)
      caseFailedComponentRef.value.getItems(beginDate.value, endDate.value, 1, group)
      caseTimeoutComponentRef.value.getItems(beginDate.value, endDate.value, 1, group)
    }

    onMounted(() => {
      getData(selecttedGroup.key)
    })

    const handleMenuClick = (e: any) => {
      console.log('click', e)
      selecttedGroup.key = e.key
      selecttedGroup.value = groups[e.key]
      // 刷新数据
      getData(selecttedGroup.key)
    }

    return {
      range,
      beginDate,
      endDate,
      statComponentRef,
      caseFailedComponentRef,
      caseTimeoutComponentRef,
      hanleChangeTime,
      handleMenuClick,
      groups,
      selecttedGroup
    }
  }
})
</script>
<style scoped>
.data-title {
  font-size: 24px;
  margin-bottom: 10px;
}

.data-panel {
  background-color: white;
  padding: 10px;
  margin-bottom: 10px;
}

</style>
