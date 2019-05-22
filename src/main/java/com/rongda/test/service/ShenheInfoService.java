package com.rongda.test.service;

import com.rongda.test.bean.ShenheInfo;

import java.util.List;

public interface ShenheInfoService {

    int add(List<ShenheInfo> pi);

    List<ShenheInfo> getPlacardIndex();
}
