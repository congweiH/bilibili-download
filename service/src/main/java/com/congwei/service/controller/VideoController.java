package com.congwei.service.controller;

import com.congwei.service.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilibili/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/download-url")
    public ResponseEntity<String> getDownloadUrl(@RequestParam("bvid") String bvid) {
        return ResponseEntity.ok(videoService.getDownloadUrl(bvid));
    }
}
