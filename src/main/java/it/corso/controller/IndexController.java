package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



import it.corso.service.NewsService;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public String getPage(Model model) {
		model.addAttribute("news", newsService.getNews());
		return "index";
	}
	
	
}
