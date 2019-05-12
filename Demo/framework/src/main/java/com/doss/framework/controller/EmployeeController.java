package com.doss.framework.controller;


import com.doss.framework.bean.Employee;
import com.doss.framework.bean.EmployeeBO;
import com.doss.framework.dao.DepartmentDao;
import com.doss.framework.dao.EmployeeDao;
import com.doss.framework.entities.Department;
//import com.doss.framework.entities.Employee;
import com.doss.framework.mapper.DepartmentMapper;
import com.doss.framework.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

//    @GetMapping("/employee/{id}")
//    public Employee getEmployee(@PathVariable("id") Integer id) {
//        return employeeMapper.getEmployee(id);
//    }


    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<com.doss.framework.bean.Employee> employees = employeeMapper.getAll();

        //放在请求域中
        model.addAttribute("emps", employees );

        //thymeleaf默认就会拼到
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    //跳转员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有的部门
        Collection<com.doss.framework.bean.Department> departments = departmentMapper.getAll();
        model.addAttribute("depts", departments);
        //来到添加页面
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println("保存的员工信息：" +  employee);
        //保存员工信息
        employeeMapper.insert(employee);
//        employeeDao.save(employee);
        //来到员工列表页面
        //redirect：表示重定向到一个地址   /代表当前项目路径
        //forward：表示转发到一个地址
        return "redirect:/emps";//表示转发到一个地址
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        //查出当前员工
//        Employee employee = employeeDao.get(id);
        com.doss.framework.bean.Employee employee = employeeMapper.findById(id);
        model.addAttribute("emp", employee);
        //查出所有的部门
//        Collection<Department> departments = departmentDao.getDepartments();
        Collection<com.doss.framework.bean.Department> departments = departmentMapper.getAll();
        model.addAttribute("depts", departments);
        //回到修改页面（add是一个修改添加二合一的页面）；
        return "emp/add";
    }

    //员工修改：需要量提供id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
//        employeeDao.save(employee);
        employeeMapper.udpate(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
//        employeeDao.delete(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}