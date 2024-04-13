package com.scy.controller;

import com.scy.Entity.SysSchedule;
import com.scy.common.ResultFormatCodeEnum;
import com.scy.common.ResultFormatter;
import com.scy.service.SysScheduleService;
import com.scy.service.SysUserService;
import com.scy.service.impl.SysScheduleServiceImpl;
import com.scy.service.impl.SysUserServiceImpl;
import com.scy.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：sichenyong
 * @Email: sichenyongwork@163.com
 * @Package：com.scy.controller
 * @Project：web-all
 * @Date：2023/12/24 20:09
 * @description：
 * 增加日程 /schedule/add
 * 修改日程 /schedule/edit
 * 查询日程 /schedule/query
 * 删除日程 /schedule/delete
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    // 业务实现类
    private SysScheduleService sysScheduleService = new SysScheduleServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("add");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("edit");
    }

    /**
     * @description:根据用户的uid查询相关的日程
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 10:34
     * @param: [req, resp]
     * @return: void
     **/
    protected void queryItemsByUid(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("query");
        // 读取请求中的uid
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        // 根据uid查询数据库中的记录
        List<SysSchedule> scheduleList = sysScheduleService.query(uid);
        // 返回记录
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("scheduleList",scheduleList);
        ResultFormatter result = ResultFormatter.ok(result_map);
        WebUtil.writeJson(resp, result);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("delete");
    }

    /**
     * @description:添加一条默认的日程
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 15:11
     * @param: [req, resp]
     * @return: void
     **/
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求中的uid
        Integer uid = Integer.parseInt(req.getParameter("uid"));

        // 向请求中的uid对应的用户表中添加默认的日程
        int rows = sysScheduleService.addDefaultSchedule(uid);

        // 响应结果
        if (rows > 0) {
            ResultFormatter result = ResultFormatter.ok(null);
            WebUtil.writeJson(resp, result);
        } else {
            ResultFormatter result = ResultFormatter.build(null, ResultFormatCodeEnum.SERVICE_ERROR);
            WebUtil.writeJson(resp, result);
        }
    }

    /**
     * @description: 更新用户的日程信息，请求为post请求，要设置请求的编码方式，不然中文乱码
     * @author: sichenyong
     * @email: sichenyongwork@163.com
     * @date: 2024/1/8 15:32
     * @param: [req, resp]
     * @return: void
     **/
    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 获取请求体中的数据，转为SysSchedule对象
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务更新数据
        int rows = sysScheduleService.updateSchedule(sysSchedule);

        // 成功更新数据
        if (rows > 0) {
            ResultFormatter result = ResultFormatter.ok(null);
            WebUtil.writeJson(resp, result);
        } else {
            ResultFormatter result = ResultFormatter.build(null, ResultFormatCodeEnum.SERVICE_ERROR);
            WebUtil.writeJson(resp, result);
        }
    }
}
