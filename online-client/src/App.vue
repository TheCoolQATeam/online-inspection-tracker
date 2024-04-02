<template>
  <a-config-provider :locale="local">
    <a-layout class="main">
      <MyHeader />
      <a-layout>
        <Sidebar />
        <a-layout>
          <a-layout-content
            :style="contentStyle">
            <router-view />
          </a-layout-content>
        </a-layout>
      </a-layout>
    </a-layout>
  </a-config-provider>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import MyHeader from '@/components/Header.vue'
import Sidebar from '@/components/Sidebar.vue'
import zhCN from 'ant-design-vue/es/locale/zh_CN';
import dayjs from 'dayjs';
import 'dayjs/locale/zh-cn';
dayjs.locale('zh-cn');

export default defineComponent({
  name: 'myHome',
  components: {
    MyHeader,
    Sidebar
  },
  data() {
    const contentStyle = { 
      padding: '0px 24px 0px 24px', 
      marginTop: '24px', 
      minHeight: '280px', 
      overflow: 'scroll' 
    }
    return {
      local: zhCN, 
      contentStyle
    }
  }
})
</script>

<style lang="less">
* {
  box-sizing: border-box;
}

.main {
  height: 100vh;
}
</style>