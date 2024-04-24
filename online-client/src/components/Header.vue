<template>
  <a-layout-header class="header">
    <div class="logo" >
    线上巡检系统
  </div>
  </a-layout-header>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  setup () {
    const userName = '联系我们'
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
