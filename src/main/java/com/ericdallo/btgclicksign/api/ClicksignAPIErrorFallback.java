package com.ericdallo.btgclicksign.api;

import org.springframework.stereotype.Component;

import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponseErrorFallback;
import com.github.ljtfreitas.restify.http.client.response.HttpResponseMessage;
import com.github.ljtfreitas.restify.http.contract.metadata.reflection.JavaType;

@Component
public class ClicksignAPIErrorFallback implements EndpointResponseErrorFallback {

	@Override
	public <T> EndpointResponse<T> onError(HttpResponseMessage response, JavaType responseType) {
		return EndpointResponse.empty(response.statusCode(), response.headers());
	}

}
