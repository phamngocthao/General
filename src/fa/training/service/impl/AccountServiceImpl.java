package fa.training.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.AccountDAO;
import fa.training.entities.Account;
import fa.training.service.AccountService;

@Service
public class AccountServiceImpl extends CommonServiceImpl<Account> implements AccountService{

	@Autowired
	AccountDAO accountDao;
	
	@Override
	@Transactional
	public Account findByUsername(String username) {
		
		Account account = accountDao.findByUsername(username);
		
		if(account != null) {
			
			return account;
		}
		
		return null;
	}

}
