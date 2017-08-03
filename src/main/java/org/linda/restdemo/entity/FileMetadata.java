package org.linda.restdemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "fileMetadata")
public class FileMetadata implements Serializable {
	private static final long serialVersionUID = 4895237878L;

	@Id
	@GeneratedValue
	private Long fileId;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private String fileName;

	@Column(nullable = false)
	private String path;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "EST")
	private Date uploadTime;

	public FileMetadata() {

	}

	public FileMetadata(Long fileId, String userId, String fileName, String path, Date uploadTime) {
		super();
		this.fileId = fileId;
		this.userId = userId;
		this.fileName = fileName;
		this.path = path;
		this.uploadTime = uploadTime;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getUserId() {
		return userId;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileMetadata [fileId=");
		builder.append(fileId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", path=");
		builder.append(path);
		builder.append(", uploadTime=");
		builder.append(uploadTime);
		builder.append("]");
		return builder.toString();
	}
}
