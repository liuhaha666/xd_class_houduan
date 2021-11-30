package com.atsspt.online_xiaoxiang.service.impl;

import com.atsspt.online_xiaoxiang.config.CacheKeyManager;
import com.atsspt.online_xiaoxiang.model.entity.Video;
import com.atsspt.online_xiaoxiang.model.entity.VideoBanner;
import com.atsspt.online_xiaoxiang.mapper.VideoMapper;
import com.atsspt.online_xiaoxiang.service.VideoService;
import com.atsspt.online_xiaoxiang.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private BaseCache baseCache;
    @Override
    public List<Video> listVideo() {

        try {
            Object object = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_KEY, () -> {
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });
            if(object instanceof List) {
                List<Video> videoList= (List<Video>) object;
                return videoList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoBanner> listvideoBanner() {
        try {
            Object object = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> videoBannerList = videoMapper.listvideoBanner();
                return videoBannerList;
            });
            if(object instanceof List) {
                List<VideoBanner> videoBannerList = (List<VideoBanner>) object;
                return videoBannerList;
            }
         } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public Video findDetailById(int videoid) {
        String videokey = String.format(CacheKeyManager.VIDEO_DETAIL,videoid);

        try {
            Object object = baseCache.getOneHourCache().get(videokey, () -> {
                Video video = videoMapper.findDetailById(videoid);
                return video;
            });
            if(object instanceof Video) {
                Video video = (Video) object;
                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
