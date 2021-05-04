package learning.spring.springdata.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateDaoImpl {

	@Autowired
	SessionFactory sessionFactory;
	
	public int getCircleCount() {
		String hql = "Select count(*) from Triangle";
		Query query = sessionFactory.openSession().createQuery(hql);
		System.out.println("count result = "+query.uniqueResult());
		return  ((Long)query.uniqueResult()).intValue();
		
	}
}
