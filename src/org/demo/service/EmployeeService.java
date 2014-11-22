package org.demo.service;

import org.demo.dao.EmployeeDao;
import org.demo.web.model.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void addEmployee(Employee employee){
		employeeDao.insert(employee);
	}

}
