<template>
    <div>
        <h3 class="ht">您的日程如下</h3>
        <table class="tab" cellspacing="0px">
            <tr class="ltr">
                <th>编号</th>
                <th>内容</th>
                <th>进度</th>
                <th>操作</th>
            </tr>
            <tr class="ltr" v-for="(item, index) in itemList" :key="item.sid">
                <td>{{ item.sid }}</td>
                <td>
                    <input type="text" v-model="item.title" placeholder="请输入日程内容">
                </td>
                <td>
                    <input type="radio" :value="0" v-model="item.completed"> 未完成
                    <input type="radio" :value="1" v-model="item.completed"> 已完成
                </td>
                <td class="buttonContainer">
                    <button class="btn1">删除</button>
                    <button class="btn1" @click="editSchedule(index)">保存修改</button>
                </td>
            </tr>
            <tr class="ltr buttonContainer">
                <td colspan="4">
                    <button class="btn1" @click="addSchedule">新增日程</button>
                </td>
            </tr>
        </table>
    </div>
</template>
<script lang="ts" setup name="ShowSchedule">
import useSchedule from '@/hooks/useSchedule';
import { useScheduleStore } from '@/store/scheduleStore';
import { storeToRefs } from 'pinia';
// 结构出响应式数据
const { itemList } = storeToRefs(useScheduleStore())
const { addSchedule, editSchedule } = useSchedule();
</script>
<style scoped>
.ht {
    text-align: center;
    color: cadetblue;
    font-family: 幼圆;
}

.tab {
    width: 80%;
    border: 5px solid cadetblue;
    margin: 0px auto;
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
    width: 100px;
    background-color: antiquewhite;
}

#usernameMsg,
#userPwdMsg {
    color: gold;
}

.buttonContainer {
    text-align: center;
}</style>