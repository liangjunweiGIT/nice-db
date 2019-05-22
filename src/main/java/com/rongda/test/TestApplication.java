package com.rongda.test;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spring.SpringGeccoEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.*"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TestApplication {

	private SpringGeccoEngine initGecco() {
		return new SpringGeccoEngine() {
			@Override
			public void init() {
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
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
