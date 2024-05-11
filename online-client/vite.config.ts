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
    'process.env': process.env,
    'process.argv':  process.argv
  },
  server: {
    host: '127.0.0.1',  
    // proxy: {  
    //   '^/patrol': {  
    //     target: 'http://127.0.0.1:9091', // 代理目标地址  
    //     changeOrigin: true, // 开启代理，在本地会创建一个虚拟服务端，然后发送请求的数据，同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题  
    //   },
    // }
  }  
})
