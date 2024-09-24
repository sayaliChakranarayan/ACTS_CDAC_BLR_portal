package com.cdac.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdac.portal.model.Login;
import com.cdac.portal.model.Role;
import com.cdac.portal.model.Student;
import com.cdac.portal.repository.LoginRepo;
import com.cdac.portal.repository.RoleRepo;
import com.cdac.portal.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private LoginService ls;
    @Autowired
    private RoleService rs;

    @Transactional
    public Student saveStudent(Student sp) {
        Login log = sp.getLogin() != null ? sp.getLogin() : new Login();
        log.setUserName(sp.getPrn().toString());
        log.setPassword(sp.getPassword());
        Role r = rs.findByName("student");
        if (r == null) {
            r = new Role();
            r.setRoleName("student");
            r = rs.addRole(r);
        }
        log.setRole(r);
        log = ls.addLogin(log);
        sp.setLogin(log);
        return sr.save(sp);  
    }

    public Student loginStudent(Long prn) {
        return sr.findByPrn(prn);
    }

    public Student editStudent(Student s) {
        Student es = sr.findByPrn(s.getPrn());
        if (es != null) {
            es.setFirstName(s.getFirstName());
            es.setEmail(s.getEmail());
            es.setGender(s.getGender());
            es.setImage(s.getImage());
            es.setLastName(s.getLastName());
            es.setMobileNo(s.getMobileNo());
            es.setPassword(s.getPassword());
            return sr.save(es);
        } else {
            return null;
        }
    }

    public boolean removeStudent(Student s) {
        if (sr.findByPrn(s.getPrn()) != null) {
            sr.deleteById(s.getPk());
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getStudents() {
        return sr.findAll();
    }
}
