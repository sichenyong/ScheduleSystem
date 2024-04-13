package com.scy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scy.Entity.SysUser;
import com.scy.common.ResultFormatCodeEnum;
import com.scy.common.ResultFormatter;
import com.scy.service.SysUserService;
import com.scy.service.impl.SysUserServiceImpl;
import com.scy.utils.MD5Util;
import com.scy.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.controller
 * @Project：web-all
 * @Date：2023/12/24 20:09
 * @description：用户相关的Controller，控制逻辑
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private static SysUserService sysUserService;

    static {
        sysUserService = new SysUserServiceImpl();
    }
    /**
     * @description: 用户注册的逻辑控制
     * @param: req, resp, 分别是登录发送过来的请求，以及响应回去的数据
     **/
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userPwdInput = req.getParameter("userPwdInput");
//        String username = req.getParameter("username");
        SysUser user = WebUtil.readJson(req, SysUser.class);
        int i = sysUserService.doRegist(user);
        if (i > 0) {
            // 注册成功
//            resp.sendRedirect("/common/error/registSuccess.html");
            WebUtil.writeJson(resp,ResultFormatter.ok(null));
        } else {
            // 注册失败，用户名已经存在
            WebUtil.writeJson(resp, ResultFormatter.build(null,ResultFormatCodeEnum.USERNAME_EXIST));
//            resp.sendRedirect("/common/error/registError.html");
        }

    }

    /**
     * @description: 登录业务的业务接口
     * @param: req, resp, 分别是登录发送过来的请求，以及响应回去的数据
     * @return:
     **/
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String userPwdInput = req.getParameter("userPwdInput");
        SysUser user = WebUtil.readJson(req, SysUser.class);

        // 1. 调用业务层方法，根据用户名查询用户信息
        ResultFormatter resultFormatter = ResultFormatter.ok(null);
        SysUser loginUser = sysUserService.queryByName(user.getUsername());

        if (null == loginUser) {
            // 不存在
            resultFormatter = ResultFormatter.build(null,ResultFormatCodeEnum.USERNAME_ERROR);
        }
        // 2. 判断密码是否匹配
        String encryptPassword = MD5Util.encrypt(user.getUserPwd());
        assert loginUser != null;

        if (!loginUser.getUserPwd().equals(encryptPassword)) {
            // 密码不匹配
            resultFormatter = ResultFormatter.build(null,ResultFormatCodeEnum.PASSWORD_ERROR);
        }
        else {
            // 登录成功
            // 将用户的uid以及username相应给客户端
            Map<String, Object> data = new HashMap<>();
            loginUser.setUserPwd("");
            data.put("loginUser",loginUser);
            resultFormatter = ResultFormatter.ok(data);
        }

        WebUtil.writeJson(resp, resultFormatter);
    }

    /**
     * @description: 接受要注册的用户名，判断是否已经存在
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2023/12/27 15:10
     * @param: [req, resp]
     * @return: void
     **/
    protected void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取待校验的用户名
        String username = req.getParameter("username");

        ResultFormatter result = ResultFormatter.ok(null);
        // 用户名已经存在
        if (sysUserService.queryByName(username) != null) {
            result = ResultFormatter.build(null, ResultFormatCodeEnum.USERNAME_EXIST);
        }
        // 将result对象转换为JSON串相应给客户端
        WebUtil.writeJson(resp, result);
    }
}
