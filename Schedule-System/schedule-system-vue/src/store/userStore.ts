import { defineStore } from "pinia";
export const useUserStore = defineStore('user', {
    actions: {},
    state() {
        return {
            uid: 0,
            username: '',
        }
    }
});