package com.ls.demo.admin.main.controller;

import com.ls.demo.base.pojo.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/9/5
 */
@Controller
@RequestMapping(value="admin")
public class AdminController {
    private static final String ADMIN_INDEX="admin/index";

    @RequestMapping(value="index")
    public String adminIndex(){
        return ADMIN_INDEX;
    }
}
