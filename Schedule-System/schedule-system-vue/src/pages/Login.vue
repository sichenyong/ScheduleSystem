<template>
    <div>
        <h3 class="ht">请登录</h3>
        <table class="tab" cellspacing="0px">
            <tr class="ltr">
                <td>请输入账号</td>
                <td>
                    <input class="ipt" type="text" v-model="loginUser.username" @blur="checkUsername()">
                    <span id="usernameMsg" v-text="usernameMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td>请输入密码</td>
                <td>
                    <input class="ipt" type="password" v-model="loginUser.userPwd" @blur="checkUserPwd()">
                    <span id="userPwdMsg" v-text="userPwdMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td colspan="2" class="buttonContainer">
                    <input class="btn1" type="button" value="登录" @click="login()">
                    <input class="btn1" type="button" value="重置">
                    <router-link to="/regist">
                        <button class="btn1">去注册</button>
                    </router-link>
                </td>
            </tr>
        </table>
    </div>
</template>
<script lang="ts" setup name="Login">
import useLogin from '@/hooks/useLogin';
let { loginUser, usernameMsg, userPwdMsg, checkUsername, checkUserPwd, login } = useLogin();
</script>
<style scoped>
.ht {
    text-align: center;
    color: cadetblue;
    font-family: 幼圆;
}

.tab {
    width: 500px;
    border: 5px solid cadetblue;
    margin: 0 auto;
    border-radius: 5px;
    font-family: 幼圆;
}

.ltr td {
    border: 1px solid powderblue;
}

.ipt {
    border: 0px;
    width: 50%;
}

.btn1 {
    border: 2px solid powderblue;
    border-radius: 4px;
    width: 60px;
    background-color: antiquewhite;
}

#usernameMsg,
#userPwdMsg {
    color: red;
}

.buttonContainer {
    text-align: center;
}</style>