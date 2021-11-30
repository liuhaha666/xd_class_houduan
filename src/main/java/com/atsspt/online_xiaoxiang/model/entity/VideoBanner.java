package com.atsspt.online_xiaoxiang.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

//轮播图
/*
*`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
  `img` varchar(256) DEFAULT NULL COMMENT '图片地址',
  `create_time` datetime DEFAULT NULL,
  `weight` int(11) DEFAULT NULL COMMENT '数字越小排越前',
* */
public class VideoBanner {
    public int id;
    public String url;
    public String img;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date create_time;
    public int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", create_time=" + create_time +
                ", weight=" + weight +
                '}';
    }
}
