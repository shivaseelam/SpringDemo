package org.demo.service;

import javax.sql.DataSource;

import org.demo.dao.UserDAOImpl;
import org.demo.web.model.UserCO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext-resources.xml");
        BeanFactory beanFactory = context;
        
        DataSource ds = (DataSource) beanFactory.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate(ds);
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.setJdbcTemplate(template);
        UserCO user;
        System.out.println("!!! user is "+userDAO.getUserName(41));
        
	}

}
