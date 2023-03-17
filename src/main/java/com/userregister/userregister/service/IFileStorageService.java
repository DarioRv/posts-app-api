package com.userregister.userregister.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileStorageService {
    void init();
    String store(MultipartFile file);
    Resource loadAsResource(String filename);
}
