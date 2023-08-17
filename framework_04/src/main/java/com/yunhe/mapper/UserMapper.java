package com.yunhe.mapper;

import com.yunhe.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user u,user_role ur where u.id =ur.uid and ur.rid= #{id}")
    List<User> findUserByName(Integer id);



//    查询
    @Select("select * from user")
    List<User> findAll();
//    查询单个
    @Select("select * from user where id = #{id}")
    User findUser(Integer id);
//    添加
    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    void addUser(User user);
//    修改
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id = #{id}")
    void updateUser(User user);
//    删除
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);
}
