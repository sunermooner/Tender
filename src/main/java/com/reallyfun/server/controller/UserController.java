package com.reallyfun.server.controller;

import com.reallyfun.server.entity.User;
import com.reallyfun.server.service.IUserService;
import com.reallyfun.server.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private IUserService iUserService;

    @RequestMapping("reg")
    public ResponseResult<Void> reg(User user){
        iUserService.reg(user);
        return ResponseResult.getResponseResult("注册成功");
    }
}
