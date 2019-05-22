package com.rongda.test.service.impl;

import com.rongda.test.bean.ShenheInfo;
import com.rongda.test.mapper.ShenheInfoMapper;
import com.rongda.test.service.ShenheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShenheInfoServiceImpl implements ShenheInfoService {

    @Autowired
    private ShenheInfoMapper shenheInfoDao;

    @Override
    public int add(List<ShenheInfo> si) {
        return shenheInfoDao.insert(si);
    }

    @Override
    public List<ShenheInfo> getPlacardIndex() {
        return shenheInfoDao.select();
    }
}
