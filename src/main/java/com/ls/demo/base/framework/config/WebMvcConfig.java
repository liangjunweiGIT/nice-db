package com.ls.demo.base.framework.config;

import com.ls.demo.base.framework.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:
 * @Author Created by liangjunwei on 2018/8/31 18:11
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
        interceptorRegistry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/**/error")
                .excludePathPatterns("/**/test/health")
                .excludePathPatterns("/**/login/**");
    }

}
