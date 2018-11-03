package com.ericdallo.btgclicksign.batch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClicksignBatchRequest {

	@JsonProperty("batch")
	private Batch batch;

	/**
	 * Jackson eyes only
	 */
	@Deprecated
	ClicksignBatchRequest(){ }
	
	public ClicksignBatchRequest(String signerKey, List<String> documentKeys) {
		this.batch = new Batch();
		this.batch.signerKey = signerKey;
		this.batch.documentKeys = documentKeys;
		this.batch.summary = true;
	}
	
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	public Batch getBatch() {
		return batch;
	}
	
	public class Batch {
		
		@JsonProperty("signer_key")
		private String signerKey;
		
		@JsonProperty("document_keys")
		private List<String> documentKeys;
		
		@JsonProperty("summary")
		private boolean summary;
		
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
		
	}
}
