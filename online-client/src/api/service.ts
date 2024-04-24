import axios from 'axios'
import { message } from 'ant-design-vue'

const baseURL = process.env.VUE_APP_HOST || ''
export const loginURL = process.env.VUE_APP_INPASS_LOGIN || ''
console.log('loginURL', loginURL, baseURL, process.env.VUE_APP_MODE)


const service = axios.create({
  withCredentials: true,
  baseURL: baseURL,
  timeout: 15000
})

service.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => Promise.reject(error)
)

service.interceptors.response.use(
  (response: any) => {
    if (response.data.code == 0) {
      return Promise.resolve(response.data.data || true)
    } else if (response.data.code == "-1") {  // 登录拦截
      // window.location.href = loginURL + location.href
      message.error(response?.data?.codeMsg || '请求错误~')
      return Promise.resolve(response.data || true)
    } else {
      message.error(response?.data?.message || '请求错误~')
      return Promise.reject(response.data)
    }
  },
  (err) => {
    const { response } = err
    if (response) {
      if (response.status === 401) {
        // window.location.href = loginURL + encodeURIComponent(location.href)
      }
      message.error(response.message || '请求错误~')
      return Promise.reject(response)
    }
    return true
  }
)
export default service
