package com.wolfcode.mybatis_test.dao.impl;

import com.wolfcode.mybatis_test.dao.UserDao;
import com.wolfcode.mybatis_test.entity.T_user;
import com.wolfcode.mybatis_test.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 持久层UserDao接口实现类
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void insert(T_user user) {
        //获取连接
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        Connection connection = sqlSession.getConnection();
//        try {
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        int insert = sqlSession.insert("com.wolfcode.mybatis_test.dao.UserDao.insert", user);
        System.out.println(insert);

    }

    @Override
    public void update(T_user user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int update = sqlSession.update("com.wolfcode.mybatis_test.dao.UserDao.update", user);

    }

    @Override
    public void delete(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.delete("com.wolfcode.mybatis_test.dao.UserDao.delete",id);

    }

    @Override
    public List<T_user> select(Map<String, Object> paramMap) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectList("com.wolfcode.mybatis_test.dao.UserDao.selectUserList", paramMap);
    }

    @Override
    public T_user selectSingle(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectOne("com.wolfcode.mybatis_test.dao.UserDao.selectSingle", id);
    }
}
