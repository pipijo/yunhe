package com.yunhe.mapper;

import com.yunhe.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface RoleMapper {


    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "userList",javaType = List.class,many = @Many(select = "com.yunhe.mapper.UserMapper.findUserByName",fetchType = FetchType.LAZY),column = "id")
    })
    @Select("select * from role  where role_name = #{name}")
    Role findByName(String name);
}
