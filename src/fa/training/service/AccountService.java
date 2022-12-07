package fa.training.service;

import fa.training.entities.Account;

public interface AccountService extends CommonService<Account>{

	Account findByUsername(String username);

}
