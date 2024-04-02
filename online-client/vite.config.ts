import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'

export default defineConfig({
  plugins: [
    vue(),
    vueJsx(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  define: {
    'process.env': process.env
  },
  server: {  
    proxy: {  
      '^/patrol': {  
        target: 'https://jzjysys-qa-stable.djtest.cn', // 代理目标地址  
        changeOrigin: true, // 开启代理，在本地会创建一个虚拟服务端，然后发送请求的数据，同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题  
        // rewrite: (path) => path.replace(/^\/api/, '') // 重写请求，例如将前缀 /api 去除  
      },
    }
  }  
})
