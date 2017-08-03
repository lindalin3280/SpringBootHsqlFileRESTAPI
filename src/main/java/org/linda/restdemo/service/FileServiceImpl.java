package org.linda.restdemo.service;

import java.io.IOException;
import java.util.List;

import org.linda.restdemo.component.FileIO;
import org.linda.restdemo.dao.FileMetadataDao;
import org.linda.restdemo.entity.FileMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiceImpl implements FileService {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FileMetadataDao fileMetadataDao;

	@Autowired
	private FileIO fileio;

	@Override
	@Transactional
	public FileMetadata saveFile(MultipartFile file, FileMetadata metaData) {
		fileMetadataDao.save(metaData);
		try {
			fileio.saveFile(file.getBytes(), metaData.getPath());
		} catch (IOException e) {
			logger.error("Error when metaData = " + metaData, e);
		}
		return metaData;
	}

	@Override
	@Transactional(readOnly = true)
	public FileMetadata searchFileByFileId(Long fileId) {
		return fileMetadataDao.findByFileId(fileId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileMetadata> searchFilesByFileName(String fileName) {
		return fileMetadataDao.findByFileName(fileName);
	}
}
