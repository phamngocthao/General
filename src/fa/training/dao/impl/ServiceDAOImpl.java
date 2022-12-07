package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.ServiceDAO;
import fa.training.entities.Service;
import fa.training.model.Pageable;

@Repository
public class ServiceDAOImpl extends CommonDAOImpl<Service> implements ServiceDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Service> findAllWithPageable(Pageable pageable) {
		
		String hql = "SELECT s FROM Service s";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Service> query = session.createQuery(hql, Service.class)
				.setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize());
		
		List<Service> services = query.getResultList();
		
		return services;
	}

	@Override
	public long getTotalAll() {

		String hql = "SELECT COUNT(*) FROM Service s";
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery(hql, Long.class).getSingleResult();
	}

	@Override
	public List<Service> findWithSearchAndPageable(String search, Pageable pageable) {
		
		String hql = "SELECT s FROM Service s WHERE s.serviceName LIKE :search "
				+ "OR s.serviceUnit LIKE :search OR s.price LIKE :search"; 
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Service> query = session.createQuery(hql, Service.class)
				.setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize());
		query.setParameter("search", "%"+search+"%");
		
		List<Service> services = query.getResultList();
		
		return services;
	}

	@Override
	public long getTotalWithSearch(String search) {
		
		String hql = "SELECT COUNT(*) FROM Service s WHERE s.serviceName LIKE :search "
				+ "OR s.serviceUnit LIKE :search OR s.price LIKE :search"; 
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Long> query = session.createQuery(hql, Long.class);
		query.setParameter("search", "%"+search+"%");
		
		return query.getSingleResult();
	}

	@Override
	public Service findById(String serviceId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Service service = session.find(Service.class, serviceId) ;
		
		return service;
	}

	@Override
	public boolean deleteById(String serviceId) {
		
		String hql = "DELETE FROM Service s WHERE s.serviceId = :serviceId";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Service> query = session.createQuery(hql);
		query.setParameter("serviceId", serviceId);
		
		int rowEffect = query.executeUpdate();
		
		return rowEffect > 0;
	}

	@Override
	public List<Service> findAll() {
		
		String hql = "SELECT s FROM Service s";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Service> query = session.createQuery(hql, Service.class);
		
		return query.getResultList();
	}

}
