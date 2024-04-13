/**
 * @description: 配置axios拦截器，返回axios
 */
// 引入 axios
import axios from "axios";
/**
 * @description: 配置axios的初始化参数
 * @param: baseURL : axios的基础路径
 */
const request = axios.create({
    baseURL: 'http://localhost:8080/',
})
/**
 * @description: 配置axios的请求拦截器，返回的是promise对象
 */
request.interceptors.request.use(
    config => {
        // 发送请求之前做些什么
        return config
    },
    error => {
        // 对请求错误做些什么
        return Promise.reject(error)
    }
)
/**
 * @description: 配置axios的响应拦截器，返回的是promise对象
 */
request.interceptors.response.use(
    response => {
        // 返回promise的响应
        return response
    },
    error => {
        // 处理响应错误
        return Promise.reject(error)
    }
)
export default request;