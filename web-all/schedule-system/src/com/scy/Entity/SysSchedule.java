package com.scy.Entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.Entity
 * @Project：web-all
 * @Date：2023/12/24 11:09
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SysSchedule implements Serializable {
    private Integer sid;

    private Integer uid;

    private String title;

    private Integer completed;
}
