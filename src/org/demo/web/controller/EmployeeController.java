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

import org.demo.dao.EmployeeDao;
import org.demo.dao.UserDAO;
import org.demo.dao.UserDAOImpl;
import org.demo.service.EmployeeService;
import org.demo.web.model.Employee;
import org.demo.web.model.UserCO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmployeeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/SpringDemo-servlet.xml");
		EmployeeService empService = (EmployeeService)context.getBean("employeeService");
		EmployeeDao empDao = empService.getEmployeeDao();
		Employee employee = new Employee();
		employee.setName("Shiva Prasad");
		employee.setEmail("shiva.seelam@gmail.com");
		empDao.insert(employee);
		Map employeeModel = new HashMap();
		List eList = empDao.selectAll();
		//System.out.println("The list of all employees = " + eList);
		employeeModel.put("employees",eList);
		//return new ModelAndView("showUser", "model", userModel);
        return new ModelAndView("showEmployee", employeeModel);
	}

}
