package org.demo.dao;

import java.util.List;

import org.demo.web.model.AddEmployeeCO;

public interface AddEmployeeDAO {
	public AddEmployeeCO addEmployee(AddEmployeeCO emp);
	public List listEmployees();
	public void deleteEmployee(int id);
}
