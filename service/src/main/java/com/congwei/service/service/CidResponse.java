package com.congwei.service.service;

import lombok.Data;

import java.util.List;

@Data
public class CidResponse {

    private int code;

    private String message;

    private Data data;

    @lombok.Data
    static class Data {
        private String pic;

        private String title;

        private List<Page> pages;
    }

    @lombok.Data
    public static class Page {
        private String cid;
        private String part;
        private String url;
    }

}
