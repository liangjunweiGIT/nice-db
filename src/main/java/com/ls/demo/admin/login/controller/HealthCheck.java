package com.ls.demo.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/19
 */
@Controller
@RequestMapping(value="test")
public class HealthCheck {
    public static final String HEALTH_JSP="healthCheck";

    @RequestMapping(value="health")
    public String health(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("test","test");
        return HEALTH_JSP;
    }
}