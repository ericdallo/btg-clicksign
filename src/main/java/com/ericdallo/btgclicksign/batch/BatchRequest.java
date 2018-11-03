package com.ericdallo.btgclicksign.batch;

import java.util.List;

import com.ericdallo.btgclicksign.signer.SignType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BatchRequest {

	@JsonProperty("signer_key")
	private String signerKey;
	
	@JsonProperty("document_keys")
	private List<String> documentKeys;
	
	@JsonProperty("sign_as")
	private SignType singAs;
	
	@JsonProperty("access_token")
	private String accessToken;

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

	public SignType getSingAs() {
		return singAs;
	}

	public void setSingAs(SignType singAs) {
		this.singAs = singAs;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
