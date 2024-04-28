<template>
  <div class="h5-monitor">
    <a-form class="form-search" ref="formRef" :model="formState" name="horizontal_login" layout="inline"
      autocomplete="off" @finish="onFinish">
      <a-row :wrap="true" class="w-100">
        <a-col :span="10">
          <a-form-item label="创建日期" name="range-picker">
            <a-range-picker v-model:value="formState['range-picker']" format="YYYY-MM-DD" value-format="YYYY-MM-DD" />
          </a-form-item>
        </a-col>
        <a-col :span="8">
          <a-form-item label="页面标题" name="title">
            <a-input v-model:value="formState.title" :allowClear="true">
            </a-input>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label="业务线" name="groupId">
            <a-select v-model:value="formState.groupId" placeholder="请选择业务线" :allowClear="true">
              <a-select-option value="1">分组A</a-select-option>
              <a-select-option value="2">分组B</a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
      </a-row>
      <a-row class="w-100" style="margin-top: 10px;">
        <a-col :span="24" style="text-align: right">
          <a-button type="primary" html-type="submit">查询</a-button>
          <a-button style="margin: 0 8px" @click="() => formRef.resetFields()">重置</a-button>
          <a-button type="primary" class="hand mr-4" html-type="text" @click="toPage('/case/add')">新增</a-button>
        </a-col>
      </a-row>
    </a-form>
    <a-table :dataSource="dataSource" :columns="columns" :pagination="pagination" :loading="loading" class="form-list"
      @change="handleTableChange">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key === 'operation'">
          <a class="hand mr-4"><router-link :to="{ path: '/case/info/' + record.id }">执行结果</router-link></a>
          <a-divider type="vertical" />
          <a-divider type="vertical" />
          <a class="mr-4"><router-link :to="{ path: '/case/edit/' + record.id }">修改</router-link></a>
          <a-divider type="vertical" v-if="record.datumAddress" />
          <a-dropdown v-if="record.datumAddress">
            <template #overlay>
              <a-menu @click="handleMenuClick">
                <a-menu-item key="detail" v-if="record.datumAddress" :href="picURL + '?imageName=' + record.datumAddress"
                  target="_blank">查看</a-menu-item>
                <a-menu-item key="reset" :id="record.id.toString()">重置</a-menu-item>
              </a-menu>
            </template>
            <a-button type="link">
              基准值
              <DownOutlined />
            </a-button>
          </a-dropdown>
          <a-divider type="vertical" />
          <a-popconfirm v-if="dataSource.length" title="确认删除?" @confirm="onDelete(record.id)">
            <a-typography-text type="danger" class="hand">删除</a-typography-text>
          </a-popconfirm>
        </template>
      </template>
    </a-table>
  </div>
</template>

<script lang="ts" setup>
import { reactive, onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { getOnlinespatrolList, delOnlinespatrol, resetDatum } from '@/api/index'
import { getGroup } from '@/common/util'
import moment from 'moment'
import type { MenuProps } from 'ant-design-vue'
import { baseURL } from '@/api/service'
import Path from '@/api/path'

interface FormState {
  title: string
  groupId: string
  'range-picker': [string, string]
}

const picURL = (baseURL + Path.getDatum) || ''
const formRef = ref()
const loading = ref(false)
const formState = reactive<FormState>({
  title: '',
  groupId: '',
  'range-picker': ['', '']
})
const dataSource = ref<any[]>([])
const router = useRouter()

function toPage(path: string) {
  router.push(path)
}

const columns = [
  {
    title: 'ID',
    dataIndex: 'id',
    width: 50,
    key: 'id'
  }, {
    title: '页面',
    dataIndex: 'title',
    width: 150,
    key: 'title'
  },
  {
    title: '巡检URL',
    dataIndex: 'url',
    width: 200,
    key: 'url'
  },
  {
    title: '业务线',
    dataIndex: 'groupId',
    width: 120,
    key: 'groupId',
    customRender: ({ record }: any) => record && record.groupId ? getGroup(record.groupId) : ''
  },
  {
    title: '创建时间',
    dataIndex: 'createtime',
    width: 160,
    key: 'createtime',
    ellipsis: true,
    customRender: ({ record }: any) => record && record.createtime ? moment(record.createtime).format('YYYY-MM-DD HH:mm:ss') : ''
  },
  {
    title: '备注说明',
    dataIndex: 'htmlinfo',
    width: 120,
    key: 'htmlinfo',
    ellipsis: true
  },
  {
    title: '操作',
    width: 180,
    dataIndex: 'operation',
    key: 'operation',
    fixed: 'right'
  }
]

const pagination = reactive({
  total: 0,
  pageNum: 1,
  pageSize: 10,
  current: 1,
  'show-total': (total: string) => `共 ${total} 条`
})

const onFinish = () => {
  getItems(1)
}

const handleTableChange = (p: any) => {
  pagination.pageNum = p.current
  pagination.pageSize = p.pageSize
  getItems(p.current)
}

const onDelete = (id: string) => {
  loading.value = true
  delOnlinespatrol({ id }).then(() => {
    getItems(1)
  }).finally(() => loading.value = false)
}

const getItems = (pageNum?: number) => {
  loading.value = true
  const _pageNum = pageNum || pagination.pageNum
  const picker = formState['range-picker']
  const params = {
    startTime: picker ? picker[0] : undefined,
    endTime: picker ? picker[1] : undefined,
    title: formState.title,
    groupId: formState.groupId,
    pageNum: _pageNum,
    pageSize: pagination.pageSize
  }
  getOnlinespatrolList(params).then((res: any) => {
    dataSource.value = res.list.map((item: any) => {
      return {
        ...item,
        key: item.id
      }
    })
    pagination.total = res.total
    pagination.pageNum = _pageNum || 1
    pagination.current = _pageNum || 1
    console.log('pagination', pagination)
  }).catch(err => {
    console.log(err)
  }).finally(() => {
    loading.value = false
  })
}

onMounted(() => {
  getItems()
})

// 重置基准值
const resetBasePic = (id: any) => {
  resetDatum({ id }).then(() => {
    getItems(1)
  })
}

const handleMenuClick: MenuProps['onClick'] = e => {
  const { item, key } = e
  if (key === 'detail' && item.href) {
    window.open(item.href, '_blank')
  } else if (key === 'reset') {
    resetBasePic(item.id)
  }
}
</script>

<style lang="less">
.form-search {
  padding: 20px;
  background-color: white;
  border-left: 4px solid #1890ff;
}

.form-list {
  margin-top: 10px;
}
</style>
