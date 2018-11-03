package com.ericdallo.btgclicksign.document;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClicksignDocumentsResponse {

	@JsonProperty("documents")
	private List<ClicksignDocument> documents;
	
	public void setDocuments(List<ClicksignDocument> documents) {
		this.documents = documents;
	}
	
	public List<ClicksignDocument> getDocuments() {
		return documents;
	}
}
