package com.atsspt.online_xiaoxiang.mapper;

import com.atsspt.online_xiaoxiang.model.entity.Video;
import com.atsspt.online_xiaoxiang.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    List<Video> listVideo();
    List<VideoBanner> listvideoBanner();

    Video  findDetailById(@Param("video_id") int videoid);
}
