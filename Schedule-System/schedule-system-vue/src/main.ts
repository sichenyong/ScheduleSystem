import { createApp } from 'vue'
import App from './App.vue'
// 引入路由器
import router from '@/router'
// 引入pinia构造器
import { createPinia } from 'pinia'
const app = createApp(App);
const pinia = createPinia();
// 使用pinia
app.use(pinia);
// 使用路由器
app.use(router);

app.mount('#app')
