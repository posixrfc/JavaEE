package com.atguigu.crud.component.service;

import java.util.List;

import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;

public interface CRUDService {
	
	/**
	 * 获取员工列表
	 * @return
	 */
	List<Employee> getEmpList();
	
	/**
	 * 获取部门列表
	 * @return
	 */
	List<Department> getDeptList();
	
	/**
	 * 保存员工对象
	 * @param employee
	 */
	void saveEmp(Employee employee);
	
	/**
	 * 根据OID删除员工
	 * @param empId
	 */
	void removeEmp(Integer empId);
	
	/**
	 * 根据OID获取员工对象，用于表单回显
	 * @param empId
	 * @return
	 */
	Employee getEmp(Integer empId);
	
	/**
	 * 更新员工信息
	 * @param employee
	 */
	void updateEmp(Employee employee);

}
