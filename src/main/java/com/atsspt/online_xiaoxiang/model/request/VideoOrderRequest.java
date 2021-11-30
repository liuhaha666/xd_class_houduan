package com.atsspt.online_xiaoxiang.model.request;

import com.atsspt.online_xiaoxiang.utils.JsonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class VideoOrderRequest{
    @JsonProperty("video_id")
    private int VideoId;

    public int getVideoId() {
        return VideoId;
    }

    public void setVideoId(int videoId) {
        VideoId = videoId;
    }
}
