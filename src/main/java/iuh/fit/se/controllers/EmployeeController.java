package iuh.fit.se.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
 private EmployeeService employeeService;
	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> getEmployeeById(@PathVariable int id){
		Map<String, Object> response =  new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("message", employeeService.findById(id));
		return  ResponseEntity.status(HttpStatus.OK).body(response);

		
	}
}
