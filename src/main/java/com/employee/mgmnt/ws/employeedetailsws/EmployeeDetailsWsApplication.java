package com.employee.mgmnt.ws.employeedetailsws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeDetailsWsApplication extends SpringBootServletInitializer{

	/*public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsWsApplication.class, args);
	}*/
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmployeeDetailsWsApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmployeeDetailsWsApplication.class, args);
    }
}
