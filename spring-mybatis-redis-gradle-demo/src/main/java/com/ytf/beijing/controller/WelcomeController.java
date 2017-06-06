package com.ytf.beijing.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ytf.beijing.pojo.User;
import com.ytf.beijing.service.HelloWorldService;
import com.ytf.beijing.service.IUserService;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    private HelloWorldService helloWorldService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        logger.debug("index() is executed!");

        model.put("title", helloWorldService.getTitle("") + "1");
        model.put("msg", helloWorldService.getDesc());

        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        logger.debug("hello() is executed - $name {}", name);

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("title", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());

        return model;

    }


    /**
     * 直接写入页面
     * @param req
     * @param resp
     * @throws Exception
     */
    @RequestMapping("/resp")
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<User> user = userService.findAllUser();
        System.out.println(user.size() + "----------------------------------");
        logger.info(JSON.toJSONString(user));
        
        resp.getWriter().println("hello HttpServletResponse 哈哈");

    }

    @ResponseBody
    @RequestMapping(value = "/hi/{name:.+}", method = RequestMethod.GET)
    public String hi(@PathVariable("name") String name) {
        System.out.println(name);
        return "hi " + name;
    }
    @ResponseBody
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public List<String> hi() {
        return new ArrayList<String>(){{  
            add("你好")  ;
        }};  
    }
}
