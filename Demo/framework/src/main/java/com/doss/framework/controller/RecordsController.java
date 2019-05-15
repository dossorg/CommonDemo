package com.doss.framework.controller;

import com.doss.framework.bean.Records;
import com.doss.framework.bean.User;
import com.doss.framework.bean.Employee;
import com.doss.framework.mapper.EmployeeMapper;
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

    @Autowired
    EmployeeMapper employeeMapper;

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
        return userMapper.findById(id);
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeMapper.findById(id);
    }
}
