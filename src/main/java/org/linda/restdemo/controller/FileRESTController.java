package org.linda.restdemo.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.linda.restdemo.entity.FileMetadata;
import org.linda.restdemo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value = "/file")
public class FileRESTController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String projectPath = System.getProperty("user.dir");
	public static final String fileSeparator = File.separator;

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response uploadFile(@RequestParam MultipartFile file, @RequestParam String userId) {
		FileMetadata metaData = new FileMetadata();
		metaData.setUploadTime(new Date());
		metaData.setUserId(userId);
		metaData.setFileName(file.getOriginalFilename());
		String newFileName = file.getOriginalFilename() + System.currentTimeMillis();
		metaData.setPath(projectPath + fileSeparator + newFileName);
		logger.info("uploading file: " + metaData);
		FileMetadata data = fileService.saveFile(file, metaData);
		return Response.status(200).entity(data).build();
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response query(@RequestParam(name = "fileId", required = false) Long fileId,
			@RequestParam(name = "fileName", required = false) String fileName) {
		logger.info("fileId = " + fileId + ", fileName = " + fileName);
		if (fileId == null && fileName == null) {
			return Response.status(400).entity("Either fileId or fileName should not be empty").build();
		} else if (fileId != null) {
			FileMetadata res = fileService.searchFileByFileId(fileId);
			return Response.status(200).entity(res).build();
		} else {
			List<FileMetadata> res = fileService.searchFilesByFileName(fileName);
			return Response.status(200).entity(res).build();
		}
	}
}
