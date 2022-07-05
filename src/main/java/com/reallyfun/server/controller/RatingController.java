package com.reallyfun.server.controller;

import com.reallyfun.server.entity.Rating;
import com.reallyfun.server.entity.User;
import com.reallyfun.server.service.IRatingService;
import com.reallyfun.server.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class RatingController extends BaseController {
    @Autowired
    private IRatingService iRatingService;
    @PostMapping("evaluate")
    public ResponseResult<Void> evaluate(Integer game_id, Integer rating, HttpSession session){
        User userNow = getUserFromSession(session);
        Rating ratingNow = new Rating();
        ratingNow.setRating(rating);
        ratingNow.setGameId(game_id);
        ratingNow.setUserId(userNow.getId());
        iRatingService.evaluate(ratingNow);
        return ResponseResult.getResponseResult("评分成功");
    }
}
