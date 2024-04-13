package com.scy.Dao;

import com.scy.Entity.SysSchedule;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Date：2023/12/24 11:14
 * @description：
 */
public interface SysScheduleDao {
    /**
     * @description: 向数据中增加一条日程记录
     * @param: [sysSchedule] 日程数据以SysSchedule实体类对象形参传入
     * @return 返回影响数据库记录的行数, 行数为0说明增加失败，行数大于0说明成功
     **/
    int addSchedule(SysSchedule sysSchedule);

    /**
     * @description: 查询所有用户的日程
     * @param: []
     * @return: 返回值是所有的用户日程信息
     **/
    List<SysSchedule> selectAllSchedule();

    /**
     * @description:根据uid查询相关的安排
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 10:31
     * @param: [uid]
     * @return: java.util.List<com.scy.Entity.SysSchedule>
     **/
    List<SysSchedule> queryScheduleByUid(Integer uid);

    /**
     * @description: 向id为uid的用户添加默认日程
     * @param: [uid]
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 11:20
     * @param: [uid]
     * @return: int
     **/
    int addDefaultSchedule(Integer uid);

    /**
     * @description: 更新日程的dao接口
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 15:16
     * @param: [sysSchedule]
     * @return: int
     **/
    int updateSchedule(SysSchedule sysSchedule);
}
