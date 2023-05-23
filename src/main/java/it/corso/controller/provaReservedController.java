package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.AdminService;

@Controller
@RequestMapping("/provaReserved")
public class provaReservedController {

	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String getPage() {
		
		return "provaReserved";
	}
}
