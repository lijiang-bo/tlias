package com.itheima.mapper;

import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.util.List;

//应用程序在启动时，会自动的将这个接口注册为一个Bean，并且存入IOC容器中
@Mapper
public interface UserMapper {
    //定义一个查询所有用户信息的方法
    //@Select("select * from user")
    public List<com.itheima.pojo.User> findAll();

    //根据id删除用户信息
    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

    @Insert("insert into user values(#{id},#{username},#{password},#{name},#{age})")
    public void insert(com.itheima.pojo.User user);

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(com.itheima.pojo.User user);
}