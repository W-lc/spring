package com.wolfcode.mybatis_test.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 提供sqlSesion的方法
 * SqlSession来源于SqlSessionFactory
 * SqlSessionFactory来源于SqlSessionFactoryBulder构建
 */
public class MyBatisUtil {
    //先要申明一个SqlSessionFactory
    static SqlSessionFactory sqlSessionFactory;
    //通过静态代码块为sqlSessionFactory赋值
    static {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //先要加载到核心的配置文件 InputStream
            InputStream stream = Resources.getResourceAsStream("mybatis_config.xml");
            //通过这个工具构建一个sqlSessionFactory
            sqlSessionFactory = builder.build(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //获取sqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
//         return sqlSessionFactory.openSession();
    }
}
