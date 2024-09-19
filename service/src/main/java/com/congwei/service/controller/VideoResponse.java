package com.congwei.service.controller;

import com.congwei.service.service.CidResponse;
import lombok.Data;

import java.util.List;

@Data
public class VideoResponse {
    private String title;
    private String pic;
    private List<CidResponse.Page> pages;
}
