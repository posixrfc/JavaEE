package cn.itcast.javaee.springmvc.app02;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Ա������ģ��
 * ������
 * @author AdminTC
 */
public class EmpAction extends ActionSupport{
	private EmpService empService;//ҵ���
	public void setEmpService(EmpService empService) {//springioc�Զ�ע��ʵ����
		this.empService = empService;
	}
	private Emp emp;//ģ��
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	/**
	 * ע��Ա��
	 */
	public String registerMethod() throws Exception{
		empService.addEmp(emp);
		return "success";
	}

}





