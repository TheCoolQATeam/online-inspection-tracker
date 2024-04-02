<template>
  <div class="add">
    <a-breadcrumb class="mb-20">
      <a-breadcrumb-item><a href="/#/h5-monitor">H5线上巡检</a></a-breadcrumb-item>
      <a-breadcrumb-item>{{isEdit ? '编辑' : '新增'}}</a-breadcrumb-item>
    </a-breadcrumb>
    <a-form :model="formState" :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item label="页面标题" name="title" :rules="[{ required: true, message: '请输入页面标题' }]">
        <a-input v-model:value="formState.title" />
      </a-form-item>
      <a-form-item label="巡检URL地址" name="url" :rules="[{ required: true, message: '请输入巡检URL地址' }]">
        <a-input v-model:value="formState.url" placeholder="请输入巡检URL地址" :disabled="isEdit"/>
      </a-form-item>
      <a-form-item label="告警人" name="url">
        <a-input v-model:value="formState.username" placeholder="请填写告警人邮箱，逗号分隔"/>
      </a-form-item>
      <a-form-item label="说明" name="htmlinfo">
        <a-input v-model:value="formState.htmlinfo" type="textarea" />
      </a-form-item>
      <a-form-item label="业务线" name="groupId" :rules="[{ required: true, message: '请选择业务线' }]">
        <a-select v-model:value="formState.groupId" placeholder="请选择业务线">
          <a-select-option :value="1">保洁交易平台</a-select-option>
          <a-select-option :value="2">通用平台</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="是否需要登录" name="needLogin" :rules="[{ required: true, message: '请选择业务线' }]">
        <a-select v-model:value="formState.needLogin" placeholder="请选择业务线">
          <a-select-option :value="0">否</a-select-option>
          <a-select-option :value="1">是</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
        <a-button type="primary" @click="onSubmit">提交</a-button>
        <a-button class="ml-10" @click="onCancel">取消</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRaw, ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { addOnlinespatrol, getCaseBaseInfo, updataCaseInfo } from '@/api/index'
import { message } from 'ant-design-vue'

interface FormState {
  id?: string
  title: string;
  groupId: number;
  url: string;
  htmlinfo: string;
  username: string
  needLogin: number
}

export default defineComponent({
  name: 'h5MonitorAdd',
  setup () {
    const router = useRouter()
    const route = useRoute()
    const id = ref('')
    const isEdit = ref(false)
    console.log('route', route.params.id)
    if (route.params && route.params.id) {
      id.value = (route.params.id) as string
      isEdit.value = true
    }

    function toPage (path: string) {
      router.push(path)
    }

    const formState = reactive<FormState>({
      id: '',
      title: '',
      groupId: 1, // 业务线
      url: '',
      htmlinfo: '',
      username: '',
      needLogin: 0
    })

    const onSubmit = () => {
      const params = toRaw(formState)
      const { username } = params
      // 校验邮箱
      if (isEdit.value) {
        params.id = id.value
        updataCaseInfo(params).then((res: any) => {
          message.success(
            '修改成功',
            2
          )
          toPage('/h5-monitor')
        })
      } else {
        delete params.id
        addOnlinespatrol(params).then((res: any) => {
          message.success(
            '新增成功',
            2
          )
          toPage('/h5-monitor')
        })
      }
    }

    const onCancel = () => {
      toPage('/h5-monitor')
    }

    const getBaseInfo = (id: string) => {
      const params = {
        caseId: id
      }
      getCaseBaseInfo(params).then((data: any) => {
        formState.title = data.title
        formState.groupId = Number(data.groupId)
        formState.url = data.url
        formState.htmlinfo = data.htmlinfo
        formState.username = data.username
        formState.needLogin = Number(data.needLogin)
        console.log('data.baseInfo', data)
      }).catch((err: any) => {
        console.log(err)
      })
    }

    onMounted(() => {
      if (id.value) {
        getBaseInfo(id.value)
      }
    })

    return {
      labelCol: { style: { width: '150px' } },
      wrapperCol: { span: 14 },
      formState,
      onSubmit,
      onCancel,
      toPage,
      isEdit
    }
  }
})
</script>

<style lang="less" scoped>
.add {
  min-height: 100px;
  padding: 24px;
  background-color: white;
}
</style>
