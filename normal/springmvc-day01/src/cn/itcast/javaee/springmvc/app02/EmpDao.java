package cn.itcast.javaee.springmvc.app02;

import org.apache.commons.dbutils.QueryRunner;

/**
 * 员工管理模块
 * 持久层
 * @author AdminTC
 */
public class EmpDao {
	/**
	 * 增加员工
	 */
	public void add(Emp emp) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "INSERT INTO EMPS(ID,USERNAME,SALARY) VALUES(?,?,?)";
		Object[] params = {emp.getId(),emp.getUsername(),emp.getSalary()};
		runner.update(sql,params);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 测试 
	 */
	public static void main(String[] args) throws Exception{
		EmpDao dao = new EmpDao();
		dao.add(new Emp("测试",5000D));
	}
}








