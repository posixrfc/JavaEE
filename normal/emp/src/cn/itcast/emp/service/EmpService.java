package cn.itcast.emp.service;

import cn.itcast.emp.dao.EmpDao;
import cn.itcast.emp.entity.Emp;

/**
 * 员工管理模块
 * 业务层实现类
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	/**
	 * 增加员工
	 */
	public void register(Emp emp) throws Exception{
		empDao.add(emp);
	}
}








