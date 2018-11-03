package com.ericdallo.btgclicksign.api;

import java.util.Optional;

import com.ericdallo.btgclicksign.batch.ClicksignBatchRequest;
import com.ericdallo.btgclicksign.batch.ClicksignBatchResponse;
import com.ericdallo.btgclicksign.document.ClicksignDocumentsResponse;
import com.ericdallo.btgclicksign.list.ClicksignListRequest;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.contract.BodyParameter;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Header;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.Post;
import com.github.ljtfreitas.restify.http.contract.QueryParameter;

public interface ClicksignAPI {
	
	@Get
	@Path("/documents")
	@Header(name = "Content-Type", value = "application/json")
	Optional<ClicksignDocumentsResponse> listDocuments(@QueryParameter("access_token") String accessToken);
	
	@Post
	@Path("/lists")
	@Header(name = "Content-Type", value = "application/json")
	EndpointResponse<Void> createList(@QueryParameter("access_token") String accessToken, @BodyParameter ClicksignListRequest listRequest);

	@Post
	@Path("/batches")
	@Header(name = "Content-Type", value = "application/json")
	Optional<ClicksignBatchResponse> createBatch(@QueryParameter("access_token") String accessToken, @BodyParameter ClicksignBatchRequest batchRequest);
}
