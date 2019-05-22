package com.rongda.test.service;

import com.rongda.test.bean.PlacardIndex;

import java.util.List;

public interface PlacardIndexService {

    int add(PlacardIndex pi);

    List<PlacardIndex> getPlacardIndex();
}
