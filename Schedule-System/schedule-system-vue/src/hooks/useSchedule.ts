// 引入axios
import request from "@/utils/request";
// 引入pinia数据
import { useScheduleStore } from "@/store/scheduleStore";
// 引入用户的数据
import { useUserStore } from "@/store/userStore";
import { onMounted } from "vue";
export default function () {
    // 获取日程的pinia数据
    const scheduleStore = useScheduleStore();
    // 获取登录的用户信息
    const userStore = useUserStore();
    /**
     * @description: 展示用户的日程,从数据库中读取信息
     * @param uid 
     */
    async function showSchedule(uid: number) {
        // 请求服务器获取数据
        let { data } = await request.get("schedule/queryItemsByUid", { params: { uid } });
        // 提交修改pinia中的数据
        scheduleStore.itemList = data.data.scheduleList;
    }
    /**
     * @description: 添加给用户添加一条默认的日程
     */
    async function addSchedule() {
        let response = await request.get("schedule/addDefaultSchedule", { params: { uid: userStore.uid } })
        console.log(response)
        showSchedule(userStore.uid);
    }
    /**
     * @description: 更新数组中第index个日程的数据
     * @param index：itemList的下标索引
     */
    async function editSchedule(index: number) {
        const obj = scheduleStore.itemList[index]
        let { data } = await request.post('schedule/updateSchedule', obj);
        if (data.code === 200) {
            // 修改成功
            alert('修改成功！');
            showSchedule(obj.uid);
        }
        else {
            alert('服务器异常！');
            return;
        }
    }
    /**
     * @description: 页面刚挂载的时候向服务端发请求，请求用户数据
     */
    onMounted(async () => {
        // 请求服务器获取数据
        let { data } = await request.get("schedule/queryItemsByUid", { params: { uid: userStore.uid } });
        // 提交修改pinia中的数据
        scheduleStore.itemList = data.data.scheduleList;
    })
    return { showSchedule, addSchedule, editSchedule }
}