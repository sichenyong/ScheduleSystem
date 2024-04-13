package com.scy.test;

import com.scy.Dao.BaseDao;
import com.scy.Entity.SysSchedule;
import com.scy.Entity.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.test
 * @Project：web-all
 * @Date：2023/12/24 19:34
 * @description：
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao(){
        baseDao= new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        String sql=  "select count(1) from sys_user";

//        SysUser sysUser = baseDao.baseQueryObject(SysUser.class, sql);
        Long aLong = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(aLong);
    }

    @Test
    public void testBaseQuery() {
        String sql=  "select uid,username,user_pwd as userPwd from sys_user";
        List<SysUser> sysUsers = baseDao.baseQuery(SysUser.class, sql);
        sysUsers.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";

        int rows = baseDao.baseUpdate(sql, "1", "学习JAVA", "0");
        System.out.println(rows);
    }
}
