package com.yunhe.mapper;

import com.yunhe.entity.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DeptMapper {
    /**
     * 查询销售部的所有员工
     * @param dname
     * @return
     */

    @Results({
            @Result(id = true,property = "deptno",column = "deptno"),
            @Result(property = "empList",javaType = List.class,many = @Many(select = "com.yunhe.mapper.EmpMapper.findEmp",fetchType = FetchType.LAZY),column = "deptno")
    })
    @Select("select * from dept where dname = #{dname}")
    Dept findDept(String dname);
}
