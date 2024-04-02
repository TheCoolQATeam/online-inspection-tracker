<template>
  <a-layout-header class="header">
    <div class="logo" >
    线上巡检系统
  </div>
    <!-- <a class="github"><GithubOutlined /></a> -->
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
// import { GithubOutlined } from '@ant-design/icons-vue'
import { clearCookie } from '@/common/util'
import { loginURL } from '@/api/service'

export default defineComponent({
  components: {
    // GithubOutlined
  },
  setup () {
    const userName = '联系我们'
    const toLoginOut = () => {
      clearCookie()
      window.location.href = loginURL + location.href
    }
    return {
      userName,
    }
  }
})
</script>

<style lang="less" scoped>
.header {
  padding: 0px 24px 0px 0px;
  color: #333;
  background-color: white;
  .logo {
    width: 200px;
    padding-left: 24px;
    display: inline-block;
    background-color: #001529;
    color: white;
  }
  .title {
    color: white;
  }
  .github {
    float: right;
  }
  // .user-dropdown-link {
  //   float: right;
  // }

}
</style>
