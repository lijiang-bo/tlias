package com.itheima;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbcTest {
    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        //.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.数据库的连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "071029jb";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取sql语句执行对象
        Statement statement = connection.createStatement();
        //4.执行sql语句
        int i = statement.executeUpdate("update user set age=26 where id=1");
        System.out.println("SQL语句执行影响的记录数：" + i);
        //5.关闭资源
        statement.close();
        connection.close();
    }

    @Test
    public void selectTest() throws ClassNotFoundException, SQLException {
        //.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.数据库的连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "071029jb";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取预编译sql语句执行对象
        String sql = "select * from user where username=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.设置参数
        preparedStatement.setString(1, "daqiao");
        preparedStatement.setString(2, "123456");
        //5.执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
        }
        System.out.println("查询到的用户信息：" + user);
        //6.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
