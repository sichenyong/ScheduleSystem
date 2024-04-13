package com.scy.service.impl;

import com.scy.Dao.SysUserDao;
import com.scy.Dao.impl.SysUserDaoImpl;
import com.scy.Entity.SysUser;
import com.scy.service.SysUserService;
import com.scy.utils.MD5Util;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.service.impl
 * @Project：web-all
 * @Date：2023/12/24 20:04
 * @description：
 */
public class SysUserServiceImpl implements SysUserService {
    private static SysUserDao sysUserDao;
    static {
        sysUserDao = new SysUserDaoImpl();
    }
    @Override
    public int doRegist(String username, String password) {
        return this.doRegist(new SysUser(null, username, password));
    }

    @Override
    public int doRegist(SysUser sysUser) {
         //判断用户名是否已经存在
        SysUser user = sysUserDao.queryByUserName(sysUser.getUsername());
        if (user != null) {
            // 用户已经存在
            return 0;
        }
         //将密码的明文转换成密文并存入数据库中
        String encryptPassword = MD5Util.encrypt(sysUser.getUserPwd());
        sysUser.setUserPwd(encryptPassword);
        return sysUserDao.addUser(sysUser);
    }

    @Override
    public SysUser queryByName(String username) {

        return sysUserDao.queryByUserName(username);
    }
}
