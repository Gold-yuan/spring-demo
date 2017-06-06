package com.ytf.beijing.dao;

import java.util.List;

import com.ytf.beijing.pojo.User;

public interface IUserDao {

    List<User> findAllUser();
}