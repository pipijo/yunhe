package com.yunhe.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunhe.entity.Role;
import com.yunhe.entity.User;
import com.yunhe.mapper.RoleMapper;
import com.yunhe.mapper.UserMapper;
import com.yunhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;


import java.util.List;

public class TestUser {
    @Test
    public void testFindAll() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,3);
        List<User> list = mapper.findAll();
        PageInfo<User> userPageInfo = new PageInfo<>(list);
//        获取第一页数据
        List<User> list1 = userPageInfo.getList();
        for (User user : list1) {
            System.out.println(user);
        }
        System.out.println("每页显示条数："+userPageInfo.getPageSize());
        System.out.println("当前页："+userPageInfo.getPageNum());
        System.out.println("最后一页："+userPageInfo.getLastPage());
        System.out.println("上一页："+userPageInfo.getPrePage());
        System.out.println("下一页："+userPageInfo.getNextPage());
        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("总页数："+userPageInfo.getPages());
        sqlSession.close();
    }
    @Test
    public void testFindUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUser(48);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("张三");
        user.setBirthday("2002-9-29");
        user.setSex("男");
        user.setAddress("北京");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(49);
        user.setUsername("李四");
        user.setBirthday("2002-2-10");
        user.setSex("女");
        user.setAddress("北京");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(49);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testFindEole(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.findByName("院长");
        System.out.println(role);
        sqlSession.close();
    }
}
