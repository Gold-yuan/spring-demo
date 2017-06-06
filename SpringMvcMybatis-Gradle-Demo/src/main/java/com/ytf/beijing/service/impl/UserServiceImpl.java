package com.ytf.beijing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ytf.beijing.dao.IUserDao;
import com.ytf.beijing.pojo.User;
import com.ytf.beijing.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    
	@Resource
	private IUserDao userDao;
	
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
