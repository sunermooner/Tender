package com.reallyfun.server.mapper;


import com.reallyfun.server.entity.User;

/**
 * 处理数据操作的持久层接⼝
 */
public interface UserMapper {
    /**
     * 插入数据
     *
     * @param user 数据
     * @return 受影响行数
     */
    Integer insert(User user);

    /**
     * 根据eid删除数据
     *
     * @param id 数据id
     * @return 受影响的行数
     */
    Integer deleteByUid(Integer id);

    /**
     * 根据eid查询数据
     *
     * @param id 数据id
     * @return 匹配到的数据，若无则返回null
     */
    User findByUid(Integer id);

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return
     */
    User findByUname(String name);
}
