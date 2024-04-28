<template>
    <div class="wrapper">
      <div>
        <h1>一、H5页面接入巡检平台</h1>
        <!-- <p class="content" style="color: red;">注意：开源版本暂不支持登录的H5页面，若需支持，请二次开发或群组咨询</p> -->
        <div class="content flex">
          <img src="../assets/images/add.png" style="width: 600px;"/>
          <ul>
            <li>页面标题：<span style="color: red;">这里的标题必须和H5页面标题保持一致</span></li>
            <li>巡检URL地址：H5链接</li>
            <li>业务线：可将用例进行分组管理</li>
            <li>钉钉告警机器人access_token：https://oapi.dingtalk.com/robot/send?access_token=xx，只需要填写 xx 值。不填写，则不发告警</li>
            <li>企微告警机器人Key：https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=xx，只需要填写 xx值。不填写，则不发告警</li>
            <li>飞书告警机器人Key：https://open.feishu.cn/open-apis/bot/v2/hook/xx，只需要填写 xx 值。不填写，则不发告警</li>
          </ul>
        </div>
      </div>
      <div>
        <h1>二、接收告警信息</h1>
        <h2>1、页面加载异常</h2>
        <p class="content">
          <img src="../assets/images/gj-load.png"  style="width: 500px;"/>
        </p>
        <h2>2、页面截屏图片像素对比异常</h2>
        <p class="content">
          <img src="../assets/images/gj-xs.png"  style="width: 500px;"/>
        </p>
      </div>
      <div>
        <h1>三、查看相关数据</h1>
        <h2>1、每日巡检记录</h2>
        <p class="content">
          <img src="../assets/images/log.png"  style="width: 800px;"/>
        </p>
        <h2>2、数据看板</h2>
        <p class="content">
          <img src="../assets/images/stat.png"  style="width: 800px;"/>
        </p>
      </div>
    </div>
</template>
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
          line-height: 32px;
        }
      }
    }
  }
}
</style>
