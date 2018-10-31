package com.ericdallo.btgclicksign.document;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClicksignDocument {

	@JsonProperty("key")
	private String key;
	
	@JsonProperty("folder_id")
	private Integer folderId;
	
	@JsonProperty("filename")
	private String filename;
	
	@JsonProperty("uploaded_at")
	private String uploaded_at;
	
	@JsonProperty("updated_at")
	private String updated_at;
	
	@JsonProperty("finished_at")
	private String finished_at;
	
	@JsonProperty("deadline_at")
	private String deadline_at;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("auto_close")
	private boolean auto_close;

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

	public String getUploaded_at() {
		return uploaded_at;
	}

	public void setUploaded_at(String uploaded_at) {
		this.uploaded_at = uploaded_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(String finished_at) {
		this.finished_at = finished_at;
	}

	public String getDeadline_at() {
		return deadline_at;
	}

	public void setDeadline_at(String deadline_at) {
		this.deadline_at = deadline_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAuto_close() {
		return auto_close;
	}

	public void setAuto_close(boolean auto_close) {
		this.auto_close = auto_close;
	}
	
}