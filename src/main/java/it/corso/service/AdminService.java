package it.corso.service;

import it.corso.model.Admin;
import jakarta.servlet.http.HttpSession;

public interface AdminService {
	
	Admin getAdminByUsername(String username);
	
	boolean controlloLogin(HttpSession session, String username, String password);
}
