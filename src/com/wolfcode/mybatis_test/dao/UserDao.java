package com.wolfcode.mybatis_test.dao;

import com.wolfcode.mybatis_test.entity.T_user;

import java.util.List;
import java.util.Map;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 插入用户
     */
    public void insert(T_user user);

    /**
     * 修改操作
     * @param user
     */
    public void update(T_user user);

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * 多条记录查询
     * @param paramMap
     * @return
     */
    public List<T_user> select(Map<String,Object> paramMap);
    /**
     * 单条记录查询
     */
    T_user selectSingle(Integer id);
}
