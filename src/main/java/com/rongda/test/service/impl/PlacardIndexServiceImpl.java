package com.rongda.test.service.impl;

import com.rongda.test.bean.PlacardIndex;
import com.rongda.test.mapper.PlacardIndexMapper;
import com.rongda.test.service.PlacardIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlacardIndexServiceImpl implements PlacardIndexService {

    @Autowired
    private PlacardIndexMapper placardIndexDao;
    @Override
    public int add(PlacardIndex pi) {
        return placardIndexDao.insert(pi);
    }

    @Override
    public List<PlacardIndex> getPlacardIndex() {
        return placardIndexDao.select();
    }
}
