package com.reallyfun.server.service;

import com.reallyfun.server.entity.Rating;
import com.reallyfun.server.service.ex.RatingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RatingServiceTest {
    @Autowired(required = false)
    private IRatingService iRatingService;

    @Test
    public void evaluate(){
        try {
            Rating rating = new Rating();
            rating.setUserId(1);
            rating.setGameId(5);
            rating.setRating(5);
            System.out.println(rating);
            iRatingService.evaluate(rating);
        }catch (RatingException e){
            System.out.println("评价失败"+e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
