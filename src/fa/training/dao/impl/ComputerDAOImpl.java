package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.ComputerDAO;
import fa.training.entities.Computer;
import fa.training.model.Pageable;

@Repository
public class ComputerDAOImpl extends CommonDAOImpl<Computer> implements ComputerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Computer> findAll() {
		
		String hql = "SELECT c FROM Computer c";
				
		Session session = sessionFactory.getCurrentSession();
		
		List<Computer> computers = session.createQuery(hql, Computer.class).getResultList();
		
		return computers;
	}


	@Override
	public Computer findById(String computerId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Computer computer = session.find(Computer.class , computerId);
		
		return computer;
	}


	@Override
	public boolean deleteById(String computerId) {

		String hql = "DELETE FROM Computer c WHERE c.computerId = :computerId";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Computer> query = session.createQuery(hql);
		query.setParameter("computerId", computerId);
		
		int rowEffect = query.executeUpdate();
		
		return rowEffect > 0;
	}


	@Override
	public List<Computer> findWithSearchAndPageable(String search, Pageable pageable) {
		
		String hql = "SELECT c FROM Computer c WHERE c.location LIKE :search "
				+ "OR c.computerId LIKE :search";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Computer> query = session.createQuery(hql, Computer.class);
		query.setParameter("search", "%"+search+"%");
		
		List<Computer> computers = query.
				setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
		
		
		return computers;
	}


	@Override
	public long getTotalAll() {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("SELECT COUNT(*) FROM Computer c", Long.class).getSingleResult();
	}


	@Override
	public long getTotalPageWithSearch(String search) {
		
		String hql = "SELECT COUNT(*) FROM Computer c WHERE c.location LIKE :search";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Long> query =  session.createQuery(hql,Long.class);
		query.setParameter("search", "%"+search+"%");
		
		return query.getSingleResult();
	}


	@Override
	public List<Computer> findAllWithPageable(Pageable pageable) {
		
		String hql = "SELECT c FROM Computer c";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Computer> query = session.createQuery(hql, Computer.class);
		
		List<Computer> computers = query.
				setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
		
		
		return computers;
	}


	@Override
	public List<Computer> findAllComputerNotBusy() {
		
		String hql = "SELECT c FROM Computer c WHERE c.status = 0";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Computer> query = session.createQuery(hql, Computer.class);
		
		return query.getResultList();
	}

}
