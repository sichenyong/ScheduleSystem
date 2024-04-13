import { defineStore } from "pinia";
import { ref, reactive } from 'vue';
// 引入限制类型
import { type ScheduleList } from '@/types/ScheduleInterface'
export const useScheduleStore = defineStore('schedule', {
    actions: {},
    state() {
        return {
            itemList: <ScheduleList>[],
        }
    }
})