<template>
    <div>
        <h3 class="ht">请注册</h3>
        <table class="tab" cellspacing="0px">
            <tr class="ltr">
                <td>请输入账号</td>
                <td>
                    <input class="ipt" id="usernameInput" type="text" name="username" v-model="registUser.username"
                        @blur="checkUsername()">
                    <span id="usernameMsg" class="msg" v-text="usernameMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td>请输入密码</td>
                <td>
                    <input class="ipt" id="userPwdInput" type="password" name="userPwd" v-model="registUser.userPwd"
                        @blur="checkUserPwd()">
                    <span id="userPwdMsg" class="msg" v-text="userPwdMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td>确认密码</td>
                <td>
                    <input class="ipt" id="reUserPwdInput" type="password" v-model="reUserPwd" @blur="checkReUserPwd()">
                    <span id="reUserPwdMsg" class="msg" v-text="reUserPwdMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td colspan="2" class="buttonContainer">
                    <input class="btn1" type="button" value="注册" @click="regist()">
                    <input class="btn1" type="button" value="重置">
                    <router-link to="/login">
                        <button class="btn1">去登录</button>
                    </router-link>
                </td>
            </tr>
        </table>
    </div>
</template>
<script lang="ts" setup name="Regist">
import useRegist from '@/hooks/useRegist'
let {
    registUser,
    reUserPwd,
    usernameMsg,
    userPwdMsg,
    reUserPwdMsg,
    checkUsername,
    checkUserPwd,
    checkReUserPwd,
    regist,
} = useRegist()
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
#userPwdMsg,
#userPwdMsg1 {
    color: red;
}

.buttonContainer {
    text-align: center;
}
</style>