package com.scy.Dao.impl;

import com.scy.Dao.BaseDao;
import com.scy.Dao.SysUserDao;
import com.scy.Entity.SysUser;

import java.util.List;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.Dao.impl
 * @Project：web-all
 * @Date：2023/12/24 11:18
 * @description：
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public Long userExist(String username) {
        String sql = "select * from sys_user where username=?";
        return baseQueryObject(Long.class, sql, username);
    }

    @Override
    public int addUser(SysUser user) {
        String sql = "insert into sys_user values(DEFAULT,?, ?)";
        return baseUpdate(sql,user.getUsername(), user.getUserPwd());
    }

    @Override
    public SysUser queryByUserName(String username) {
        String sql = "select uid,username,user_pwd as userPwd from sys_user where username =?";

        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);

        if (sysUserList.size() == 0) {
            return null;
        }else {
            return sysUserList.get(0);
        }
    }
}
