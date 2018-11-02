package com.ericdallo.btgclicksign.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

@Configuration
class ClicksignAPIConfiguration {

	@Value("${restify.clicksignAPI.endpoint}")
	private String clicksignAPIEndpoint;
	
	@Autowired
	private ClicksignAPIErrorFallback clicksignAPIErrorFallback;
	
	@Bean
	ClicksignAPI clicksignAPI() {
		return new RestifyProxyBuilder()
				.error(clicksignAPIErrorFallback)
				.target(ClicksignAPI.class, clicksignAPIEndpoint)
				.build();
	}
}