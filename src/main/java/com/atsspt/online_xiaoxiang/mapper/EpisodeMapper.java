package com.atsspt.online_xiaoxiang.mapper;

import com.atsspt.online_xiaoxiang.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {
    Episode findFirstEpisodeById(@Param("video_id") int video_id) ;
}
