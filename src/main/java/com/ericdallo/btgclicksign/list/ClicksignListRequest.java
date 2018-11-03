package com.ericdallo.btgclicksign.list;


import com.ericdallo.btgclicksign.signer.SignType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClicksignListRequest {

	@JsonProperty("list")
	private List list;
	
	/**
	 * Jackson eyes only
	 */
	@Deprecated
	ClicksignListRequest() {}
	
	public ClicksignListRequest(String documentKey, String signerKey, SignType signAs) {
		this.list = new List();
		this.list.documentKey = documentKey;
		this.list.signerKey = signerKey;
		this.list.signAs = signAs.name().toLowerCase();
	}
	
	public void setList(List list) {
		this.list = list;
	}
	
	public List getList() {
		return list;
	}
	
	public class List {
	
		@JsonProperty("document_key")
		private String documentKey;
		
		@JsonProperty("signer_key")
		private String signerKey;
		
		@JsonProperty("sign_as")
		private String signAs;

		public String getDocumentKey() {
			return documentKey;
		}

		public void setDocumentKey(String documentKey) {
			this.documentKey = documentKey;
		}

		public String getSignerKey() {
			return signerKey;
		}

		public void setSignerKey(String signerKey) {
			this.signerKey = signerKey;
		}

		public String getSignAs() {
			return signAs;
		}

		public void setSignAs(String signAs) {
			this.signAs = signAs;
		}
		
	}
}
