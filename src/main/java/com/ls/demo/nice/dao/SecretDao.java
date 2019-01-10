package com.ls.demo.nice.dao;

import com.ls.demo.nice.vo.PageVo;
import com.ls.demo.nice.vo.SecretVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author Created by junwei.liang on 2019/1/9 17:20
 */
@Mapper
public interface SecretDao {
    List<SecretVo> querySecretList(PageVo pageVo);

    void insertSecret(SecretVo secretVo);
}
