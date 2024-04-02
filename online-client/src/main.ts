import './assets/style/index.less'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Antd from 'ant-design-vue'
import App from './App.vue'
import router from './router'
import 'ant-design-vue/dist/reset.css';
import * as antIcon from '@ant-design/icons-vue'
const antIcons: any = antIcon

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Antd)

// 将antDesign图标库的所有图标，每个都注册成组件
Object.keys(antIcons).forEach((key: string) => {
    const com = antIcons[key]
    app.component(key, com)
  })
  
app.mount('#app')
