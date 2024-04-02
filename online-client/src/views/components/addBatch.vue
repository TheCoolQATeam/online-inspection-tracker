<template>
    <a-modal v-model:open="isShow" title="批量新增用例" @ok="onOk" @cancel="onClose">
      <a-button class="hand mr-4" style="background-color: #2db7f5;color: white">下载模板</a-button>
      <a-upload
          v-model:file-list="fileList"
          name="file"
          action="/patrol/onlines/uploadExcl"
          @change="handleChange"
          >
          <a-button type="primary" html-type="text">
            <upload-outlined></upload-outlined>
            上传
          </a-button>
        </a-upload>
    </a-modal>
</template>
<script lang="ts">
import { defineComponent, computed, ref } from 'vue'
import type { UploadChangeParam } from 'ant-design-vue'
import { message } from 'ant-design-vue'

export default defineComponent({
  name: 'addBatch',
  props: ['visible'],
  setup (props, { emit }) {
    const isShow = computed(() => props.visible)

    const onOk = () => {
      emit('onOk')
    }
    const onClose = () => {
      emit('onClose')
    }

    const handleChange = (info: UploadChangeParam) => {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList)
      }
      if (info.file.status === 'done') {
        message.success(`${info.file.name} 上传成功`)
      } else if (info.file.status === 'error') {
        message.error(`${info.file.name} 上传失败`, 5)
      }
    }

    const fileList = ref([])

    return {
      isShow,
      onOk,
      onClose,
      open,
      handleChange,
      fileList
    }
  }
})
</script>
