package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.AdminDao;
import it.corso.model.Admin;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	
	@Override
	public boolean controlloLogin(HttpSession session, String username, String password) {
		Admin admin = adminDao.findByUsernameAndPassword(username, password);
		if (admin == null) {
			return false;
		}
		session.setAttribute("admin", admin);
		return true;
			
	}

}
