package jquery.service;

import java.util.List;

import jquery.model.Employee;

public interface SomeRepository {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	
}
