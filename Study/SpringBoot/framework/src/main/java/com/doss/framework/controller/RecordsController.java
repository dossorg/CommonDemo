package com.doss.framework.controller;

import com.doss.framework.bean.Records;
import com.doss.framework.bean.User;
import com.doss.framework.mapper.RecordsMapper;
import com.doss.framework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordsController {

    @Autowired
    RecordsMapper recordsMapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/records/{id}")
    public Records getRecords(@PathVariable("id") Integer id) {
        return recordsMapper.getRecordById(id);
    }

    @GetMapping("/records")
    public Records insertRecords(Records records) {
        recordsMapper.insertRecords(records);
        return records;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }
}
