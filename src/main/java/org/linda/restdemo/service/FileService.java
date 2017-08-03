package org.linda.restdemo.service;

import java.util.List;

import org.linda.restdemo.entity.FileMetadata;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
	
    public FileMetadata saveFile(MultipartFile file, FileMetadata metaData);

    public FileMetadata searchFileByFileId(Long fileId);
    
    public List<FileMetadata> searchFilesByFileName(String fileName);
    
}