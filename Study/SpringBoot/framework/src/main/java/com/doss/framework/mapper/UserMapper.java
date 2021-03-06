package com.doss.framework.mapper;

import com.doss.framework.bean.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Select("select * from users where id=#{id}")
    public User getUserById(Integer id);

    @Select("delete from users where id=#{id}")
    public int deleteUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into users(name, login_name, password, gender, mail, address, comm) values (#{name}, #{loginName}, #{password}, #{gender}, #{mail}, #{address}, #{comm})")
    public int insertUser(User user);

    @Update("udpate users set name=#{name}, login_name=#{loginName}, password=#{password}, gender=#{gender}, mail=#{mail}, address=#{address}, comm=#{comm} where id=#{id}")
    public int updateUser(User user);
}
