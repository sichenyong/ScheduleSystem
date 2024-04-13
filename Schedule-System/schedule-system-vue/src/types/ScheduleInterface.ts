// 定义一个日程的接口
export interface ScheduleInter {
    sid: number;
    uid: number;
    title: string;
    completed: number;
}
export type ScheduleList = ScheduleInter[];