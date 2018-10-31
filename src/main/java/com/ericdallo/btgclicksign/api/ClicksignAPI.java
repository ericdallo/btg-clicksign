package com.ericdallo.btgclicksign.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericdallo.btgclicksign.document.ClicksignDocument;
import com.github.ljtfreitas.restify.spring.configure.Restifyable;

@Restifyable
public interface ClicksignAPI {
	
	@GetMapping(path = "/documents", consumes = "application/json")
	List<ClicksignDocument> listDocuments(@RequestParam("access_token") String accessToken);

}
