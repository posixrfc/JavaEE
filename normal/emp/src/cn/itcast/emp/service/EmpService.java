package cn.itcast.emp.service;

import cn.itcast.emp.dao.EmpDao;
import cn.itcast.emp.entity.Emp;

/**
 * Ա������ģ��
 * ҵ���ʵ����
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	/**
	 * ����Ա��
	 */
	public void register(Emp emp) throws Exception{
		empDao.add(emp);
	}
}








