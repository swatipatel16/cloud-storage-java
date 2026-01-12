package com.example.cloud_storage.repositories;

import com.example.cloud_storage.models.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FileDBRepository extends JpaRepository<FileDB, Long> {
    List<FileDB> findByUserEmail(String email);
}
