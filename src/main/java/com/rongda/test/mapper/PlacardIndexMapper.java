package com.rongda.test.mapper;

import com.rongda.test.bean.PlacardIndex;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper()
public interface PlacardIndexMapper {

    int insert(PlacardIndex pi);

    List<PlacardIndex> select();
}
