package com.ls.demo.admin.login.controller;

import com.ls.demo.base.pojo.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/31
 */
@Controller
@RequestMapping(value="admin")
public class LoginController {
    private static final String ADMIN_INDEX="admin/index";

    @ResponseBody
    @RequestMapping(value="login")
    public Res adminLogin(HttpServletRequest request,String empname,String password){
        if("123".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("empname",empname);
            return Res.suc();
        }
        return Res.err();
    }

    @RequestMapping(value="index")
    public String adminIndex(){
        return ADMIN_INDEX;
    }
}
