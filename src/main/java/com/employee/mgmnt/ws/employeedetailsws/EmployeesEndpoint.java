package com.employee.mgmnt.ws.employeedetailsws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nttdata.employees.CreateEmployeeDetailsRequest;
import com.nttdata.employees.CreateEmployeeDetailsResponse;
import com.nttdata.employees.GetEmployeeDetailsRequest;
import com.nttdata.employees.GetEmployeeDetailsResponse;

@Endpoint
public class EmployeesEndpoint {
	private static final String NAMESPACE_URI = "http://nttdata.com/employees";

	private EmployeeRepository  employeeRepository;

	@Autowired
	public EmployeesEndpoint(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeeDetailsRequest")
	@ResponsePayload
	public GetEmployeeDetailsResponse getEmployee(@RequestPayload GetEmployeeDetailsRequest request) {
		GetEmployeeDetailsResponse response = new GetEmployeeDetailsResponse();
		response.setEmployeeDetails(new EmployeeRepository().findEmployee(request.getId()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateEmployeeDetailsRequest")
	@ResponsePayload
	public CreateEmployeeDetailsResponse createEmployee(@RequestPayload CreateEmployeeDetailsRequest request) {
		CreateEmployeeDetailsResponse response = new CreateEmployeeDetailsResponse();
		response.setId(employeeRepository.createEmployee(request.getEmployeeDetails()));
		return response;
	}
	
	
}