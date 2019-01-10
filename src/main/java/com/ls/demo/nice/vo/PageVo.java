package com.ls.demo.nice.vo;

/**
 * @Description:
 * @Author Created by junwei.liang on 2019/1/9 17:29
 */
public class PageVo {
    private Integer start;
    private Integer end;

    public int getStart() {
        return start;
    }

    public void setStart(Integer start) {
        if (start == null) {
            start = 0;
        }
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        if (end == null) {
            end = 10;
        }
        this.end = end;
    }
}
