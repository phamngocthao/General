package fa.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fa.training.entities.Account;
import fa.training.service.AccountService;

@Component
public class AccountValidator implements Validator{

	@Autowired
	AccountService accountService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Account.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Account account = (Account) target;
		
		Account accountCheck = accountService.findByUsername(account.getUsername());
		
		if(account.getUsername().isBlank()) {
			
			errors.rejectValue("username","", "Username không được để trống");
		}
		else if(account.isLogin()){
			
			if(accountCheck == null) {
				
				errors.rejectValue("username", "", "Tài khoản không tồn tại");
			}	
		}
		
		if(account.getPassword().isBlank()) {
			
			errors.rejectValue("password", "", "Mật khẩu không được để trống");
		}
		else if(account.isLogin()){
			if(!accountCheck.getPassword().equals(account.getPassword())){
				
				errors.rejectValue("password", "", "Mật khẩu không đúng");
			}
		}
		
		if(!account.isLogin()) {
			
			if(account.getConfirmPassword().isBlank()) {
				errors.rejectValue("confirmPassword","", "Xác nhận mật khẩu không để trống");
			}
			else {
				
				if(!account.getConfirmPassword().equals(account.getPassword())) {
					
					errors.rejectValue("confirmPassword","", "Xác nhận mật khẩu không đúng");
				}
			}
		}
		
		
	}

}
