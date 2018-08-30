package com.ls.demo.test.mian;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author Created by liangjunwei on 2018/8/30 14:04
 */
public class TestForEach {
    public static void main(String[] args) throws Exception {
        List<String> a = new ArrayList<String>();
        a.add("2");
        a.add("2");
        for (String temp : a) {
            System.out.println(temp);
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
    }
}
