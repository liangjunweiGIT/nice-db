package com.ls.demo.nice.controller;

import com.ls.demo.base.pojo.Res;
import com.ls.demo.nice.dao.SecretDao;
import com.ls.demo.nice.vo.PageVo;
import com.ls.demo.nice.vo.SecretVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description:
 * @Author Created by junwei.liang on 2019/1/9 17:19
 */
@Controller
@RequestMapping(value = "/secretController")
public class SecretController {

    @Resource
    private SecretDao secretDao;

    @ResponseBody
    @RequestMapping("/getSecretList")
    public Object getSecretList(Integer start, Integer end) {
        PageVo pageVo = new PageVo();
        pageVo.setStart(start);
        pageVo.setEnd(end);
        return secretDao.querySecretList(pageVo);
    }

    @ResponseBody
    @RequestMapping("/insertSecret")
    public Res insertSecret(String secretText) {
        if (secretText == null || secretText.trim().length() == 0) {
            return Res.err("内容不能为空哦");
        }
        SecretVo secretVo = new SecretVo();
        secretVo.setSecretText(secretText);
        secretVo.setCreateTime(new Date());
        secretDao.insertSecret(secretVo);
        return Res.suc();
    }
}
