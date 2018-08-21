package com.ls.demo.test.dao;

import com.ls.demo.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/20
 */
@Mapper
public interface UserDao {
    List<User> queryAllUsers();
}