import axios from 'axios'
import { message } from 'ant-design-vue'

// 获取当前页面的HOST
const getHost = () => {
  const { protocol, host } = window.location;
  return `${protocol}//${host}`;
};

export const baseURL = getHost();
const service = axios.create({
  withCredentials: true,
  baseURL,
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
    } else if (response.data.code == "-1") {
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
      message.error(response.message || '请求错误~')
      return Promise.reject(response)
    }
    return true
  }
)
export default service
