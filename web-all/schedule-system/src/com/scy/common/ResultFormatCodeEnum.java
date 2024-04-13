package com.scy.common;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.common
 * @Project：web-all
 * @Date：2023/12/27 15:31
 * @description： 业务状态码以及响应信息
 */
public enum ResultFormatCodeEnum {
    // 调用下面的构造方法生成枚举对象
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOTLOGIN(504, "notlogin"),
    USERNAME_EXIST(505, "usernameExist"),
    SERVICE_ERROR(506,"服务器出错！");

    private Integer code;
    private String message;

    private ResultFormatCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
