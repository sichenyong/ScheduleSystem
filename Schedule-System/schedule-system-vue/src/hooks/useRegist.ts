// 引入axios
import request from '@/utils/request';
// 引入路由器
import router from '@/router';
import { ref, reactive } from 'vue'
export default function () {
    // 数据
    let registUser = reactive({
        username: '',
        userPwd: '',
    });
    let reUserPwd = ref('')
    // 提示信息
    let usernameMsg = ref('');
    let userPwdMsg = ref('');
    let reUserPwdMsg = ref('');
    /**
     * @description: 校验注册的用户名是否正确
     * @returns 
     */
    async function checkUsername() {
        let usernameReg = /^[a-zA-Z0-9]{5,10}$/;
        if (!usernameReg.test(registUser.username)) {
            usernameMsg.value = '格式有误';
            return false;
        }
        // 发送axios异步请求，校验用户名是否存在
        let { data } = await request.get('user/checkUsername', {
            params: {
                username: registUser.username
            }
        })
        if (data.code !== 200) {
            usernameMsg.value = '用户名已存在';
            return false;
        }
        usernameMsg.value = 'ok';
        return true;
    }
    /**
     * @description: 校验注册的密码是否正确
     * @returns 
     */
    function checkUserPwd() {
        let passwordReg = /^[0-9]{6}$/;
        if (!passwordReg.test(registUser.userPwd)) {
            userPwdMsg.value = '格式有误';
            return false;
        }
        userPwdMsg.value = 'ok';
        return true;
    }
    /**
     * @description: 校验第二次输入的密码是否正确
     * @returns 
     */
    function checkReUserPwd() {
        let passwordReg = /^[0-9]{6}$/;
        // 密码格式是否正确
        if (!passwordReg.test(reUserPwd.value)) {
            reUserPwdMsg.value = '格式有误';
            return false;
        }
        // 两次密码是否一致
        if (reUserPwd.value !== registUser.userPwd) {
            reUserPwdMsg.value = '两次密码输入不一致！';
            return false;
        }
        reUserPwdMsg.value = 'ok';
        return true;
    }
    /**
     * @description: 注册逻辑
     */
    async function regist() {
        // 1. 判断用户名 密码是否正确
        let flag1 = await checkUsername();
        let flag2 = checkUserPwd();
        let flag3 = checkReUserPwd();
        if (flag1 && flag2 && flag3) {
            alert('注册成功！');
            // 发送异步请求
            let { data } = await request.post('user/regist', registUser
            )
            if (data.code === 200) {
                alert('注册成功！快去登录吧');
                // 路由重定向
                router.replace('/login');
            }
            else {
                alert('注册失败！用户名已经被抢占了~');
            }
        }
        else {
            alert('格式有误，注册失败！')
        }
    }
    return {
        registUser,
        reUserPwd,
        usernameMsg,
        userPwdMsg,
        reUserPwdMsg,
        checkUsername,
        checkUserPwd,
        checkReUserPwd,
        regist,
    }
}