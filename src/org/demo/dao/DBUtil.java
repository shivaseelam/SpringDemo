package org.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBUtil {
	private DataSource dataSource;
	 
	public DataSource getDataSource() {
	return dataSource;
	}
	 
	public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	}
	
	public void initialize(){
		DataSource dataSource = getDataSource();
			try {
				Connection connection = dataSource.getConnection();
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}
}
