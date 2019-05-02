package jquery.service;

import java.util.List;

import jquery.controller.TimeChecker;
import jquery.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import jquery.model.Employee;
import org.springframework.stereotype.Service;

@Service("thisMegaShit")
public class OhNononono implements SomeRepository {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		TimeChecker.TimeCheck("thisMegaShit getallEmployees requested");
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findOne(id);
	}

}
