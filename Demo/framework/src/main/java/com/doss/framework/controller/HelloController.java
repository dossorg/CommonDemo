package com.doss.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello framework";
    }

    @ResponseBody
    @RequestMapping("/helloU2")
    public String helloToOne(@RequestParam Integer id) {
        return "helloU " + id;
    }

    @ResponseBody
    @RequestMapping("/helloU")
    public String helloUser(@RequestParam("user") String user) {
        return "Hello " + user;
    }
}
