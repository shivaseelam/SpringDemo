package org.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpl implements UserDAO {
	
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
		
		/*public Object getUsers(int sgid){
			String sql = "select user_name from fwk_user where sgid = "+ sgid;
			return jdbcTemplate.queryForObject(sql, new Object[]{sgid}, new UserRowMapper());
		}*/
		
		/*public List getAllUsers(){
			 String sql = "select cityguide_id from ht_forum_cityguides,vr_user where " +
		                "ht_forum_cityguides.vr_user_id=vr_user.vr_user_id";
		}*/
}
