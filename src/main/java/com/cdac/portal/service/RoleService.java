package com.cdac.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.portal.model.Role;
import com.cdac.portal.repository.RoleRepo;

@Service
public class RoleService {
    @Autowired
    private RoleRepo rr;

    public Role addRole(Role r) {
        Role existingRole = rr.findByroleName(r.getRoleName());
        if(existingRole == null) {
            return rr.save(r);
        }
        return existingRole;
    }

    public Role findByName(String roleName) {
        return rr.findByroleName(roleName);
    }
}

