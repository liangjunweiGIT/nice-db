package com.ls.demo.test.controller;

import com.alibaba.fastjson.JSON;
import com.ls.demo.controller.HealthCheck;
import com.ls.demo.test.dao.UserDao;
import com.ls.demo.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/20
 */
@Controller("tet")
public class TestController {

    private static final String XSS_TEST_JSP="xssTest";

    @Resource
    UserDao userDao;

    @RequestMapping("/getusers")
    public String test() {
        List<User> users = userDao.queryAllUsers();
        String usersJson = JSON.toJSONString(users);
        return usersJson;
    }

    /**
     * XSS攻击简单示例 请使用安全性低的浏览器测试
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/xssLogin")
    public String xssLogin(String username,String password,Model model) {
        if(!"123".equals(password)){
            model.addAttribute("username",username);
            return XSS_TEST_JSP;
        }
        return HealthCheck.HEALTH_JSP;
    }
}
