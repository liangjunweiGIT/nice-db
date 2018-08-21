package com.ls.demo.base.pojo;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/21
 */
class ResUtil {
    static String getMsg(Res res) {
        if (res == null) {
            return null;
        }
        return res.getMsg();
    }

    static <T> T getT(Res<T> res) {
        if (res == null) {
            return null;
        }
        return res.getRe();
    }

    static Throwable getE(Res res) {
        if (res == null) {
            return null;
        }
        return res.getE();
    }
}
