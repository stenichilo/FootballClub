package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



import it.corso.service.NewsService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public String getPage(Model model,
			HttpSession session) {
		model.addAttribute("news", newsService.getNews());
		model.addAttribute("utente", session.getAttribute("utente") != null);
		model.addAttribute("admin", session.getAttribute("admin") != null);
		return "index";
	}
	
	
}
