package com.yunhe.mapper;

import com.yunhe.entity.Orders;
import com.yunhe.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OrdersMapper {
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "user",javaType = User.class, one = @One(select = "com.yunhe.mapper.UserMapper.findUser"),column = "uid")
    })
    Orders findOrders(Integer id);
}
