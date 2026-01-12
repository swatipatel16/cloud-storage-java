package com.example.cloud_storage.services;

import com.example.cloud_storage.models.FileDB;
import com.example.cloud_storage.repositories.FileDBRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final FileDBRepository repo;

    public FileStorageService(FileDBRepository repo) {
        this.repo = repo;
    }

    public FileDB store(MultipartFile file, String email) throws Exception {
        FileDB fileDB = FileDB.builder()
                .filename(file.getOriginalFilename())
                .fileType(file.getContentType())
                .data(file.getBytes())
                .userEmail(email)
                .build();

        return repo.save(fileDB);
    }
}
