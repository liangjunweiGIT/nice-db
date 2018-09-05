package com.ls.demo.admin.login.controller;

import com.ls.demo.base.pojo.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 所有路径都不拦截
 * @Author Create by junwei.liang on 2018/8/31
 */
@Controller
@RequestMapping(value="login")
public class LoginController {

    private static final String LOGIN_PAGE="admin/login/login";

    @ResponseBody
    @RequestMapping(value="doLogin")
    public Res adminLogin(HttpServletRequest request,String empname,String password){
        if("123".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("empname",empname);
            return Res.suc();
        }
        return Res.err();
    }

    @RequestMapping(value="loginPage")
    public String loginPage(){
        return LOGIN_PAGE;
    }
}
