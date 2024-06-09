package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
	
	@GetMapping("/inicio")
	public String getIndexPage(org.springframework.ui.Model model) {
		model.addAttribute("titulo", "inicio");
		return "index";
	}
}
