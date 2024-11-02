package iuh.fit.se.services;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.fit.se.entities.Employee;

public interface EmployeeService {

	public Employee findById(int id);
	
	public List<Employee> findAll();
	
	public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
	
	public Employee save (Employee employee);
	public Employee update(int id, Employee employee);
	
	public boolean delete(int id);
	
	public List<Employee> search (String keyword);
}
