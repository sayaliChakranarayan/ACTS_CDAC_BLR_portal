package com.cdac.portal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cdac.portal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Optional<Employee> findByEmpid(long empid);
}
