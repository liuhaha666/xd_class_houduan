package com.atsspt.online_xiaoxiang.service;

import com.atsspt.online_xiaoxiang.model.entity.Video;
import com.atsspt.online_xiaoxiang.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listvideoBanner();


    Video findDetailById(int videoid);
}
