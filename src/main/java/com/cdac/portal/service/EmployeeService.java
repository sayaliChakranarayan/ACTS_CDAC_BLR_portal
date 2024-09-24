package com.cdac.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.portal.model.Employee;
import com.cdac.portal.model.Login;
import com.cdac.portal.model.Role;
import com.cdac.portal.model.Student;
import com.cdac.portal.repository.EmployeeRepository;
import com.cdac.portal.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository sr;
    @Autowired
    private LoginService ls;
    @Autowired
    private RoleService rs;

    @Transactional
    public Employee saveEmployee(Employee sp) {
        Login log = sp.getLogin() != null ? sp.getLogin() : new Login();
        log.setUserName(sp.getEmpid().toString());
        log.setPassword(sp.getPassword());
        Role r = rs.findByName("employee");
        if (r == null) {
            r = new Role();
            r.setRoleName("employee");
            r = rs.addRole(r);
        }
        log.setRole(r);
        log = ls.addLogin(log);
        sp.setLogin(log);
        return sr.save(sp);  
    }

    public Optional<Employee> loginStudent(Long empid) {
        return sr.findByEmpid(empid);
    }

      public boolean removeStudent(Employee s) {
        if (sr.findByEmpid(s.getEmpid()) != null) {
            sr.deleteById(s.getPk());
            return true;
        } else {
            return false;
        }
    }

}
