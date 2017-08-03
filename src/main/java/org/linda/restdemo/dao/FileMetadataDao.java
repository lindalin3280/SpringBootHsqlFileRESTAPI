package org.linda.restdemo.dao;
import java.util.List;

import org.linda.restdemo.entity.FileMetadata;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface FileMetadataDao {
	
	FileMetadata findByFileId(@Param("fileId") Long fileId);

	List<FileMetadata> findByFileName(@Param("fileName") String fileName);

	void save(FileMetadata metaData);
}
