package com.scy.test;

import com.scy.Dao.SysScheduleDao;
import com.scy.Dao.impl.SysScheduleDaoImpl;
import com.scy.Entity.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.test
 * @Project：web-all
 * @Date：2023/12/24 19:59
 * @description：
 */
public class TestSysSchedule {
    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void initSysScheduleDao() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule() {
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null, 2, "学习javaweb", 0));
        System.out.println(rows);
    }
}
