package com.atsspt.online_xiaoxiang.service;

import com.atsspt.online_xiaoxiang.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int saveOrdera(int user_id,int video_id);

    List<VideoOrder> ListOrderByUserid(int userid);
}
