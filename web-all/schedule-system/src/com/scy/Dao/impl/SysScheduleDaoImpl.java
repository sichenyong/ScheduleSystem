package com.scy.Dao.impl;

import com.scy.Dao.BaseDao;
import com.scy.Dao.SysScheduleDao;
import com.scy.Entity.SysSchedule;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.Dao.impl
 * @Project：web-all
 * @Date：2023/12/24 11:18
 * @description：
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";

        int rows = baseUpdate(sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());

        return rows;
    }

    @Override
    public List<SysSchedule> selectAllSchedule() {
        String sql = "select * from sys_schedule";

        return baseQuery(SysSchedule.class, sql);
    }

    /**
     * @description:根据uid查询用户的日程安排
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 10:33
     * @param: [uid]
     * @return: java.util.List<com.scy.Entity.SysSchedule>
     **/
    @Override
    public List<SysSchedule> queryScheduleByUid(Integer uid) {
        String sql = "select sid, uid, title, completed from sys_schedule where uid = ?";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql, uid);

        return scheduleList;
    }

    @Override
    public int addDefaultSchedule(Integer uid) {
        String sql = "insert sys_schedule values(DEFAULT,?,'',0)";

        return baseUpdate(sql,uid);
    }

    @Override
    public int updateSchedule(SysSchedule sysSchedule) {
        String sql = "update sys_schedule set title = ?, completed = ? where sid = ?";
        // 调用底层的方法
        return baseUpdate(sql, sysSchedule.getTitle(), sysSchedule.getCompleted(), sysSchedule.getSid());
    }
}
