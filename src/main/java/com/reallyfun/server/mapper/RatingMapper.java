package com.reallyfun.server.mapper;

import com.reallyfun.server.entity.Rating;

public interface RatingMapper {

    /**
     *
     * @param rating 评分类
     * @return 影响行数
     */
    Integer insertRating(Rating rating);

    /**
     *
     * @param gameId 游戏id
     * @return 返回类
     */
    Rating findByGameId(Integer gameId,Integer userId);
}
