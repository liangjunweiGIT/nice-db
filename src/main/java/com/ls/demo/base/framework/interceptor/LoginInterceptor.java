package com.ls.demo.base.framework.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author Created by liangjunwei on 2018/8/31 18:06
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*HttpSession session = httpServletRequest.getSession();
        String user = (String) session.getAttribute("empname"); //获取登录的session信息
        if(user!=null){
            return true;
        }
        else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/loginPage");  //未登录自动跳转界面
            return false;
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
