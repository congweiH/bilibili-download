package com.congwei.service.service;

import lombok.Data;

import java.util.List;

@Data
public class DownloadUrlResponse {
    private int code;

    private String message;

    private Data data;

    @lombok.Data
    static class Data {
        private List<Durl> durl;
    }

    @lombok.Data
    static class Durl {
        private String url;
    }
}
