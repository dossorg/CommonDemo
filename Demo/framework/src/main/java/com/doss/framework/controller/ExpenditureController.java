package com.doss.framework.controller;

import com.doss.framework.bean.Expenditure;
import com.doss.framework.bean.ExpenditureType;
import com.doss.framework.bean.User;
import com.doss.framework.mapper.ExpenditureMapper;
import com.doss.framework.mapper.ExpenditureTypeMapper;
import com.doss.framework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class ExpenditureController {

    @Autowired
    private ExpenditureTypeMapper expenditureTypeMapper;

    @Autowired
    private ExpenditureMapper expenditureMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有支出，并返回列表页面
     * @param model
     * @return
     */
    @GetMapping("/expds")
    public String list(Model model) {
        Collection<Expenditure> expenditures = expenditureMapper.getAll();

        model.addAttribute("expds", expenditures);

        return "expd/list";
    }

    /**
     * 跳转支出添加页面
     * @param model
     * @return
     */
    @GetMapping("/expd")
    public String toAddPage(Model model){
        //读取所有支出类型
        Collection<ExpenditureType> expenditureTypes = expenditureTypeMapper.getAll();
        model.addAttribute("eTypes", expenditureTypes);
        Collection<User> users = userMapper.getAll();
        model.addAttribute("users", users);
        return "expd/add";
    }

    /**
     * 跳转支出修改页面
     * 查出该支出信息，并在页面回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/expd/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Expenditure expenditure = expenditureMapper.findById(id);
        model.addAttribute("expd", expenditure);
        Collection<ExpenditureType> expenditureTypes = expenditureTypeMapper.getAll();
        model.addAttribute("eTypes", expenditureTypes);
        Collection<User> users = userMapper.getAll();
        model.addAttribute("users", users);
        return "expd/add";

    }

    /**
     * 添加支出
     * @param expenditure
     * @return
     */
    @PostMapping("/expd")
    public String addExpd(Expenditure expenditure) {
        System.out.println("保存的支出信息 = " + expenditure);
        expenditureMapper.insert(expenditure);
        return "redirect:/expds";
    }

    @PutMapping("/expd")
    public String updateExpd(Expenditure expenditure) {
        System.out.println("修改的支出信息 = " + expenditure);
        expenditureMapper.update(expenditure);
        return "redirect:/expds";
    }

    @DeleteMapping("/expd")
    public String deleteExpd(@PathVariable("id") Integer id) {
        System.out.println("删除的支出信息 = " + id);
        expenditureMapper.deleteById(id);
        return "redirect:/expds";
    }




}
