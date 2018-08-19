package com.ls.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/19
 */
@Controller
@RequestMapping(value="test")
public class HealthCheck {
    @RequestMapping(value="health")
    public String health(){
        return "healthCheck";
    }
}
