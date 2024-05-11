<template>
  <a-layout-sider width="200" class="sidebar">
    <a-menu v-model:selectedKeys="selectedKeys" v-model:openKeys="openKeys" mode="inline" class="menu" theme="dark">
      <a-sub-menu key="sub1">
        <template #title>
          <span>
            <monitor-outlined />&nbsp;
            H5巡检
          </span>
        </template>
        <a-menu-item key="/stat">
          <router-link to="/stat">数据看板</router-link>
        </a-menu-item>
        <a-menu-item key="/case">
          <router-link to="/case">H5用例</router-link>
        </a-menu-item>
        <a-menu-item key="/test-plan">
          <router-link to="/test-plan">巡检记录</router-link>
        </a-menu-item>
        <a-menu-item key="/help">
          <router-link to="/help">使用帮助</router-link>
        </a-menu-item>
      </a-sub-menu>
    </a-menu>
  </a-layout-sider>
</template>

<script lang="ts">
import { MonitorOutlined } from '@ant-design/icons-vue'
import { defineComponent, ref, onMounted } from 'vue'
import { useRoute } from 'vue-router';
export default defineComponent({
  components: {
    MonitorOutlined
  },
  setup() {
    let selectedKeys = ref<string[]>(['/case'])
    const route = useRoute()

    onMounted(() => {
      setTimeout(() => {
        console.log('path:' + route.path)
        selectedKeys.value = [route.path]
      }, 0)
    })

    return {
      selectedKeys,
      openKeys: ref<string[]>(['sub1'])
    }
  }
})
</script>

<style>
.sidebar {
  height: calc(100vh - 64px);
  overflow: auto;
  background-color: #001529;
}

.menu {
  height: 100%;
  border-right: 0;
}

#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
