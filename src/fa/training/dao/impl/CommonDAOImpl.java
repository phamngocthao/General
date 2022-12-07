package fa.training.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.CommonDAO;

@Repository("commonDao")
public class CommonDAOImpl<E> implements CommonDAO<E>{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean save(E entity) {
	
		try {
			
			Session session = sessionFactory.getCurrentSession();
			
			session.saveOrUpdate(entity);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(E entity) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.update(entity);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
