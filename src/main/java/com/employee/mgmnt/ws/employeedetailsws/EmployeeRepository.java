package com.employee.mgmnt.ws.employeedetailsws;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.w3c.dom.ranges.RangeException;

import com.nttdata.employees.EmployeeDetails;

@Component
public class EmployeeRepository {
	private static final Map<Integer, EmployeeDetails> employees = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		EmployeeDetails emp1 = new EmployeeDetails();
		emp1.setId(1);
		emp1.setName("Umesh Sonkar");
		emp1.setPassportNumber("P001");
		employees.put(emp1.getId(), emp1);

		EmployeeDetails emp2 = new EmployeeDetails();
		emp2.setId(2);
		emp2.setName("Arun Singh");
		emp2.setPassportNumber("P002");
		employees.put(emp2.getId(), emp2);
	}

	public EmployeeDetails findEmployee(Integer id) {
		Assert.notNull(id, "The Employee's name must not be null");
		return employees.get(id);
	}
	
	public Integer createEmployee(EmployeeDetails details) {
		Assert.notNull(details, "The Employee's details must not be null");
		int id = details.getId();
		if(employees.containsKey(id)){
			throw new RuntimeException("Another record is exist with this ID : "+id);
		}
		employees.put(id, details);
		return id;
	}
}