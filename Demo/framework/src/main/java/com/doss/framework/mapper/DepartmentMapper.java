package com.doss.framework.mapper;

import com.doss.framework.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;

public interface DepartmentMapper {


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values (#{departmentName})")
    public int insert(Department department);

    @Select("delete from department d where d.id=#{id}")
    public int deleteById (Integer id);

    @Update("udpate department set department_name=#{departmentName} where id=#{id}")
    public int udpate(Department department);

    @Select("select * from department ")
    public Collection<Department> getAll();

    @Select("select * from department d where d.id=#{id}")
    public Department findById (Integer id);

}
