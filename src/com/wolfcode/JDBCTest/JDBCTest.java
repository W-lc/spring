package com.wolfcode.JDBCTest;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    @Test
    public void test10() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BasicDataSource basicDataSource = ac.getBean("basicDataSource", BasicDataSource.class);
        Connection connection = basicDataSource.getConnection();
        //设置链接为非自动提交
        connection.setAutoCommit(false);
        try{
        //更新的操作
        PreparedStatement pst1 = connection.prepareStatement("update app01_userinfo set account=? where id=?");
        pst1.setDouble(1,60.0);
        pst1.setInt(2,2);
        pst1.executeUpdate();
        //插入操作
        PreparedStatement pst2 = connection.prepareStatement("insert into app01_userinfo values (?,?,?,?,?,?,?,?)");
        pst2.setInt(1,6);
        pst2.setString(2,"王鸿宇");
        pst2.setString(3,"1234");
        pst2.setInt(4,22);
        pst2.setDouble(5,100.0);
        pst2.setString(6,"2022-09-12");
        pst2.setInt(7,1);
        pst2.setInt(8,2);
        pst2.executeUpdate();
        //执行提交操作
        connection.commit();
        }catch (Exception e){
            connection.rollback();
        }



    }
    /**
     * 测试dbcp链接池
     */
    @Test
    public void test9() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BasicDataSource basicDataSource = ac.getBean("basicDataSource", BasicDataSource.class);
        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);

    }
    /**
     * 聚合查询测试
     */
    @Test
    public void test8(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Integer count = jdbcTemplate.queryForObject("select count(*) from app01_userinfo", Integer.class);
        System.out.println(count);
    }
    /**
     * 将结果集封装到对象中测试
     */
    @Test
    public void test7(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="select * from app01_userinfo where id=?";
        List<T_User> queryResult = jdbcTemplate.query(sql, new RowMapper<T_User>() {
            @Override
            public T_User mapRow(ResultSet rs, int i) throws SQLException {
                T_User t_user = new T_User();
                t_user.setId(rs.getInt("id"));
                t_user.setName(rs.getString("name"));
                t_user.setPassword(rs.getString("password"));
                t_user.setAge(rs.getInt("age"));
                t_user.setAccount(rs.getDouble("account"));
                t_user.setCreate_time(rs.getString("create_time"));
                t_user.setSex(rs.getInt("sex"));
                t_user.setDepart_id(rs.getInt("depart_id"));
                return t_user;
            }
        }, 1);
        for(T_User user:queryResult){
            System.out.println(user);
        }
    }
    /**
     * 多条结果集查询
     */
    @Test
    public void test6(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="select * from app01_userinfo";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> map:maps){
            System.out.println(map);
        }

    }
    /**
     * 测试jdbcTemplate
     */
    @Test
    public void test5(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap("select * from app01_userinfo where id=2");
        System.out.println(stringObjectMap);
    }
    /**
     * 测试spring-jdbc提供的DriverManagaerDataSource
     */
    @Test
    public void test4() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManagerDataSource dataSource = ac.getBean("dataSource", DriverManagerDataSource.class);
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    /**
     * 测试自己将jdbc整合到spring中
     */
    @Test
    public void test3() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManager driverManager = ac.getBean("driverManager", DriverManager.class);
        System.out.println(driverManager);
        Connection conn = driverManager.getConnection("jdbc:mysql://localhost:3306/staffing_system", "root", "wlc011227");
        System.out.println(conn);
    }
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        // 加载驱动


        //获取链接
//        try {
//            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/staffing_system","root","wlc011227");
//            System.out.println(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection conn=JDBCUtil.getConnection();
        PreparedStatement pst =conn.prepareStatement("select * from app01_userinfo where id=? and age=?");
        pst.setInt(1,2);
        pst.setInt(2,20);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            System.out.println("---"+resultSet.getString("id")+"----"+resultSet.getString("name"));
        }
        //关闭操作
        JDBCUtil.close(resultSet,pst,conn);
    }
    @Test
    public void test2() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/staffing_system","root","wlc011227");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
