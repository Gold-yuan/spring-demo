package com.ytf.beijing.service.impl2;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ytf.beijing.dao2.IUserDao2;
import com.ytf.beijing.pojo.User;
import com.ytf.beijing.service2.IUserService2;

@Service("userService2")
@Transactional(value = "mysql2", rollbackFor = Exception.class)  
public class UserServiceImpl2 implements IUserService2 {
    
	@Resource
	private IUserDao2 userDao;
	
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
