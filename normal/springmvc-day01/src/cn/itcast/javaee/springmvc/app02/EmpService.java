package cn.itcast.javaee.springmvc.app02;

/**
 * 员工管理模块
 * 业务层
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {//springioc自动注入
		this.empDao = empDao;
	}
	/**
	 * 增加员工
	 */
	public void addEmp(Emp emp) throws Exception{
		if(emp == null){
			throw new RuntimeException("EmpService参数不能为空");
		}
		empDao.add(emp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}








