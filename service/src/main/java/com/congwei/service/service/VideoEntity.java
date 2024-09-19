package com.congwei.service.service;

import lombok.Data;

import java.util.List;

@Data
public class VideoEntity {
    private String title;
    private String pic;
    private List<CidResponse.Page> pages;
}
