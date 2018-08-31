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
@RequestMapping(value="admin")
public class LoginController {
    public static final String HEALTH_JSP="healthCheck";

    @RequestMapping(value="login")
    public String health(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("test","test");
        return HEALTH_JSP;
    }
}
