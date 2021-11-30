package com.atsspt.online_xiaoxiang.controller;

import com.atsspt.online_xiaoxiang.model.entity.Video;
import com.atsspt.online_xiaoxiang.model.entity.VideoBanner;
import com.atsspt.online_xiaoxiang.service.VideoService;
import com.atsspt.online_xiaoxiang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    public VideoService videoService;
    @RequestMapping("list_banner")
    public JsonData listVideoBanner(){
        List<VideoBanner> videoBanner = videoService.listvideoBanner();
        //int i = 1/0;
        return JsonData.buildSuccess(videoBanner);
    }
    @RequestMapping("list")
    public Object listVideo(){
        List<Video> videoList = videoService.listVideo();
        //System.out.println("testrebushu");
        return JsonData.buildSuccess(videoList);
    }
    @RequestMapping("findDetailByIda")
    @ResponseBody
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true) int videoid){
        Video video = videoService.findDetailById(videoid);
        return JsonData.buildSuccess(video);
    }
}
