package com.example.cloud_storage.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoredFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private Long size;

    private String fileUrl; // for local path / S3 link

    private LocalDateTime uploadTime;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;
}
