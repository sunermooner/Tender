package com.reallyfun.server.mapper;


import com.reallyfun.server.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setId(1);
        user.setName("user");
        user.setPassword("123456");
        user.setSalt("000");
        user.setEmail("123456@");
        user.setAvatar("png");
        user.setAuth(1);
        user.createBy("root");
        Integer row =userMapper.insert(user);
        System.out.println("row="+row);
    }

    @Test
    public void deleteByUid() {
        Integer rows = userMapper.deleteByUid(1);
        System.out.println("rows=" + rows);
    }


    @Test
    public void findByUid() {
        User result= userMapper.findByUid(1);
        System.out.println(result);
    }

    @Test
    public void findByUname(){
        User result = userMapper.findByUname("user");
        System.out.println(result);
    }
}