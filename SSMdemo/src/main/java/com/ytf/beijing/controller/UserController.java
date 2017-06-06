package com.ytf.beijing.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytf.beijing.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    // 返回页面
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        return "showUser";
    }

    // 返回json类型
    @ResponseBody
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        int size = userService.findAll().size();
        return size + "你好";
    }

}
