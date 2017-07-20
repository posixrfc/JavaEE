package com.atguigu.springmvc.crud.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	/*跳转进到员工信息录入页面 */
	@RequestMapping(value="/emp",method=RequestMethod.GET)	
	public String input(Map<String,Object> map){
		//1	查询出全部部门
		map.put("departments",departmentDao.getDepartments());
		//2 查询出性别
		map.put("genders",getGendersUtil());
		//3 新建承载form表单的bean
		map.put("employee",new Employee());
		return "input";
	}
	/* 真正的实现保存进入数据库 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)	
	public String save(@Valid Employee employee,BindingResult bindingResult,Map<String,Object> map){
		if(bindingResult.getErrorCount()>0){
			List<FieldError> list = bindingResult.getFieldErrors();
			for (FieldError fieldError : list)
				System.out.println(fieldError.getField()+"\t"+fieldError.getDefaultMessage());
			  //出错后跳转回录入页面
			  map.put("departments",departmentDao.getDepartments());
			  map.put("genders",getGendersUtil());
			  return "input";
		}
		System.out.println("save employee---->"+employee.toString());
		employeeDao.save(employee);
		return "redirect:/emps";
	}	
	
	/*删除员工信息*/
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)	
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}	
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,Map<String,Object> map){
		//1	查询出全部部门
		map.put("departments",departmentDao.getDepartments());
		//2 查询出性别
		map.put("genders",getGendersUtil());
		//3 带着对应id的employee
		map.put("employee",employeeDao.get(id));
		return "edit";
	}
	@ModelAttribute
	public void getEmployeeById(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(null != id)
			map.put("employee",employeeDao.get(id));
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String list(Map<String,Object> map){
		System.out.println("emps biz method==================");
		map.put("employees",employeeDao.getAll());
		return "list";
	}
	
	public Map<String,String> getGendersUtil(){
		Map<String,String> genders = new HashMap<String,String>();
		genders.put("1","male");
		genders.put("0","female");
		return genders;
	}
	
	@RequestMapping(value="/empConvert",method=RequestMethod.POST)	
	public String empConvert(@RequestParam("employee") Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("email");
	}*/
}