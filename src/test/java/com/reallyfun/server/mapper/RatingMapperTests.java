package com.reallyfun.server.mapper;

import com.reallyfun.server.entity.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RatingMapperTests {
    @Autowired(required = false)
    private RatingMapper ratingMapper;

    @Test
    public void insertRating(){
        Rating rating =new Rating();
        rating.setRating(5);
        rating.setGameId(4);
        rating.setUserId(4);
        rating.createBy("root");
        Integer row = ratingMapper.insertRating(rating);
        System.out.println("rows=" + row);
    }

    @Test
    public void findByGameId(){
        Rating rating =ratingMapper.findByGameId(3,1);
        System.out.println(rating);
    }
}
