package com.atsspt.online_xiaoxiang.mapper;

import com.atsspt.online_xiaoxiang.model.entity.Episode;
import com.atsspt.online_xiaoxiang.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {
    int SaveRecord(PlayRecord playRecord);
}
