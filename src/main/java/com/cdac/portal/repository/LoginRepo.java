package com.cdac.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.portal.model.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {

}
