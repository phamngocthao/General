package fa.training.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.AccountDAO;
import fa.training.entities.Account;

@Repository
public class AccountDAOImpl extends CommonDAOImpl<Account> implements AccountDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Account findByUsername(String username) {
		
		try {
			String hql = "SELECT c FROM Account c WHERE c.username = :username";
			
			Session session = sessionFactory.getCurrentSession();
			
			Query<Account> query = session.createQuery(hql);
			query.setParameter("username", username);
			
			Account account = query.getSingleResult();
			
			return account;
		} catch (Exception e) {
			return null;
		}
	}

}
