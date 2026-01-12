package com.example.cloud_storage.repositories;

import com.example.cloud_storage.models.StoredFile;
import com.example.cloud_storage.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<StoredFile, Long> {
    List<StoredFile> findByOwner(User user);
}
