package com.ericdallo.btgclicksign.document;

import java.time.LocalDateTime;

import com.ericdallo.btgclicksign.serializer.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ClicksignDocument {

	@JsonProperty("key")
	private String key;
	
	@JsonProperty("folder_id")
	private Integer folderId;
	
	@JsonProperty("filename")
	private String filename;
	
	@JsonProperty("uploaded_at")
	private String uploadedAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("finished_at")
	private String finishedAt;
	
	@JsonProperty("deadline_at")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime deadlineAt;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("auto_close")
	private boolean autoClose;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(String uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(String finishedAt) {
		this.finishedAt = finishedAt;
	}

	public LocalDateTime getDeadlineAt() {
		return deadlineAt;
	}

	public void setDeadlineAt(LocalDateTime deadlineAt) {
		this.deadlineAt = deadlineAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAutoClose() {
		return autoClose;
	}

	public void setAutoClose(boolean autoClose) {
		this.autoClose = autoClose;
	}
	
}