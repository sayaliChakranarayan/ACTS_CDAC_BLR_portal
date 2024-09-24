package com.cdac.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.portal.model.Login;
import com.cdac.portal.model.Role;
import com.cdac.portal.repository.LoginRepo;
import com.cdac.portal.repository.RoleRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo lr;
    @Autowired
    private RoleService rs;

    public Login addLogin(Login l) {
        Role r = rs.addRole(l.getRole());
        l.setRole(r);
        return lr.save(l);
    }
}
