package com.cdac.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.cdac.portal.model.Student;
import com.cdac.portal.service.StudentService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	@Autowired
	private StudentService ss;
	@PostMapping("/student/registration")
	public Student saveStudent(@Validated @RequestBody Student sp) {
		return ss.saveStudent(sp);
	}
	@PostMapping("student/login")
	public ResponseEntity<Boolean> loginStudent(@Validated @RequestBody Student sp) {
		Boolean isLogIn = false;
		long user_name = sp.getPrn();
		String password = sp.getPassword();
		try {	
			Student s = ss.loginStudent(user_name);
		if(user_name==s.getPrn() && password.equals(s.getPassword())) {
			isLogIn=true;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(isLogIn);
	}	
	@GetMapping("/profile/{id}")
	public Student getById(@Validated @RequestBody @PathVariable(value="id")Long un) {
		return ss.loginStudent(un);
	}
	
}
