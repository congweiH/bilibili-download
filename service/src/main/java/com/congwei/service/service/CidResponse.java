package com.congwei.service.service;

import lombok.Data;

@Data
public class CidResponse {

    private int code;

    private String message;

    private Data data;

    @lombok.Data
    static class Data {
        private String cid;

        private String pic;

        private String title;
    }

}
