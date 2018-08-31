package com.ls.demo.controller;

import com.ls.demo.base.pojo.Res;
import com.ls.demo.test.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/19
 */
@Controller
@RequestMapping(value="test")
public class HealthCheck {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    public static final String HEALTH_JSP="healthCheck";

    @RequestMapping(value="health")
    public String health(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("test","test");
        return HEALTH_JSP;
    }

    /**
     * Res结果使用示例
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="resDemo")
    public Res resDemo(HttpServletRequest request){
        try{
            //service.do
            User user = new User();
            user.setId(1);
            user.setGroupName("公安局");
            user.setUserName("安安");
            user.setPassWord("*******");
            return Res.suc(user);
        }catch (Exception e){
            LOGGER.error("请求Res示例时失败",e);
            return Res.err("请求失败，服务器内部错误");
        }
    }
}
