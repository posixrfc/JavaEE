package junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.crud.component.service.CRUDService;
import com.atguigu.crud.entity.Department;
import com.atguigu.crud.entity.Employee;

public class CRUDServiceTest {
	
	private CRUDService crudService;
	
	public CRUDServiceTest() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		crudService = ioc.getBean(CRUDService.class);
	}

	@Test
	public void testGetEmpList() {
		List<Employee> empList = crudService.getEmpList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}

	@Test
	public void testGetDeptList() {
		List<Department> deptList = crudService.getDeptList();
		for (Department department : deptList) {
			System.out.println(department);
		}
	}

	@Test
	public void testSaveEmp() {
		Employee employee = new Employee(null, "empNew02");
		
		Department department = new Department(3, null);
		
		employee.setDepartment(department);
		
		crudService.saveEmp(employee);
	}

	@Test
	public void testRemoveEmp() {
		crudService.removeEmp(11);
	}

	@Test
	public void testGetEmp() {
		Employee employee = crudService.getEmp(7);
		System.out.println(employee);
	}

	@Test
	public void testUpdateEmp() {
		Employee employee = new Employee(7, "empHappy");
		
		Department department = new Department(3, null);
		
		employee.setDepartment(department);
		
		crudService.updateEmp(employee);
	}

}
