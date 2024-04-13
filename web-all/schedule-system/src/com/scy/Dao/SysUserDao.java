package com.scy.Dao;

import com.scy.Entity.SysUser;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.Dao
 * @Project：web-all
 * @Date：2023/12/24 11:13
 * @description：
 * @Version: 1.0
 * data access Object, 数据访问对象
 * 该类中用于定义针对表格的CRUD
 * Dao层一般需要定义接口和实现类
 */
public interface SysUserDao {
    /**
     * @description: 查询当前账户是否存在
     * @date: 2023/12/25 10:55
     * @param: [username] 用户名
     * @return: int， 1代表存在，0代表不存在
     **/
    Long userExist(String username);

    /**
     * @description: 添加一个用户到数据库中
     * @param: [username, password]
     * @return: int， >0代表添加成功，反之代表添加失败
     **/
    int addUser(SysUser user);

    /**
     * @description: 根据参数名查询用户的信息
     * @param: [username]
     * @return: 若存在返回SysUser对象，反之null
     **/
    SysUser queryByUserName(String username);
}
