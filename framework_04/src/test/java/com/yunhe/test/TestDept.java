package com.yunhe.test;

import com.yunhe.entity.Dept;
import com.yunhe.mapper.DeptMapper;
import com.yunhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestDept {
    @Test
    public void testFindDept() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findDept("销售部");
        System.out.println(dept.getDeptno());
        System.out.println(dept.getEmpList());
        sqlSession.close();
    }
}
