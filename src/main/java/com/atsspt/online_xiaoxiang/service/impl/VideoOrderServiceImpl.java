package com.atsspt.online_xiaoxiang.service.impl;

import com.atsspt.online_xiaoxiang.exception.XDException;
import com.atsspt.online_xiaoxiang.mapper.EpisodeMapper;
import com.atsspt.online_xiaoxiang.mapper.PlayRecordMapper;
import com.atsspt.online_xiaoxiang.mapper.VideoMapper;
import com.atsspt.online_xiaoxiang.mapper.VideoOrderMapper;
import com.atsspt.online_xiaoxiang.model.entity.*;
import com.atsspt.online_xiaoxiang.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class VideoOrderServiceImpl implements VideoOrderService{
    @Autowired
    VideoOrderMapper videoOrderMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    EpisodeMapper episodeMapper;

    @Autowired
    PlayRecordMapper playRecordMapper;

    @Override
    @Transactional
    public int saveOrdera(int user_id, int video_id) {
        VideoOrder videoOrder = videoOrderMapper.findVideoByUseridAndVideoIdAndState(user_id,video_id,1);
        //用户已经下过单
        if (videoOrder != null) return 0;
        System.out.println(videoMapper);
        Video video = videoMapper.findDetailById(video_id);
        VideoOrder retVideoOrder = new VideoOrder();

        retVideoOrder.setVideoId(video_id);
        retVideoOrder.setUserId(user_id);
        //retVideoOrder.setVideo_img(video.getCoverImg());
        retVideoOrder.setCreateTime(new Date());
        retVideoOrder.setVideoTitle(video.getVideoTitle());
        retVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        retVideoOrder.setState(1);
        retVideoOrder.setTotalFee(video.getPrice());

        int rows = videoOrderMapper.saveOrder(retVideoOrder);

        //下单之后才能播放
        if(rows==1){
            System.out.println(video_id);
            Episode episode = episodeMapper.findFirstEpisodeById(video_id);
            if(episode == null){
                throw new XDException(-1,"没有相应video_id信息");
            }
            //如果没查出来，说明没有相应video_id信息
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setUserId(user_id);
            playRecord.setVideoId(video_id);
            playRecord.setEpisodeId(episode.getEpisodeId());
            playRecord.setCurrentNum(episode.getNum());
            playRecordMapper.SaveRecord(playRecord);
        }
        return rows;
    }

    @Override
    public List<VideoOrder> ListOrderByUserid(int user_id) {
        List<VideoOrder> videoOrderList = videoOrderMapper.ListOrderByUserid(user_id);
        return videoOrderList;
    }
}
