package com.scy.service;

import com.scy.Dao.SysUserDao;
import com.scy.Entity.SysUser;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.service
 * @Project：web-all
 * @Date：2023/12/24 20:03
 * @description：
 */
public interface SysUserService {
    /**
     * @description: 注册的业务逻辑实现
     * @email: sichenyongwork@163.com
     * @param: [username, password] or [sysUser]
     * @return: int，返回值>0注册成功
     **/
    int doRegist(String username, String password);
    int doRegist(SysUser sysUser);

    /**
     * @description: 根据用户名获取数据库中的对象
     * @date: 2023/12/25 11:22
     * @param: [username] 查询的用户名
     * @return: 如果找到了 返回SysUser对象，反之返回null
     **/
    SysUser queryByName(String username);
}
