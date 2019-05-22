package com.rongda.test.Controller;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ApplicationContext applicationContext;
    @RequestMapping("test")
    public String getStart(){
        HttpGetRequest reqUrl = new HttpGetRequest("http://www.csrc.gov.cn/pub/zjhpublic/G00306202/201712/t20171229_330048.htm?keywords=");
//        reqUrl.setCharset("UTF-8");
        //工程的包路径
        GeccoEngine.create()
                .classpath("com.rongda.test.bean")
                //开始抓取的页面地址
                .start(reqUrl)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(3)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();
        return "测试";
    }

    public static void main(String[] args) {
        HttpGetRequest reqUrl = new HttpGetRequest("http://www.csrc.gov.cn/pub/zjhpublic/G00306202/201712/t20171229_330048.htm?keywords=");
//        reqUrl.setCharset("UTF-8");
        GeccoEngine.create()
                .classpath("com.rongda.test.bean")
                //开始抓取的页面地址
                .start(reqUrl)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(500)
                //开始运行
                .run();
    }
}
