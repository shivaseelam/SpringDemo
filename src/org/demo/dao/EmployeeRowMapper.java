package org.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.web.model.Employee;
import org.demo.web.model.UserCO;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setEmail(rs.getString("email"));
		return emp;
	}
	
	

}
