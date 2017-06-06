package com.ytf.beijing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.ytf.beijing.dao.IUserDao;
import com.ytf.beijing.pojo.User;
import com.ytf.beijing.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    
	@Resource
	private IUserDao userDao;    
	@Autowired  
    protected RedisTemplate<?, ?> redisTemplate;  
	
	@Override
	public List<User> findAllUser() {
	    RedisSerializer r = redisTemplate.getStringSerializer();
	    
		return userDao.findAllUser();
	}

}
