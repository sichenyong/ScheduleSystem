<template>
    <div>
        <h1 class="ht">欢迎使用日程管理系统</h1>
        <div>
            <div class="optionDiv" v-if="user.username === ''">
                <router-link to="/login">
                    <button class="b1s">登录</button>
                </router-link>
                <router-link to="/regist">
                    <button class="b1s">注册</button>
                </router-link>
            </div>
            <div class="optionDiv" v-else>
                欢迎{{ user.username }}
                <button class="b1b" @click="logout">退出登录</button>
                <router-link to="/showSchedule">
                    <button class="b1b">查看我的日程</button>
                </router-link>
            </div>
            <br>
        </div>
    </div>
</template>
<script lang="ts" setup name="Header">
// 导入pinia数据
import { useUserStore } from '@/store/userStore';
import { useScheduleStore } from '@/store/useSchedule';
// 引入路由器
import { useRouter } from 'vue-router';
// 获取路由器
const router = useRouter();
let user = useUserStore();
function logout() {
    // 清除pinia数据
    user.$patch({
        uid: 0,
        username: ''
    })
    console.log(router)
    // 跳转到登录页
    router.replace('/login');
}
</script>
<style scoped>
.ht {
    text-align: center;
    color: cadetblue;
    font-family: 幼圆;
}

.b1s {
    border: 2px solid powderblue;
    border-radius: 4px;
    width: 60px;
    background-color: antiquewhite;
}

.b1b {
    border: 2px solid powderblue;
    border-radius: 4px;
    width: 100px;
    background-color: antiquewhite;
}

.optionDiv {
    width: 300px;
    float: right;
}</style>