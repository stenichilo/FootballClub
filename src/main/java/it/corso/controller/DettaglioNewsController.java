package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.NewsService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettaglioNews")
public class DettaglioNewsController {

	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam("idNews") int id,
			HttpSession session) {
		model.addAttribute("news", newsService.getNewsById(id));
		model.addAttribute("admin", session.getAttribute("admin") != null);
		return "dettaglioNews";
	}
}
