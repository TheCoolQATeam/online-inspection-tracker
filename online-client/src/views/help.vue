<template>
    <div class="wrapper">
      <div>
        <h1>一、H5页面接入巡检平台</h1>
        <!-- <p class="content" style="color: red;">注意：支持需要登录的H5页面</p> -->
        <div class="content flex">
          <img src="../assets/images/insert.png" style="width: 500px;"/>
          <ul>
            <li>页面标题：<span style="color: red;">这里的标题必须和H5页面标题保持一致</span></li>
            <li>巡检URL地址：H5链接</li>
            <li>告警人：xiaoming,xiaohong <span style="color: red;"></span></li>
            <li>说明：备注信息</li>
            <li>业务线</li>
          </ul>
        </div>
      </div>
      <div>
        <h1>二、接收告警信息</h1>
        <h2>1、页面加载异常</h2>
        <p class="content">
          <img src="../assets/images/qiweigaojing.png"  style="width: 500px;"/>
        </p>
        <h2>2、页面截屏图片像素对比异常</h2>
        <p class="content">
          <img src="../assets/images/gaojing2.png"  style="width: 500px;"/>
        </p>
      </div>
    </div>
</template>
<script lang="ts">
import { defineComponent, computed, toRefs } from 'vue'
export default defineComponent({
  name: 'h5MonitorData',
  setup (props, { emit }) {
    // dui de
  }
})
</script>
<style scoped lang="less">
.wrapper {
  background-color: white;
  padding: 10px;
  h1 {
    font-size: 20px;
  }
  h2 {
    font-size: 16px;
    padding: 10px;
  }
  .content {
    padding: 10px;
    &.flex {
      display: flex;
      flex-wrap: nowrap;
      img {
        width: 500px;
      }
      ul {
        padding-left: 50px;
        li {
          line-height: 40px;
        }
      }
    }
  }
}
</style>
