package org.demo.dao;

import java.sql.Types;
import java.util.List;

import org.demo.business.ServiceLocator;
import org.demo.web.model.AddEmployeeCO;
import org.springframework.core.Constants;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

public class AddEmployeeDAOImpl implements AddEmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

		/*public Object getUser(int userid){
			 String sql = "select user_id, user_name from fwk_user where user_id="+userid;
			 return jdbcTemplate.queryForObject(sql, new Object[]{userid}, new UserRowMapper());
		}*/
		
		public String getUserName(int userid){
			 String sql = "select user_name from fwk_user where user_id="+userid;
			 return (String) jdbcTemplate.queryForObject(sql, String.class); 
		}
		
		public List getUsersList(int sgid){
			String sql = "select user_id, user_name from fwk_user where sgid = "+ sgid+" and active_status='Y' ";
			return jdbcTemplate.query(sql, new UserRowMapper());
		}

		@Override
		public AddEmployeeCO addEmployee(AddEmployeeCO empCO) throws DataIntegrityViolationException {
			 // This is to fetch the userId from sequence and then use it for insertion.
	        MySQLMaxValueIncrementer incrementer;
			try {
				incrementer = (MySQLMaxValueIncrementer) ServiceLocator.getInstance().getService("userIncrementer");
				empCO.setId(incrementer.nextIntValue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
			String sql = "insert into employee (id, name, email) values (?,?,?)";
			
			Object args [] = new Object[]{empCO.getId(), empCO.getName(), empCO.getEmail()};
			int types[] = new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR};
			jdbcTemplate.update(sql, args, types);
			return empCO;
		}

		@Override
		public List listEmployees() {
			String sql = "select id, name, email from employee";
			return jdbcTemplate.query(sql, new EmployeeRowMapper());
		}

		@Override
		public void deleteEmployee(int id) {
			String sql = "delete from employee where id = "+id;
			Object args [] = new Object[]{id};
			int types[] = new int[]{Types.INTEGER};
			jdbcTemplate.update(sql, args, types);
		}
		
		/*public Object getUsers(int sgid){
			String sql = "select user_name from fwk_user where sgid = "+ sgid;
			return jdbcTemplate.queryForObject(sql, new Object[]{sgid}, new UserRowMapper());
		}*/
		
		/*public List getAllUsers(){
			 String sql = "select cityguide_id from ht_forum_cityguides,vr_user where " +
		                "ht_forum_cityguides.vr_user_id=vr_user.vr_user_id";
		}*/
}
