package com.atguigu.springmvc.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

@Component
public class EmployeeConvert implements Converter<String,Employee>
{
	@Override
	public Employee convert(String source){
		Employee result = null;
		if(null != source){
			String[] empInofs = source.split(";");
			if(null != empInofs && empInofs.length == 4){
				result = new Employee();
				result.setLastName(empInofs[0]);
				result.setEmail(empInofs[1]);
				result.setGender(Integer.parseInt(empInofs[2]));
				Department department = new Department();
				department.setId(Integer.parseInt(empInofs[3]));
				result.setDepartment(department);
			}
		}
		return result;
	}
}