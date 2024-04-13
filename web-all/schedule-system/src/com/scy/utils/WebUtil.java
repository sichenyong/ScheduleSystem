package com.scy.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scy.common.ResultFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.utils
 * @Project：web-all
 * @Date：2023/12/27 16:06
 * @description：网络工具包
 */
public class WebUtil {
    private static  ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        // 设置JSON和Object转换时的时间日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    // 专门用于向客户端响应JSON串的方法
    public static void writeJson(HttpServletResponse resp, ResultFormatter result) {
        // 设置响应的编码方式
        resp.setCharacterEncoding("UTF-8");
        // 将result 转换为json串相应给客户端
        String info = null;
        try {
            info = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 告诉客户端返回的是json字符串
        resp.setContentType("application/json;charset=UTF-8");
        try {
            resp.getWriter().write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从请求中获取JSON串并转换为Object
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz){
        T t =null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer =new StringBuffer();
            String line =null;
            while((line = reader.readLine())!= null){
                buffer.append(line);
            }
            t= objectMapper.readValue(buffer.toString(),clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
