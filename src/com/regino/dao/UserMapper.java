package com.regino.dao;

import com.regino.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // 查询所有
    public List<User> findAll();

    // 新增
    public void save(User user);

    // 修改
    public void update(User user);

    // 删除
    public void delete(Integer id);

    // 查询一个
    public User findById(Integer id);

    // ResultMap标签
    public List<User> findAllResultMap();

    // 多条件查询，方式一（参数≤2时推荐使用）
    public List<User> findByIdAndUsername1(@Param("id") Integer id, @Param("username") String username);

    // 多条件查询，方式二（参数较多时使用）
    public List<User> findByIdAndUsername2(User user);

    // 模糊查询，方式一
    public List<User> findByUsername1(String username);

    // 模糊查询，方式二
    public List<User> findByUsername2(String username);

    // 模糊查询，方式三
    public List<User> findByUsername3(String username);

    // 模糊查询，方式四
    public List<User> findByUsername4(String username);
}