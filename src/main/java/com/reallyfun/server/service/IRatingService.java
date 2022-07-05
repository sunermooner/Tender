package com.reallyfun.server.service;

import com.reallyfun.server.entity.Rating;

public interface IRatingService {
    /**
     *
     * @param rating 评分类
     */
    void evaluate(Rating rating);
}
