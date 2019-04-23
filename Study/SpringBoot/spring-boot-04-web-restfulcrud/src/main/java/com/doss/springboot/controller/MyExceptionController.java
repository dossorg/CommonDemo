package com.doss.springboot.controller;

import com.doss.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {

    //1、浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们的错误代码 4xx 5xx，否则就不会进入错误页面的解析中
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
        map.put("message", "用户出错了");
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }


}
