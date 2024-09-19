package com.congwei.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
public class VideoServiceImpl implements VideoService{
    private final static String GET_DOWNLOAD_URL = "https://api.bilibili.com/x/player/playurl";

    private final static String GET_CID_URL = "https://api.bilibili.com/x/web-interface/view";

    @Value("${sessData}")
    private String SESS_DATA;

    @Override
    public VideoEntity getDownloadUrl(String bvid) {
        RestTemplate restTemplate = new RestTemplate();

        VideoEntity videoEntity = getCid(bvid);

        for (CidResponse.Page page : videoEntity.getPages()) {
            URI targetUrl = UriComponentsBuilder.fromHttpUrl(GET_DOWNLOAD_URL)
                    .queryParam("bvid", bvid)
                    .queryParam("cid", page.getCid())
                    .queryParam("qn", 80)
                    .queryParam("type", "mp4")
                    .queryParam("platform", "html5")
                    .queryParam("high_quality", "1")
                    .build()
                    .encode()
                    .toUri();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cookie", "SESSDATA=" + SESS_DATA);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<DownloadUrlResponse> response = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, DownloadUrlResponse.class);
            page.setUrl(Objects.requireNonNull(response.getBody()).getData().getDurl().get(0).getUrl());
        }
        return videoEntity;
    }

    @Override
    public VideoEntity getCid(String bvid) {
        RestTemplate restTemplate = new RestTemplate();

        URI targetUrl = UriComponentsBuilder.fromHttpUrl(GET_CID_URL)
                .queryParam("bvid", bvid)
                .build()
                .encode()
                .toUri();

        ResponseEntity<CidResponse> response = restTemplate.getForEntity(targetUrl, CidResponse.class);

        CidResponse.Data data = Objects.requireNonNull(response.getBody()).getData();

        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setPic(data.getPic());
        videoEntity.setTitle(data.getTitle());
        videoEntity.setPages(data.getPages());
        return videoEntity;
    }
}
