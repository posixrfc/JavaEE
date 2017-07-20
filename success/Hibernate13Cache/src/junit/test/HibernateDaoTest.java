package junit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atguigu.mapping.dao.HibernateDao;

public class HibernateDaoTest {
	
	public static void main(String[] args) {
		HibernateDao hibernateDao = new HibernateDao();
		hibernateDao.save();
		hibernateDao.update();
		
		System.out.println();
		
//		SessionFactory factory = HibernateDao.getFactory();
//		Session session = factory.openSession();
//		hibernateDao.save(session);
//		hibernateDao.update(session);
		
		hibernateDao.threadSave();
		hibernateDao.threadUpdate();
	}

}
