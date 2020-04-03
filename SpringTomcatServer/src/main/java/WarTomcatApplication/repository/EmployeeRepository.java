package WarTomcatApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import WarTomcatApplication.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
