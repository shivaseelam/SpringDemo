package org.demo.web.controller;

import org.apache.log4j.Logger;
import org.demo.dao.AddEmployeeDAO;
import org.demo.dao.AddEmployeeDAOImpl;
import org.demo.dao.EmployeeDao;
import org.demo.dao.UserDAOImpl;
import org.demo.web.model.AddEmployeeCO;
import org.demo.web.model.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.util.Map;

public class AddEmployeeController extends SimpleFormController {

    private static Logger logger = Logger.getLogger(AddEmployeeController.class);

    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                 Object command, BindException errors)
            throws Exception {
        AddEmployeeCO addEmployeeCO = (AddEmployeeCO) command;
        String name = addEmployeeCO.getName();
        logger.info("Name submitted " + name);
        String email = addEmployeeCO.getEmail();
        logger.info("Email " + email);
        
        int emp_id = Integer.parseInt(request.getParameter("delid"));
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/SpringDemo-servlet.xml");
        BeanFactory beanFactory = context;
        DataSource ds = (DataSource) beanFactory.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate(ds);
        
        AddEmployeeDAOImpl empDAO = new AddEmployeeDAOImpl();
        empDAO.deleteEmployee(addEmployeeCO.getId());
        
        /*if (emp_id>0){
        	empDAO.deleteEmployee(addEmployeeCO.getId());
        }
        else{
            empDAO.setJdbcTemplate(template);
            empDAO.addEmployee(addEmployeeCO);
        }*/
        
        return new ModelAndView(getSuccessView());
    }
    
    protected Map referenceData(HttpServletRequest request, Object object, Errors errors) throws Exception {
        if(null!=request.getParameter("add") && 0!=request.getParameter("add").length()) {
            request.setAttribute("add",true);
        }
        if(null!=request.getParameter("error") && 0!=request.getParameter("error").length()) {
            request.setAttribute("error",true);
        }
        return super.referenceData(request, object, errors);
    }
    
    public boolean supports(Class clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

}
