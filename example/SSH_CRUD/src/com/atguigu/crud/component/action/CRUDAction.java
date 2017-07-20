package com.atguigu.crud.component.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.crud.component.service.CRUDService;
import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Controller
@Scope(value="prototype")
public class CRUDAction extends ActionSupport 
						implements RequestAware, ModelDriven<Employee>, Preparable{
	
	private static final long serialVersionUID = 4110643669927790516L;
	@Autowired
	private CRUDService crudService;
	private Map<String, Object> requestMap;
	private Employee employee;
	private Integer empId;
	
	public void prepareUpdateEmp() {
		this.employee = new Employee();
	}
	
	public String updateEmp() {
		crudService.updateEmp(employee);
		return SUCCESS;
	}
	
	public void prepareEditUI() {
		this.employee = crudService.getEmp(empId);
	}
	
	public String editUI() {
		
		//1.获取部门列表
		List<Department> deptList = crudService.getDeptList();
		
		//2.将部门列表保存到请求域中
		requestMap.put("deptList", deptList);
		
		return SUCCESS;
	}
	
	public String removeEmp() {
		
		crudService.removeEmp(empId);
		
		return SUCCESS;
	}
	
	public void prepareSaveEmp() {
		this.employee = new Employee();
	}
	
	public String saveEmp() {
		
		crudService.saveEmp(this.employee);
		
		return SUCCESS;
	}
	
	public String addUI() {
		
		//1.获取部门列表
		List<Department> deptList = crudService.getDeptList();
		
		//2.将部门列表保存到请求域中
		requestMap.put("deptList", deptList);
		
		return SUCCESS;
	}
	
	public String showEmpList() {
		
		//1.获取员工列表
		List<Employee> empList = crudService.getEmpList();
		
		//2.将员工列表数据保存到请求域中
		this.requestMap.put("empList", empList);
		
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public void prepare() throws Exception {}

	@Override
	public Employee getModel() {
		return this.employee;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
}
