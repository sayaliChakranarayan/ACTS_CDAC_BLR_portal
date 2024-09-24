package com.cdac.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cdac.portal.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
public Student findByPrn(Long prn);

}
