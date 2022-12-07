package fa.training.dao;

import fa.training.entities.Account;

public interface AccountDAO extends CommonDAO<Account>{

	Account findByUsername(String username);

}
