package org.demo.web.controller;

import java.util.List;

import org.demo.dao.EmployeeDao;
import org.demo.service.EmployeeService;
import org.demo.web.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestHiberDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub3
		
		ApplicationContext context = new FileSystemXmlApplicationContext("d:/spring_config/spring-config.xml");
		EmployeeService empService = (EmployeeService)context.getBean("employeeService");
		
		EmployeeDao empDao = empService.getEmployeeDao();
		Employee employee = new Employee();
		employee.setName("Shiva");
		employee.setEmail("shiva.n2g@gmail.com");
		empDao.insert(employee);
		
		List eList = empDao.selectAll();
		System.out.println("The list of all employees = " + eList);

	}

}
