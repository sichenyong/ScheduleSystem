import { reactive, ref } from "vue";
// 引入axios
import request from '@/utils/request'
// 引入路由器
import router from '@/router'
// 引入user的pinia
import { useUserStore } from "@/store/userStore";
export default function () {
    // 数据
    let userPwdMsg = ref('');
    let usernameMsg = ref('');
    let loginUser = reactive({
        username: '',
        userPwd: '',
    })
    // 函数
    /**
     * @description: 校验用户名格式
     * @returns 
     */
    function checkUsername() {
        let usernameReg = /^[a-zA-Z0-9]{5,10}$/
        if (!usernameReg.test(loginUser.username)) {
            usernameMsg.value = '格式有误'
            return false;
        }
        usernameMsg.value = 'ok'
        return true;
    }
    /**
     * @description: 校验密码格式
     * @returns 
     */
    function checkUserPwd() {
        let passwordReg = /^[0-9]{6}$/
        if (!passwordReg.test(loginUser.userPwd)) {
            userPwdMsg.value = '格式有误'
            return false;
        }
        userPwdMsg.value = 'ok'
        return true;
    }
    /**
     * @description: 登录逻辑
     */
    async function login() {
        let f1 = checkUsername();
        let f2 = checkUserPwd();
        if (!(f1 && f2)) {
            return;
        }
        // 发送异步请求
        let { data } = await request.post('user/login', loginUser)
        if (data.code === 200) {
            alert('登录成功');
            let userSession = data.data.loginUser;
            let user = useUserStore();
            user.$patch({
                uid: userSession.uid,
                username: userSession.username
            })
            // 登录成功
            router.push('/ShowSchedule')
            // 存储用户信息
        }
        else if (data.code === 501) {
            alert('用户名错误');
            // 账户密码清空
            loginUser.username = '';
            loginUser.userPwd = '';
            usernameMsg.value = '';
            userPwdMsg.value = '';
        }
        else if (data.code === 503) {
            alert('密码错误');
            loginUser.username = '';
            loginUser.userPwd = '';
            usernameMsg.value = '';
            userPwdMsg.value = '';
        }
    }
    // 函数返回值
    return { userPwdMsg, usernameMsg, loginUser, checkUsername, checkUserPwd, login };
}