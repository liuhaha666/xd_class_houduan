package com.atsspt.online_xiaoxiang.mapper;

import com.atsspt.online_xiaoxiang.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderMapper {
    VideoOrder findVideoByUseridAndVideoIdAndState(@Param("userid") int userid,@Param("videoid") int videoid,@Param("state") int state);
    int saveOrder(VideoOrder videoOrder);
    List<VideoOrder> ListOrderByUserid(@Param("userid") int userid);
}
