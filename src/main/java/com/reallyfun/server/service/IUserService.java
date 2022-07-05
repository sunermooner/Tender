package com.reallyfun.server.service;

import com.reallyfun.server.entity.User;

public interface IUserService {

    /**
     *
     * @param user 用户
     *             将注册用户上传数据库中
     */
    void reg(User user);
}
