package com.reallyfun.server.service;

import com.reallyfun.server.entity.User;
import com.reallyfun.server.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired(required = false)
    private IUserService iUserService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setId(2);
            user.setName("user1");
            user.setPassword("123456");
            user.setEmail("111@222");
            user.setAvatar("png");
            user.setAuth(1);
            iUserService.reg(user);
        }catch (ServiceException e){
            System.out.println("注册失败"+e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
