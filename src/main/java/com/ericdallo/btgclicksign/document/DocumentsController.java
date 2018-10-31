package com.ericdallo.btgclicksign.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ericdallo.btgclicksign.api.ClicksignAPI;

@Controller
public class DocumentsController {

	@Autowired
	private ClicksignAPI clicksignAPI;

	@GetMapping("/documents")
	public ModelAndView list(@RequestParam(name="accessToken", required=true) String accessToken, Model model) {
		
		List<ClicksignDocument> documents = clicksignAPI.listDocuments(accessToken);
		
		model.addAllAttributes(documents);
		
		return new ModelAndView("list");
	}
}