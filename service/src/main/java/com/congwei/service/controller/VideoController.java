package com.congwei.service.controller;

import com.congwei.service.service.VideoEntity;
import com.congwei.service.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bilibili/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<VideoResponse> getDownloadUrl(@RequestParam("bvid") String bvid) {

        VideoEntity videoEntity = videoService.getDownloadUrl(bvid);

        VideoResponse videoResponse = new VideoResponse();
        videoResponse.setUrl(videoEntity.getUrl());
        videoResponse.setPic(videoEntity.getPic());
        videoResponse.setTitle(videoEntity.getTitle());

        return ResponseEntity.ok(videoResponse);
    }
}
