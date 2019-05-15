package com.doss.framework.controller;

import com.doss.framework.bean.User;
import com.doss.framework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/user/login")
    public String login(@RequestParam String loginName, @RequestParam String password, Map<String, Object> map, HttpSession session) {
        User user = userMapper.findUserByLoginName(loginName);
//        User user = userMapper.login2(loginName, password);
        if (user != null && password.equals(user.getPassword())) {
            //登陆成功，防止表单重复提交，重定向到主页
            session.setAttribute("loginUser", user.getName());
            return "redirect:/main.html";
        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/index.html";
    }
}
