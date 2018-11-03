package com.ericdallo.btgclicksign.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponseErrorFallback;
import com.github.ljtfreitas.restify.http.client.response.HttpResponseMessage;
import com.github.ljtfreitas.restify.http.contract.metadata.reflection.JavaType;

@Component
public class ClicksignAPIErrorFallback implements EndpointResponseErrorFallback {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClicksignAPIErrorFallback.class);

	@Override
	public <T> EndpointResponse<T> onError(HttpResponseMessage response, JavaType responseType) {
		LOGGER.error("Error with status code: " + response.statusCode() + " and body: " + response.body());
		
		return EndpointResponse.empty(response.statusCode(), response.headers());
	}

}
