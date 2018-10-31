package com.ericdallo.btgclicksign.document;

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
		
		ClicksignDocuments documents = clicksignAPI.listDocuments(accessToken);
		
		model.addAttribute("documents", documents);
		
		return new ModelAndView("list");
	}
}