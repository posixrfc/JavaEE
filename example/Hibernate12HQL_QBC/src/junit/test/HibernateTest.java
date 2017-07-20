package junit.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mapping.bean.Department;
import com.atguigu.mapping.bean.Employee;

public class HibernateTest {
	
	@Test
	public void testNativeSQL() {
		//实验9 本地SQL
		//1.增删改
//		String sqlUpdate = "UPDATE emps SET SALARY=? WHERE emps.`EMP_ID`=?";
//		session.createSQLQuery(sqlUpdate).setDouble(0, 15000).setInteger(1, 114).executeUpdate();
		
		//2.查询
		String sqlQuery = "select emp_name,salary from emps where salary>?";
		List<Object[]> list = session.createSQLQuery(sqlQuery).setInteger(0, 8000).list();
		for (Object[] objects : list) {
			System.out.println(objects[0]+" "+objects[1]);
		}
	}
	
	@Test
	public void testQBC08() {
		//实验8 测试分页执行
		int pageNo = 2;
		int pageSize = 5;
		
		List<Employee> list = session.createCriteria(Employee.class)
									 .setFirstResult((pageNo - 1)*pageSize)
									 .setMaxResults(pageSize)
									 .list();
		
		for (Employee employee : list) {
			System.out.println(employee.getSalary()+"\t"+employee.getEmpName());
		}
	}
	
	@Test
	public void testQBC07() {
		//实验7 将Employee的查询结果使用salary的升序和empName的降序排列
		//1.创建封装排序信息的Order对象
		Order asc = Order.asc("salary");
		Order desc = Order.desc("empName");
		
		//2.创建Criteria对象并添加Order对象
		List<Employee> list = session.createCriteria(Employee.class)
									 .addOrder(asc)
									 .addOrder(desc)
									 .list();
		for (Employee employee : list) {
			System.out.println(employee.getSalary()+"\t"+employee.getEmpName());
		}
	}
	
	@Test
	public void testQBC06() {
		//实验6 测试报表查询：最高工资和最低工资
		//1.创建max()和min()聚合函数对应的对象
		AggregateProjection max = Projections.max("salary");
		AggregateProjection min = Projections.min("salary");
		
		//2.创建ProjectionList对象，用于包含多个Projection对象
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(max).add(min);
		
		//3.将聚合函数对象添加到Criteria对象中
		List<Object[]> list = session.createCriteria(Employee.class)
				   .setProjection(projectionList)
				   .list();
		for (Object[] objects : list) {
			System.out.println("最高工资："+objects[0]+" 最低工资："+objects[1]);
		}
		
		//一个Criteria对象中，只能设置一个Projection对象，如果设置多个则只有最后一个有效
		/*List list = session.createCriteria(Employee.class)
						   .setProjection(max)
						   .setProjection(min)
						   .list();
		for (Object object : list) {
			System.out.println(object);
		}*/
	}
	
	@Test
	public void testQBC05() {
		//实验5 同时使用AND和OR
		//(条件1 AND 条件2) OR (条件3 AND 条件4)
		//1.准备4个查询条件
		SimpleExpression condition01 = Restrictions.like("empName", "A%");
		SimpleExpression condition02 = Restrictions.gt("salary", 8000.00);
		SimpleExpression condition03 = Restrictions.like("empName", "B%");
		SimpleExpression condition04 = Restrictions.gt("salary", 5000.00);
		
		//2.将4个查询条件分别用两个and连接起来
		Conjunction and01 = Restrictions.conjunction();
		and01.add(condition01).add(condition02);
		
		Conjunction and02 = Restrictions.conjunction();
		and02.add(condition03).add(condition04);
		
		//3.将2个and用or连接起来
		Disjunction or = Restrictions.disjunction();
		or.add(and01).add(and02);
		
		//4.创建Criteria对象
		List<Employee> list = session.createCriteria(Employee.class).add(or).list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void testQBC04() {
		//实验4 将empName like A%和empName like B%用OR连接
		SimpleExpression like = Restrictions.like("empName", "%a%");
		SimpleExpression gt = Restrictions.gt("salary", 9000.00);
		
		//创建封装OR连接条件的对象
		Disjunction disjunction = Restrictions.disjunction();
		
		disjunction.add(like).add(gt);
		
		List<Employee> list = session.createCriteria(Employee.class).add(disjunction).list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary()+"\t"+employee.getTelephone());
		}
	}
	
	@Test
	public void testQBC03() {
		//实验3 将empName like %a%和salary > 9000用AND连接
		//1.封装查询条件
		SimpleExpression like = Restrictions.like("empName", "%a%");
		SimpleExpression gt = Restrictions.gt("salary", 9000.00);
		
		//2.创建AND条件对象
		Conjunction conjunction = Restrictions.conjunction();
		
		//3.使用AND将查询条件组装到一起
		conjunction.add(like).add(gt);
		
		//4.将组装好的AND添加到Criteria对象中
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(conjunction);
		
		//5.执行查询
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary()+"\t"+employee.getTelephone());
		}
	}
	
	@Test
	public void testQBC02() {
		//实验2 在实验1的基础上附加如下查询条件：empName like %a% 且 salary > 9000
		Criteria criteria = session.createCriteria(Employee.class);
		
		//1.将empName like %a%封装成查询条件对象
		Criterion like = Restrictions.like("empName", "%a%");
		
		//2.salary > 9000封装成查询条件对象
		Criterion gt = Restrictions.gt("salary", 9000.00);//如果是Double类型则需要明确
		
		//3.将查询条件添加到Criteria对象中
		criteria.add(like).add(gt);
		
		//4.执行查询
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary()+"\t"+employee.getTelephone());
		}
	}
	
	@Test
	public void testQBC01() {
		//实验1 测试不带任何查询条件的QBC查询：查询全部Employee
		//1.创建Criteria对象
		Criteria criteria = session.createCriteria(Employee.class);
		
		//2.通过Criteria对象查询对应的结果
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary()+"\t"+employee.getTelephone());
		}
		
	}
	
	@Test
	public void testSubSelect02() {
		//查询部门名以“A”开头的部门的员工姓名和部门名称
		String hql = "select e.empName,e.department.deptName "
				+ "from Employee e "
				+ "where e.department in "
				+ "(From Department d where d.deptName like 'A%')";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			System.out.println("empName="+objects[0]+"\tdeptName="+objects[1]);
		}
		/*
		注意别名的引用层次：里面的能用外面的，外面的不能用里面的
		String hql = "select e.empName,d.deptName "
				+ "from Employee e "
				+ "where e.department in "
				+ "(From Department d where d.deptName like 'A%')";*/
		ProjectionList add = Projections.projectionList().add(Projections.max("xxx")).add(Projections.min("xxx"));
		session.createCriteria(Employee.class).setProjection(add);
		
	}
	
	@Test
	public void testSubSelect01() {
		//查询员工数量大于5的部门
		String hql = "From Department d where (select count(emp) From d.empSet emp)>4";
		List<Department> list = session.createQuery(hql).list();
		for (Department department : list) {
			System.out.println(department.getDeptName());
		}
	}
	
	@Test
	public void test16() {
		//实验16 使用HQL执行更新
		String hql = "update Employee e set e.salary=10000 where e.empId=116";
		session.createQuery(hql).executeUpdate();
	}
	
	@Test
	public void test15() {
		//实验15 使用HQL执行删除
		String hql = "delete from Employee e where e.empId=117";
		session.createQuery(hql).executeUpdate();
	}
	
	@Test
	public void test14() {
		//实验14 使用内连接重复实验11
		String hql = "From Department d inner join d.empSet";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	@Test
	public void test13() {
		//实验13 使用迫切内连接重复实验11
		String hql = "From Department d inner join fetch d.empSet";
		List<Department> list = session.createQuery(hql).list();
		for (Department department : list) {
			Set<Employee> empSet = department.getEmpSet();
			for (Employee employee : empSet) {
				System.out.print("id="+department.getDeptId()+"\tdeptName="+department.getDeptName()+"\t");
				System.out.println(employee.getEmpName());
			}
		}
	}
	
	@Test
	public void test12() {
		//实验12 使用左外连接重复实验11
		//如果没有使用FETCH关键字，则会带来一个问题：第一次发送的左外连接的SQL语句明明已经将Employee的数据查询出来，
		//却没有给Department对象的集合属性设置进去，在用到集合属性的数据时还需要另外发送SQL语句查询，非常浪费。
		String hql = "From Department d left join d.empSet";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	@Test
	public void test11() {
		//实验11 使用迫切左外连接将Department表和Employee表连接起来，并去除重复数据
		//“迫切”：在通过左外连接查询得到Employee的数据后，立即注入到Department对象的集合属性中。
		/*String hql = "From Department d left join fetch d.empSet";
		List<Department> list = session.createQuery(hql).list();
		for (Department department : list) {
			Set<Employee> empSet = department.getEmpSet();
			for (Employee employee : empSet) {
				System.out.print("id="+department.getDeptId()+"\tdeptName="+department.getDeptName()+"\t");
				System.out.println(employee.getEmpName());
			}
		}*/
		String hql = "select distinct d From Department d left join fetch d.empSet";
		List<Department> list = session.createQuery(hql).list();
		for (Department department : list) {
			System.out.println("id="+department.getDeptId()+"\tdeptName="+department.getDeptName());
		}
	}
	
	@Test
	public void test10() {
		//实验10 报表查询：查询各个部门的最高工资和最低工资，要求查询最低工资大于3000的数据
		String hql = "select min(e.salary),max(e.salary) "
				+ "From Employee e "
				+ "Group by e.department "
				+ "having min(e.salary)>3000";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			System.out.println(objects[0]+"\t"+objects[1]);
		}
	}
	
	@Test
	public void test09() {
		//实验9 投影查询：使用专用构造器创建的对象接收查询结果
		String hql = "select new Employee(e.empName,e.salary) From Employee e where e.salary>8000";
		List<Employee> list = session.createQuery(hql).list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary()+"\t"+employee.getTelephone());
		}
	}
	
	@Test
	public void test08() {
		//实验8 投影查询：使用Object数组类型接收查询结果
		String hql = "select e.empName,e.salary From Employee e where e.salary>8000";
		List list = session.createQuery(hql).list();
		for (Object object : list) {
			//查询结果中的每一条记录都被封装为了一个Object类型的数组
			System.out.println(object);
		}
		
		System.out.println();
		
		for (Object object : list) {
			Object [] objArr = (Object[]) object;
			System.out.println("empName="+objArr[0]+" salay="+objArr[1]);
		}
	}
	
	@Test
	public void test07() {
		//实验7 命名查询：在hbm文件中使用配置的方式指定查询语句。
		//通过hbm文件中的配置信息创建Query对象
		Query query = session.getNamedQuery("myHQLQuery");
		
		Object result = query.setString("nameParam", "Violet").uniqueResult();
		System.out.println(result);
	}
	
	@Test
	public void test06() {
		//实验6 分页查询
		String hql = "From Employee";
		Query query = session.createQuery(hql);
		
		int pageNo = 2;
		int pageSize = 5;
		
		//1.设定从查询结果中的什么位置开始获取数据
		//LIMIT (pageNo - 1) * pageSize,pageSize
		int firstResult = (pageNo - 1) * pageSize;
		query.setFirstResult(firstResult);
		
		//2.设定从起始位置开始获取数据的数量
		query.setMaxResults(pageSize);
		
		//3.执行list()方法
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void test05() {
		//实验5 ORDER BY 子句
		String hql = "from Employee e Where e.department=? order by e.salary desc";
		Department department = new Department();
		department.setDeptId(15);
		List<Employee> list = session.createQuery(hql).setEntity(0, department).list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void test04() {
		//实验4 以实体类对象作为参数
		//查询部门ID为15的员工信息
		String hql = "from Employee e Where e.department=?";
		Department department = new Department();
		department.setDeptId(15);
		
		//以实体类对象作为参数传入
		List<Employee> list = session.createQuery(hql).setEntity(0, department).list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void test03() {
		//实验3 使用命名参数
		//基于名称的参数使用[:参数名]格式标记
		String hql = "from Employee e where e.salary>:salaryParam";
		
		List<Employee> list = session.createQuery(hql)
									 .setDouble("salaryParam", 7000)
									 .list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void test02() {
		//实验2 使用基于位置的占位符参数
		//1.使用?标记参数的位置
		String hql = "from Employee e where e.salary>?";
		
		//2.创建Query对象
		Query query = session.createQuery(hql);
		
		//3.使用具体的数据填充占位符
		query.setDouble(0, 6000);
		
		//4.执行查询
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	@Test
	public void test01() {
		//实验1 HQL的HelloWorld——查询工资大于5000的Employee
		//SELECT * FROM emps WHERE SALARY>5000
		//1.声明一个HQL查询语句字符串
		//①像select、from、where等关键字不区分大小写，但HQL语句中用到的持久化类的名字以及变量名区分大小写
		//②SELECT子句如果查询全部字段，则可以在HQL语句中省略
		//③From子句后面跟类名
		//④Where子句后面还是查询条件，但参与查询条件的是引用持久化类对象的变量名
		String hql = "from Employee e where e.salary>5000";
		
		//2.通过Session对象创建一个用于执行HQL语句查询的Query对象
		Query query = session.createQuery(hql);
		
		//3.调用Query对象的list()或uniqueResult()方法获取查询结果
		//如果查询结果是多条记录则使用list()
		//如果查询结果是一条记录则使用uniqueResult()
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+"\t"+employee.getSalary());
		}
	}
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		factory.close();
	}

	@Test
	public void createTable() {}

}
