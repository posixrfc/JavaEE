package com.atguigu.crud.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crud.component.dao.CRUDDao;
import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;

@Service
public class CRUDServiceImpl implements CRUDService{

	@Autowired
	private CRUDDao crudDao;
	
	@Transactional
	public List<Employee> getEmpList() {
		return crudDao.getEmpList();
	}

	@Transactional
	public List<Department> getDeptList() {
		return crudDao.getDeptList();
	}

	@Transactional
	public void saveEmp(Employee employee) {
		crudDao.saveEmp(employee);
	}

	@Transactional
	public void removeEmp(Integer empId) {
		crudDao.removeEmp(empId);
	}

	@Transactional
	public Employee getEmp(Integer empId) {
		return crudDao.getEmp(empId);
	}

	@Transactional
	public void updateEmp(Employee employee) {
		crudDao.updateEmp(employee);
	}

}
