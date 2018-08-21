package com.ls.demo.test.controller;

import com.alibaba.fastjson.JSON;
import com.ls.demo.test.dao.UserDao;
import com.ls.demo.test.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/20
 */
@RestController
public class TestController {

    @Resource
    UserDao userDao;

    @RequestMapping("/getusers")
    public String test() {
        List<User> users = userDao.queryAllUsers();
        String usersJson = JSON.toJSONString(users);
        return usersJson;
    }
}
