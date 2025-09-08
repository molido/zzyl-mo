package com.zzyl.oss.client;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class OSSAliyunFileStorageService {

    public String store(String fileName, InputStream inputStream) {
        // Minimal stub: in local dev, return a pseudo URL.
        return "/static/" + fileName;
    }
}


