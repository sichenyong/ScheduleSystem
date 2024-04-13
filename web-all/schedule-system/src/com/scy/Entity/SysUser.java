package com.scy.Entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.Entity
 * @Project：web-all
 * @Date：2023/12/24 11:03
 * @description：实体类
 * 1. 实体类的类名和表格名称应该对应
 * 2. 实体类的属性名和表的列名也应该对应， _转换成驼峰命名
 * 3. 每个属性都要是私有的
 * 4. 每个属性都要有getter setter方法
 * 5. 必须具备无参构造器
 * 6. 应该实现序列化接口
 * 7. 推荐重写类的hashcode和equals方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SysUser implements Serializable {
    private Integer uid;

    private String username;

    private String userPwd;
}
