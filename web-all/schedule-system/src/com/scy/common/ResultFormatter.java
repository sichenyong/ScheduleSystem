package com.scy.common;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.common
 * @Project：web-all
 * @Date：2023/12/27 15:28
 * @description：
 */
/**
 * @description: 后端响应回来的信息要有统一的格式，响应一个JSON串
 * {
 *     "code" : "100"， 业务状态码，表示本次请求的业务是否成功， 与Http协议中报文响应码不一样！
 *     "message" : "成功", 业务状态码的补充说明/描述
 *     "data" : {}, 本次响应回来的数据
 * }
 **/
public class ResultFormatter<T> {
    private Integer code;

    private String message;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 操作成功
    public static<T> ResultFormatter<T> ok(T data) {
        ResultFormatter<T> resultFormatter = build(data);
        return build(data, ResultFormatCodeEnum.SUCCESS);
    }
    public ResultFormatter<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public ResultFormatter<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    protected static <T> ResultFormatter<T> build(T data) {
        ResultFormatter<T> resultFormatter = new ResultFormatter<>();
        if (data != null)
                resultFormatter.setData(data);
        return resultFormatter;
    }

    // 可以自己在这里定义状态码以及message
    public static <T> ResultFormatter<T> build(T data, Integer code, String message) {
        ResultFormatter<T> result = build(data);

        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> ResultFormatter<T> build(T data, ResultFormatCodeEnum resultFormatCodeEnum) {
        ResultFormatter<T> result = build(data);

        result.setCode(resultFormatCodeEnum.getCode());
        result.setMessage(resultFormatCodeEnum.getMessage());
        return result;
    }
}
