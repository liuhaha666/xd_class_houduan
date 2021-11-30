package com.atsspt.online_xiaoxiang.controller;

import com.atsspt.online_xiaoxiang.model.entity.VideoOrder;
import com.atsspt.online_xiaoxiang.model.request.VideoOrderRequest;
import com.atsspt.online_xiaoxiang.service.VideoOrderService;
import com.atsspt.online_xiaoxiang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {
    @Autowired
    VideoOrderService videoOrderService;
    @PostMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest servletRequest){
        Integer userId = (Integer)servletRequest.getAttribute("userid");
        int rows = videoOrderService.saveOrdera(userId,videoOrderRequest.getVideoId());

        return rows == 0? JsonData.buildError("下单失败"):JsonData.buildSuccess();
        }
    @RequestMapping("lisorder")
    public JsonData listOrder(HttpServletRequest servletRequest){
        Integer userId = (Integer) servletRequest.getAttribute("userid");
        List<VideoOrder> videoOrderList= videoOrderService.ListOrderByUserid(userId);
        return JsonData.buildSuccess(videoOrderList);

    }

}
