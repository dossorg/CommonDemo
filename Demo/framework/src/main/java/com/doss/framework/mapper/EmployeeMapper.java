package com.doss.framework.mapper;

import com.doss.framework.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface EmployeeMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into employee(id, last_name, gender, email, dept_id, birthday) values (#{id}, #{lastName}, #{gender}, #{email}, #{deptId}, #{birthday})")
    public int insert(Employee employee);

    @Select("delete from employee e where e.id=#{id}")
    public int deleteById (Integer id);

    @Update("update employee set last_name=#{lastName}, gender=#{gender}, email=#{email}, dept_id=#{deptId}, birthday=#{birthday} where id=#{id}")
    public int udpate(Employee employee);

    //使用@Result 与department形成一对一映射
    @Select("select * from employee e where e.id=#{id}")
    @Results({
            @Result(property = "department", column = "dept_id", one = @One(select="com.doss.framework.mapper.DepartmentMapper.findById")),
            @Result(property = "deptId", column = "dept_id")
    })
    public Employee findById(Integer id);

    @Select("select * from employee e")
    @Results({
            @Result(property = "department", column = "dept_id", one = @One(select="com.doss.framework.mapper.DepartmentMapper.findById")),
            @Result(property = "deptId", column = "dept_id")
    })
    @Options(useGeneratedKeys = false)
    public Collection<Employee> getAll();
}
