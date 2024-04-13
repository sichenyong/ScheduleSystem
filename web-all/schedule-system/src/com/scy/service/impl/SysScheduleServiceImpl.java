package com.scy.service.impl;

import com.scy.Dao.SysScheduleDao;
import com.scy.Dao.impl.SysScheduleDaoImpl;
import com.scy.Entity.SysSchedule;
import com.scy.service.SysScheduleService;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.service.impl
 * @Project：web-all
 * @Date：2023/12/24 20:05
 * @description：
 */
public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao sysScheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> query(Integer uid) {
        // 调用dao层的方法查询结果并返回
        return sysScheduleDao.queryScheduleByUid(uid);
    }

    @Override
    public int addDefaultSchedule(Integer uid) {
        return sysScheduleDao.addDefaultSchedule(uid);
    }

    /**
     * @description: 更新日程接口
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 15:15
     * @param: [sysSchedule]
     * @return: int
     **/
    @Override
    public int updateSchedule(SysSchedule sysSchedule) {
        return sysScheduleDao.updateSchedule(sysSchedule);
    }
}
