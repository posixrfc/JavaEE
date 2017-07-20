package cn.itcast.javaee.springmvc.app02;

import org.apache.commons.dbutils.QueryRunner;

/**
 * Ա������ģ��
 * �־ò�
 * @author AdminTC
 */
public class EmpDao {
	/**
	 * ����Ա��
	 */
	public void add(Emp emp) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "INSERT INTO EMPS(ID,USERNAME,SALARY) VALUES(?,?,?)";
		Object[] params = {emp.getId(),emp.getUsername(),emp.getSalary()};
		runner.update(sql,params);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ���� 
	 */
	public static void main(String[] args) throws Exception{
		EmpDao dao = new EmpDao();
		dao.add(new Emp("����",5000D));
	}
}








