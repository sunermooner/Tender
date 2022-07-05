package com.reallyfun.server.service.impl;

import com.reallyfun.server.entity.Rating;
import com.reallyfun.server.entity.User;
import com.reallyfun.server.mapper.RatingMapper;
import com.reallyfun.server.mapper.UserMapper;
import com.reallyfun.server.service.IRatingService;
import com.reallyfun.server.service.ex.RatingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingServiceImpl implements IRatingService {
    @Autowired
    private RatingMapper ratingMapper;
    @Autowired
    private UserMapper userMapper;

    public void evaluate(Rating rating){
        Integer gameid=rating.getGameId();
        Integer userid=rating.getUserId();
        if(ratingMapper.findByGameId(gameid,userid) != null){
            throw new RatingException("抱歉，您已对该游戏进行评价过");
        }
        Date now = new Date();
        /**
         * 注意是否能从用户表中找到对应用户 否则会传空指针
         */
        User user = userMapper.findByUid(userid);
        if(user == null){
            System.out.println("用户为空，请重试");
        }
        rating.setCreatedUser(user.getName());
        rating.setCreatedTime(now);
        rating.setModifiedUser(user.getName());
        rating.setModifiedTime(now);
        Integer row = ratingMapper.insertRating(rating);
        if(row != 1){
            throw  new RatingException("添加游戏评分出现未知错误，请重试");
        }
    }

}
