package com.yunhe.mapper;

import com.yunhe.entity.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {
    @Select("select * from emp where deptno = #{deptno}")
    List<Emp> findEmp(Integer id);
}
