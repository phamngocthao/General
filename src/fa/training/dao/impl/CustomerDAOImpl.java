package fa.training.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;
import fa.training.entities.CustomerModel;
import fa.training.model.Pageable;

@Repository
public class CustomerDAOImpl extends CommonDAOImpl<Customer> implements CustomerDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> findAllWithPageable(Pageable pageable) {
		
		String hql = "SELECT c FROM Customer c";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery(hql, Customer.class)
				.setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize());
				
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public long getTotalAll() {
		
		String hql = "SELECT COUNT(*) FROM Customer c";
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery(hql, Long.class).getSingleResult();
	}

	@Override
	public List<Customer> findWithSearchAndPageable(String search, Pageable pageable) {
		
		String hql = "SELECT c FROM Customer c WHERE c.customerId LIKE :search "
					+ "OR c.name LIKE :search OR c.address LIKE :search OR c.phone LIKE :search "
					+ "OR c.email LIKE :search";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery(hql, Customer.class)
				.setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize());
		query.setParameter("search", "%"+search+"%");
		
		List<Customer> customers = query.getResultList();
	
		return customers;
	}

	@Override
	public long getTotalWithSearch(String search) {
		
		String hql = "SELECT COUNT(*) FROM Customer c WHERE c.customerId LIKE :search "
					+ "OR c.name LIKE :search OR c.address LIKE :search OR c.phone LIKE :search "
					+ "OR c.email LIKE :search";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Long> query = session.createQuery(hql, Long.class);
		query.setParameter("search", "%"+search+"%");
		
		return query.getSingleResult();
	}

	@Override
	public Customer findById(String customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		 
		Customer customer = session.find(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public boolean deleteById(String customerId) {
		
		String hql = "DELETE FROM Customer c WHERE c.customerId = :customerId";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery(hql);
		query.setParameter("customerId", customerId);
		
		int rowEffect = query.executeUpdate();
		
		return rowEffect > 0;
		
	}

	@Override
	public List<Customer> findCustomerIsNotUseComputer() {
		
		
		
		return null;
	}

	@Override
	public List<Customer> findAll() {
		
		String hql = "SELECT c FROM Customer c";
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery(hql, Customer.class);
		
		return query.getResultList();
	}

	@Override
	public List<Customer> findCustomerIsUsingAndStillTimeWithNavtiveSQL() {
		
		
		String sql = "select c.* from use_computer u JOIN customer c ON u.customer_id = c.id WHERE DAY(u.date_start_use_computer) = DAY(GETDATE()) \r\n"
				+ "AND CONVERT(VARCHAR(8), GETDATE(), 108) <= DATEADD(MINUTE, u.time_use/1, CAST(u.time_start_use_computer as time(0)))";
		
		
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.addEntity(Customer.class);
		
		return sqlQuery.list();
		

	}

	@Override
	public List<CustomerModel> findAllProfileCustomerWithPageable(int page, Pageable pageable) {

		List<CustomerModel> customers = new ArrayList<CustomerModel>();
		
//		String sql = "SELECT c.id as cuId,c.name,com.location,com.status,uc.date_start_use_computer,uc.time_start_use_computer,uc.time_use, "
//				+ "s.id as sId,us.date_use_service,us.time_use_service,us.quantity,ttuv.sumttuv "
//				+ "FROM customer c JOIN use_computer uc ON c.id = uc.customer_id "
//				+ "JOIN use_service us ON us.customer_id = c.id JOIN service s ON s.id = us.service_id JOIN computer com ON com.id = uc.computer_id "
//				+ "JOIN "
//				+ "( "
//				+ "SELECT cm.id,SUM(uv.quantity*sv.price) as sumttuv FROM customer cm JOIN use_service uv ON cm.id = uv.customer_id "
//				+ "JOIN service sv ON sv.id = uv.service_id GROUP BY cm.id "
//				+ ") as ttuv ON ttuv.id = c.id";
		String sql = "SELECT c.id as cuId,c.name,'abc',1,'abc','abc','abc','dv' as sId,'date','ti',ttuv.sfn,ttuv.sumttuv FROM customer c "
				+ " JOIN "
				+ "( "
				+ "SELECT cm.id as fff,SUM(uv.quantity*sv.price) as sumttuv,SUM(uv.quantity) as sfn FROM customer cm JOIN use_service uv ON cm.id = uv.customer_id"
				+ " JOIN service sv ON sv.id = uv.service_id GROUP BY cm.id "
				+ ") as ttuv ON ttuv.fff = c.id";
		
		Session session = sessionFactory.getCurrentSession();
		
		NativeQuery<Object[]> sqlQuery = session.createNativeQuery(sql)
				.setFirstResult(pageable.getOffset()).setMaxResults(pageable.getPageSize());
		 
		List<Object[]> lists = sqlQuery.getResultList();
		
		lists.forEach(object -> {
			
			CustomerModel customerModel = new CustomerModel();
			 	
			customerModel.setCustomerId((String) object[0]);
			customerModel.setCustomerName((String) object[1]);
			customerModel.setLocationComputer((String) object[2]);
			customerModel.setStatusComputer((int) object[3]);
			customerModel.setDateStartUseComputer((Date) object[4]);
			customerModel.setTimeStartUseComputer((String) object[5]);
			customerModel.setTimeUseComputer((String) object[6]);
			customerModel.setServiceId((String) object[7]);
			customerModel.setDateUseService((Date) object[8]);
			customerModel.setTimeUseService((String) object[9]);
			customerModel.setQuantity((int) object[10]);
			customerModel.setTotalMoney((double) object[11]);
						
			customers.add(customerModel);
		});
		
		
		return customers;
	}

	@Override
	public long getTotalProfileCustomer() {

		String sql = "SELECT c.id as cuId,c.name,com.location,com.status,uc.date_start_use_computer,uc.time_start_use_computer,uc.time_use, "
				+ "s.id as sId,us.date_use_service,us.time_use_service,us.quantity,ttuv.sumttuv "
				+ "FROM customer c JOIN use_computer uc ON c.id = uc.customer_id "
				+ "JOIN use_service us ON us.customer_id = c.id JOIN service s ON s.id = us.service_id JOIN computer com ON com.id = uc.computer_id "
				+ "JOIN "
				+ "( "
				+ "SELECT cm.id,SUM(uv.quantity*sv.price) as sumttuv FROM customer cm JOIN use_service uv ON cm.id = uv.customer_id "
				+ "JOIN service sv ON sv.id = uv.service_id GROUP BY cm.id "
				+ ") as ttuv ON ttuv.id = c.id";
		
		Session session = sessionFactory.getCurrentSession();
		
		NativeQuery<Object[]> sqlQuery = session.createNativeQuery(sql);
				
		 
		List<Object[]> lists = sqlQuery.getResultList();
		
		return (long) lists.size();
	}

}
