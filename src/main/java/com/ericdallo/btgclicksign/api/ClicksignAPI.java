package com.ericdallo.btgclicksign.api;

import com.ericdallo.btgclicksign.document.ClicksignDocuments;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Header;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.QueryParameter;

public interface ClicksignAPI {
	
	@Get
	@Path("/documents")
	@Header(name = "Content-Type", value = "application/json")
	ClicksignDocuments listDocuments(@QueryParameter("access_token") String accessToken);

}
