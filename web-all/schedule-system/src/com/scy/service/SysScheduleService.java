package com.scy.service;

import com.scy.Entity.SysSchedule;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.service
 * @Project：web-all
 * @Date：2023/12/24 20:04
 * @description：
 */
public interface SysScheduleService {
    /**
     * @description: 根据用户uid查询数据库中的相关安排
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 10:29
     * @param: [uid]
     * @return: java.util.List<com.scy.Entity.SysSchedule>
     **/
    List<SysSchedule> query(Integer uid);

    /**
     * @description:向uid的用户添加一条默认日程
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 11:19
     * @param: [uid]
     * @return: int
     **/
    int addDefaultSchedule(Integer uid);

    /**
     * @description: 更新日程sysSchedule
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 15:15
     * @param: [sysSchedule]
     * @return: int
     **/
    int updateSchedule(SysSchedule sysSchedule);
}
