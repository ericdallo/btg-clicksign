package com.ericdallo.btgclicksign.batch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClicksignBatchResponse {

	@JsonProperty("batch")
	private Batch batch;
	
	public Batch getBatch() {
		return batch;
	}
	
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	public class Batch {
		
		@JsonProperty("key")
		private String key;

		@JsonProperty("request_signature_key")
		private String requestSignatureKey;

		@JsonProperty("url")
		private String url;

		@JsonProperty("signer_key")
		private String signerKey;

		@JsonProperty("document_keys")
		private List<String> documentKeys;

		@JsonProperty("summary")
		private boolean summary;

		@JsonProperty("created_at")
		private String createdAt;

		@JsonProperty("updated_at")
		private String updatedAt;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getRequestSignatureKey() {
			return requestSignatureKey;
		}

		public void setRequestSignatureKey(String requestSignatureKey) {
			this.requestSignatureKey = requestSignatureKey;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getSignerKey() {
			return signerKey;
		}

		public void setSignerKey(String signerKey) {
			this.signerKey = signerKey;
		}

		public List<String> getDocumentKeys() {
			return documentKeys;
		}

		public void setDocumentKeys(List<String> documentKeys) {
			this.documentKeys = documentKeys;
		}

		public boolean isSummary() {
			return summary;
		}

		public void setSummary(boolean summary) {
			this.summary = summary;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public String getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}
		
	}
}
