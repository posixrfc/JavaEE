package cn.itcast.javaee.springmvc.app02;

/**
 * Ա������ģ��
 * ҵ���
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {//springioc�Զ�ע��
		this.empDao = empDao;
	}
	/**
	 * ����Ա��
	 */
	public void addEmp(Emp emp) throws Exception{
		if(emp == null){
			throw new RuntimeException("EmpService��������Ϊ��");
		}
		empDao.add(emp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}








