package com.reallyfun.server.service.impl;

import com.reallyfun.server.entity.User;
import com.reallyfun.server.mapper.UserMapper;
import com.reallyfun.server.service.IUserService;
import com.reallyfun.server.service.ex.InsertException;
import com.reallyfun.server.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 处理数据的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getName();
        User result = userMapper.findByUname(username);
        if(result != null){
            throw new UsernameDuplicateException("尝试注册的用户名"+username+"已被占用");
        }
        // 创建当前时间对象
        Date now = new Date();
        // 补全数据：加密后的密码
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setPassword(md5Password);
        // 补全数据：盐值
        user.setSalt(salt);
        // 补全数据：4项⽇志属性
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        // 调⽤持久层Integer insert(User user)⽅法，执⾏注册并获取返回值(受影响的⾏数)
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            // 是：插⼊数据时出现某种错误，则抛出InsertException异常
            throw new InsertException("添加⽤户数据出现未知错误，请联系系统管理员");
        }
    }

    /**
     * 执⾏密码加密
     * @param password 原始密码
     * @param salt 盐值
     * @return 加密后的密⽂
     */
    private String getMd5Password(String password, String salt) {
        /*
         * 加密规则：
         * 1.⽆视原始密码的强度
         * 2.使⽤UUID作为盐值，在原始密码的左右两侧拼接
         * 3.循环加密3次
         */
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password +
                    salt).getBytes()).toUpperCase();
        }
        return password;
    }
}

