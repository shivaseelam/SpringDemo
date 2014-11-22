package org.demo.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.demo.dao.AddEmployeeDAO;
import org.demo.dao.AddEmployeeDAOImpl;
import org.demo.dao.EmployeeDao;
import org.demo.dao.UserDAO;
import org.demo.dao.UserDAOImpl;
import org.demo.web.model.Employee;
import org.demo.web.model.UserCO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListEmployeeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/SpringDemo-servlet.xml");
        BeanFactory beanFactory = context;
        
        DataSource ds = (DataSource) beanFactory.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate(ds);
        
        AddEmployeeDAOImpl employeeDAO = new AddEmployeeDAOImpl();
        employeeDAO.setJdbcTemplate(template);
        UserCO userl;
        
        
        Map userModel = new HashMap();
        List<Employee> emplist = employeeDAO.listEmployees();
        userModel.put("employees",emplist);
        return new ModelAndView("listEmployee", userModel);
	}

}
