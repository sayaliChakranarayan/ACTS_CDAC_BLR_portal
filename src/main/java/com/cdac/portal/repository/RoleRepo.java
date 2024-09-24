package com.cdac.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.portal.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByroleName(String roleName);
}