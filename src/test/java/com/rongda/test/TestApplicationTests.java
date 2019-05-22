package com.rongda.test;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.rongda.test.service.PlacardIndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	@Test
	public void test() {
		final PlacardIndexService bean = SpringContextHolder.getBean(PlacardIndexService.class);
		final PlacardIndexService bean1 = SpringContextHolder.getBean(PlacardIndexService.class);
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
