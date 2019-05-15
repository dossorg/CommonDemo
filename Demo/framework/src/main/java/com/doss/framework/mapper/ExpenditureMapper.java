package com.doss.framework.mapper;

import com.doss.framework.bean.Expenditure;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface ExpenditureMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into expenditure (id, subject, type_id, number, comm, pay_user_id, pay_time) values (#{id}, #{subject}, #{typeId}, #{number}, #{comm}, #{payUserId}, #{payTime})")
    public int insert(Expenditure expenditure);

    @Delete("delete from expenditure e where e.id=#{id}")
    public int deleteById(Integer id);

    @Update("update expenditure e set e.subject=#{subject}, e.type_id=#{typeId}, e.number=#{number}, e.comm=#{comm}, e.pay_user_id=#{payUserId}, e.pay_time=#{payTime} where e.id=#{id}")
    public int update(Expenditure expenditure);

    @Select("select * from expenditure e where e.id=#{id}")
    @Results({
            @Result(property = "expenditureType", column = "type_id", one = @One(select = "com.doss.framework.mapper.ExpenditureTypeMapper.findById")),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "payUser", column = "pay_user_id", one = @One(select = "com.doss.framework.mapper.UserMapper.findById")),
            @Result(property = "payUserId", column = "pay_user_id")
    })
    public Expenditure findById(Integer id);

    @Select("select * from expenditure")
    @Results({
            @Result(property = "expenditureType", column = "type_id", one = @One(select = "com.doss.framework.mapper.ExpenditureTypeMapper.findById")),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "payUser", column = "pay_user_id", one = @One(select = "com.doss.framework.mapper.UserMapper.findById")),
            @Result(property = "payUserId", column = "pay_user_id")
    })
    public Collection<Expenditure> getAll();
}
