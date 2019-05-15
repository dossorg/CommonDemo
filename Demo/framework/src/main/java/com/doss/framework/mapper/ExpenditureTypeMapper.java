package com.doss.framework.mapper;

import com.doss.framework.bean.ExpenditureType;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface ExpenditureTypeMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into expenditure_type (id, type_name, comm) values (#{id}, #{typeName}, ${comm})")
    public int insert (ExpenditureType expenditureType) ;

    @Delete("delete from expenditure_type t where t.id = #{id}")
    public int deleteById(ExpenditureType expenditureType);

    @Update("update expenditure_type t set t.type_name=#{typeName}, comm=#{comm} where id=#{id}")
    public int update (ExpenditureType expenditureType);

    @Select("select * from expenditure_type t where t.id=#{id}")
    public ExpenditureType findById(Integer id);

    @Select("select * from expenditure_type t")
    public Collection<ExpenditureType> getAll();
}
