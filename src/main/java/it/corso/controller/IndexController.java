package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.AdminService;
import it.corso.service.NewsService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public String getPage(@RequestParam(name="le", required = false) String logError, Model model) {
		model.addAttribute("logError", logError != null);
		model.addAttribute("news", newsService.getNews());
		return "index";
	}
	
	
}
