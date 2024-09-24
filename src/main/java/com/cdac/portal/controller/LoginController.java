package com.cdac.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.portal.model.Login;
import com.cdac.portal.service.LoginService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private LoginService ls;

	@PostMapping("addLogin")
	public Login addLogin(@RequestBody Login l) {
		return ls.addLogin(l);
	}
}
