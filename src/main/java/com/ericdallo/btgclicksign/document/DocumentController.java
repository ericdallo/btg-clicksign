package com.ericdallo.btgclicksign.document;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ericdallo.btgclicksign.api.ClicksignAPI;
import com.ericdallo.btgclicksign.batch.BatchNotCreatedException;
import com.ericdallo.btgclicksign.batch.BatchRequest;
import com.ericdallo.btgclicksign.batch.ClicksignBatchRequest;
import com.ericdallo.btgclicksign.batch.ClicksignBatchResponse;
import com.ericdallo.btgclicksign.batch.ClicksignBatchResponse.Batch;
import com.ericdallo.btgclicksign.list.AllListsNotCreatedException;
import com.ericdallo.btgclicksign.list.ClicksignListRequest;
import com.ericdallo.btgclicksign.signer.Signer;
import com.ericdallo.btgclicksign.signer.SignerRepository;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.client.response.StatusCode;

@Controller
public class DocumentController {

	@Autowired
	private ClicksignAPI clicksignAPI;
	@Autowired
	private SignerRepository signerRepository;

	@GetMapping("/documents")
	public ModelAndView list(@RequestParam(name="accessToken", required=true) String accessToken, Model model) {
		
		Optional<ClicksignDocumentsResponse> documents = clicksignAPI.listDocuments(accessToken);
		
		if (documents.isPresent()) {
			model.addAttribute("documents", documents.get());
		}
		
		List<Signer> signers = signerRepository.findAll();
		
		model.addAttribute("signers", signers);
		
		return new ModelAndView("list");
	}
	
	@PostMapping(path = "/documents/batch", produces = "application/json")
	@ResponseBody
	public Batch createBatch(@RequestBody BatchRequest batch) {
		
		boolean createdListForAllDocuments = batch.getDocumentKeys().stream()
			.map(document -> {
				ClicksignListRequest listRequest = new ClicksignListRequest(document, batch.getSignerKey(), batch.getSingAs());
				
				EndpointResponse<Void> response = clicksignAPI.createList(batch.getAccessToken(), listRequest);
				
				return response.code();
			}).allMatch(StatusCode::isSucessful);
		
		if (!createdListForAllDocuments) {
			throw new AllListsNotCreatedException();
		}
		
		ClicksignBatchRequest batchRequest = new ClicksignBatchRequest(batch.getSignerKey(), batch.getDocumentKeys());
		
		Optional<ClicksignBatchResponse> batchResponse = clicksignAPI.createBatch(batch.getAccessToken(), batchRequest);
		
		if (!batchResponse.isPresent()) {
			throw new BatchNotCreatedException();
		}
		
		return batchResponse.get().getBatch();
		
	}
	
}