package com.doss.framework;

import com.doss.framework.bean.Employee;
import com.doss.framework.bean.User;
import com.doss.framework.mapper.EmployeeMapper;
import com.doss.framework.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrameworkApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void employeeFindByIdTest() {
        Employee employee = employeeMapper.findById(5);
        System.out.println(employee);
    }

    @Test
    public void loginTest() {
        User user = userMapper.findUserByLoginName("test1");
        System.out.println(user);
    }

}
