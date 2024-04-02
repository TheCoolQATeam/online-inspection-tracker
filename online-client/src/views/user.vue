<template>
    <a-modal v-model:open="isShow" title="告警人" @ok="onOk" @cancel="onClose">
        <a-textarea v-model:value="data.username" readonly disabled />
    </a-modal>
</template>
<script lang="ts">
import { defineComponent, computed, toRefs } from 'vue'
export default defineComponent({
  name: 'userNotify',
  props: ['item', 'visible'],
  setup (props, { emit }) {
    const { item } = toRefs(props)
    const data = item
    const isShow = computed(() => props.visible)

    const onOk = () => {
      emit('onOk')
    }
    const onClose = () => {
      emit('onClose')
    }

    return {
      isShow,
      onOk,
      onClose,
      data,
      open
    }
  }
})
</script>
