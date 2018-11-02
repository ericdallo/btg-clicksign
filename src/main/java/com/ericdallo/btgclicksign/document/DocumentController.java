package com.ericdallo.btgclicksign.document;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ericdallo.btgclicksign.api.ClicksignAPI;
import com.ericdallo.btgclicksign.signer.Signer;
import com.ericdallo.btgclicksign.signer.SignerRepository;

@Controller
public class DocumentController {

	@Autowired
	private ClicksignAPI clicksignAPI;
	@Autowired
	private SignerRepository signerRepository;

	@GetMapping("/documents")
	public ModelAndView list(@RequestParam(name="accessToken", required=true) String accessToken, Model model) {
		
		Optional<ClicksignDocuments> documents = clicksignAPI.listDocuments(accessToken);
		
		if (documents.isPresent()) {
			model.addAttribute("documents", documents.get());
		}
		
		List<Signer> signers = signerRepository.findAll();
		
		model.addAttribute("signers", signers);
		
		return new ModelAndView("list");
	}
}