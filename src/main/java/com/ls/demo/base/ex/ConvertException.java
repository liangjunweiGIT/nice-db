package com.ls.demo.base.ex;

import com.ls.demo.base.util.StrUtil;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/21
 */
public class ConvertException extends Throwable {
    public ConvertException(Throwable cause) {
        super("convert ex info = " + getMsg(cause), null);
    }

    public ConvertException(String msg) {
        super("convert error msg = " + msg, null);
    }

    private static String getMsg(Throwable cause) {
        if (cause == null) {
            return "ex is null";
        }
        return StrUtil.toString(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
