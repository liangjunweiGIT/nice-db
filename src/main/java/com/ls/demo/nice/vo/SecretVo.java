package com.ls.demo.nice.vo;

import java.util.Date;

/**
 * @Description:
 * @Author Created by junwei.liang on 2019/1/9 17:24
 */
public class SecretVo{
    private Long id;
    private String secretText;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecretText() {
        return secretText;
    }

    public void setSecretText(String secretText) {
        this.secretText = secretText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
