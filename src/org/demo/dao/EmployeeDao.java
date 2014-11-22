package org.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.demo.web.model.Employee;
 
public class EmployeeDao extends HibernateDaoSupport{
 
	public void insert(Employee employee){
		getHibernateTemplate().save(employee);
	}
	 
	public List<Employee> selectAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		return getHibernateTemplate().findByCriteria(criteria);
	}
 
}