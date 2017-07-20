package com.atguigu.crud.component.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;

@Repository
public class CRUDDaoImpl implements CRUDDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Employee> getEmpList() {
		
		String hql = "From Employee";// e LEFT JOIN FETCH e.department
		
		Session session = factory.getCurrentSession();
		
		List<Employee> list = session.createQuery(hql).list();
		
		return list;
	}

	@Override
	public List<Department> getDeptList() {
		
		String hql = "From Department";
		
		Session session = factory.getCurrentSession();
		
		List<Department> list = session.createQuery(hql).setCacheable(true).list();
		
		return list;
	}

	@Override
	public void saveEmp(Employee employee) {
		factory.getCurrentSession().save(employee);
	}

	@Override
	public void removeEmp(Integer empId) {
		factory.getCurrentSession().delete(new Employee(empId, null));
	}

	@Override
	public Employee getEmp(Integer empId) {
		return (Employee) factory.getCurrentSession().get(Employee.class, empId);
	}

	@Override
	public void updateEmp(Employee employee) {
		factory.getCurrentSession().update(employee);
	}

}
