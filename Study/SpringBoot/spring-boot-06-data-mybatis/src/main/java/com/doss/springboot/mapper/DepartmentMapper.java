package com.doss.springboot.mapper;

import com.doss.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//制定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_Name) values(#{departmentName})")
    public int insertDept(Department dept);

    @Update("update department set department_Name=#{departmentName} where id=#{id}")
    public int updateDept(Department dept);
}
