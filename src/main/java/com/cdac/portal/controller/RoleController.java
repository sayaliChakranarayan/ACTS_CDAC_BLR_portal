package com.cdac.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.portal.model.Role;
import com.cdac.portal.service.RoleService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
	@Autowired
	private RoleService rs;
	@PostMapping("roles")
	public Role addRole(@RequestBody Role role) {
		return rs.addRole(role);
	}
	
}
