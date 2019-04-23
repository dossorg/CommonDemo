package com.doss.springboot.controller;

import com.doss.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

//@RestController
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index() {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/success")
    public String success() {
        //classpath:/templates/success.html
        return "success";
    }

    //查出一些数据，在页面显示
    @RequestMapping("/msg")
    public String msg(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "msg";
    }

    @ResponseBody
    @RequestMapping("/helloU")
    public String helloUser(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello " + user;
    }

}
