package com.test;



import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ytf.beijing.pojo.User;
import com.ytf.beijing.service.IUserService;
import com.ytf.beijing.service2.IUserService2;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestDemo {

    private static Logger logger = Logger.getLogger(TestDemo.class);
    // private ApplicationContext ac = null;
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserService2 userService2;

    // @Before
    // public void before() {
    // ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    // userService = (IUserService) ac.getBean("userService");
    // }

    @Test
    public void test1() {
        List<User> user = userService.findAllUser();
        System.out.println(user.size() + "----------------------------------");
        
        
        List<User> user2 = userService2.findAllUser();
        System.out.println(user2.size() + "----------------------------------");
        
        
        logger.info(JSON.toJSONString(user2));
        logger.info(JSON.toJSONString(user));
    }
}
