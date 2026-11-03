package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void delete(){
        userMapper.delete(5);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("zhaoyun");
        user.setPassword("123456");
        user.setName("赵云");
        user.setAge(18);
        userMapper.insert(user);
    }
    @Test
    public void update(){
        User user=new User();
        user.setId(5);
        user.setUsername("gaoyuanyuan");
        user.setPassword("123456");
        user.setName("高圆圆");
        user.setAge(18);
        userMapper.update(user);
    }
}
