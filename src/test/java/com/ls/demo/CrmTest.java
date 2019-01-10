package com.ls.demo;

import org.junit.Test;

import java.util.Random;

/**
 * @Description:
 * @Author Created by liangjunwei on 2018/9/6 10:38
 */
public class CrmTest {
    @Test
    public void random() {
        String verifycode = String.format("%06d", new Random().nextInt(
                99));
        System.out.println(verifycode);
    }

    @Test
    public void jinzhi3() {
        double pow = Math.pow(3, 14);
        double po2 = Math.pow(3, 15);
        System.out.println(pow);
        System.out.println(po2);
    }

}
