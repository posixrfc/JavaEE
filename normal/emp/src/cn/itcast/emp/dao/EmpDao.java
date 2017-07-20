package cn.itcast.emp.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import org.apache.commons.dbutils.QueryRunner;
import cn.itcast.emp.entity.Emp;
import cn.itcast.emp.util.JdbcUtil;

/**
 * Ա������ģ��
 * �־ò�ʵ����
 * @author AdminTC
 */
public class EmpDao {
	/**
	 * ����Ա��
	 */
	public void add(Emp emp) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into emps(id,username,salary,hiredate) values(?,?,?,?)";
		Object[] params = {emp.getId(),emp.getUsername(),emp.getSalary(),emp.getHiredate()};
		runner.update(sql,params);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		
		Emp emp = new Emp();
		emp.setId("a140a519-6168-4a97-a753-5c5e5cf0a8b2");
		emp.setUsername("����");
		emp.setSalary(7000D);
		
		
		String year = "15";
		String month = "5��";
		String date = "10";
		String str = date+"-"+month+"-"+year;
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		
		emp.setHiredate(df.parse(str));
		
		EmpDao dao = new EmpDao();
		dao.add(emp);
		
	}
}








