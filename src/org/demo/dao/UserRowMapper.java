package org.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.web.model.UserCO;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserCO user = new UserCO();
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("user_name"));
		return user;
	}
	
	

}
