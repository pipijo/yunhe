package com.yunhe.test;

import com.yunhe.entity.Orders;
import com.yunhe.mapper.OrdersMapper;
import com.yunhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestOrders {
    @Test
    public void testFindOrders() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        Orders orders = mapper.findOrders(1);
        System.out.println(orders);
        sqlSession.close();
    }
}
