// 引入路由器
import { createRouter, createWebHistory } from 'vue-router'
// 引入路由组件
import Login from '@/pages/Login.vue'
import Regist from '@/pages/Regist.vue'
import ShowSchedule from '@/pages/ShowSchedule.vue'
// 导入useUserStore
import { useUserStore } from '@/store/userStore';
import { createPinia } from 'pinia';
// 获取user对象
let user = useUserStore(createPinia());
// 创建路由器
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/showSchedule',
            component: ShowSchedule,
            meta: { title: '日程安排页面' }
        },
        {
            path: '/login',
            component: Login,
            meta: { title: '登录页' }
        },
        {
            path: '/regist',
            component: Regist,
            meta: { title: '注册页' }
        },
        {
            path: '/',
            redirect: '/login'
        },
    ]
});
// 全局后置守卫
router.afterEach((to, from) => {
    document.title = to.meta.title as string;
})
// 全局前置守卫, 判断是否可以访问showSchedule
router.beforeEach((to, from, next) => {
    if (to.path === '/showSchedule') {
        // 判断是否登录
        if (user.username === '') {
            next('/login');
        }
        else {
            next();
        }
    } else {
        // 放行
        next();
    }
})
// 向外暴露
export default router;