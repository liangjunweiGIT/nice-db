package com.rongda.test.bean;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.rongda.test.SpringContextHolder;
import com.rongda.test.service.PlacardIndexService;
import com.rongda.test.service.ShenheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PipelineName(value="placardIndex")
public class PlacardPipeLine implements Pipeline<PlacardIndex>{

    //private ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(null);
    private PlacardIndexService placardIndexService;
    private ShenheInfoService shenheInfoService;

    @Override
    public void process(PlacardIndex placardIndex) {
        if (placardIndexService==null){
            placardIndexService= SpringContextHolder.getBean(PlacardIndexService.class);
            shenheInfoService= SpringContextHolder.getBean(ShenheInfoService.class);
        }

        List<ShenheInfo> ShenheInfo = new ArrayList<>();
        System.out.println(placardIndex);
        ShenheInfo si = null;
        for (int i = 0; i < 3; i++){
            si = new ShenheInfo();
            si.setIndex(placardIndex.getIndex());
            si.setMemberName(placardIndex.getMember().split(";")[i]);
            si.setIssuedName(placardIndex.getIssuedName().split(";")[i]);
            ShenheInfo.add(si);
        }
//        placardIndexService.add(placardIndex);
//        shenheInfoService.add(ShenheInfo);
        System.out.println("ShenheInfo" + ShenheInfo);
        System.out.println("placardIndexService" + placardIndexService);
        if (placardIndexService.add(placardIndex)>0 && shenheInfoService.add(ShenheInfo)>0)
            System.out.println("网页内容入库成功");
    }
}
