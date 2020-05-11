package com.regino.service;

import com.regino.dao.UserMapper;
import com.regino.domain.User;
import com.regino.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    private SqlSession sqlSession = null;

    // 此方法在测试方法执行之前，执行
    @Before
    public void before() {
        // 获取sqlSession对象
        sqlSession = MyBatisUtils.openSession();// 此方法必须线程内独享....
    }

    // 此方法在测试地方法执行之后，执行
    @After
    public void after() {
        // 关闭sqlSession
        MyBatisUtils.close(sqlSession);
    }

    @Test
    public void testFindAll() throws Exception {
        // 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    // resultMap标签
    @Test
    public void testFindAllResultMap() throws Exception {
        // 获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行sql
        List<User> list = userMapper.findAllResultMap();
        for (User user : list) {
            System.out.println(user);
        }
    }

    // 多条件查询
    @Test
    public void test01()throws Exception{
        // 获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 方式一
    /*List<User> list = userMapper.findByIdAndUsername1(41, "老王");
        System.out.println(list);*/

        // 方式二
        User user = new User();
        user.setId(41);
        user.setUsername("老王");
        List<User> list = userMapper.findByIdAndUsername2(user);
        System.out.println(list);
    }

    // 模糊查询
    @Test
    public void test02()throws Exception{
        // 获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 方式一
        // List<User> list = userMapper.findByUsername1("%王%");
        // 方式二
        // List<User> list = userMapper.findByUsername2("王");
        // 方式三
        // List<User> list = userMapper.findByUsername3("王");
        // 方式四
        List<User> list = userMapper.findByUsername4("王");
        System.out.println(list);
    }
}