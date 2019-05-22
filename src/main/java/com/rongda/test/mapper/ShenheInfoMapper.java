package com.rongda.test.mapper;

import com.rongda.test.bean.ShenheInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShenheInfoMapper {

    int insert(List<ShenheInfo> pi);

    List<ShenheInfo> select();
}
