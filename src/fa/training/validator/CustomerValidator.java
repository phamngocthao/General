package fa.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fa.training.entities.Customer;
import fa.training.service.CustomerService;
import fa.training.utils.ValidateUtil;

@Component
public class CustomerValidator implements Validator{

	@Autowired
	CustomerService customerService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Customer customer = (Customer) target;
		
//		if(ValidateUtil.checkIsEmptyOrNull(customer.getCustomerId())) {
//			errors.rejectValue("customerId","", "Mã khách hàng không được để trống");
//		}
//		else{
//			if(!ValidateUtil.isCustomerId(customer.getCustomerId())) {				
//				errors.rejectValue("customerId","", "Mã khách hàng không đúng định dạng");
//			}
//		}
//		
		if(!customer.isEdit) {
			Customer customerIsExist = customerService.findById(customer.getCustomerId());
			
			if(customerIsExist != null) {
				errors.rejectValue("customerId","", "Mã khách hàng đã tồn tại");
			}
		}
		
//		if(ValidateUtil.checkIsEmptyOrNull(customer.getName())) {
//			errors.rejectValue("name","", "Tên khách hàng không được để trống");
//		}
//		
//		if(ValidateUtil.checkIsEmptyOrNull(customer.getPhone())) {
//			errors.rejectValue("phone","", "Số điện thoại không được để trống");
//		}
//		
//		if(ValidateUtil.checkIsEmptyOrNull(customer.getEmail())) {
//			errors.rejectValue("email","", "Email không được để trống");
//		}
//		
//		if(ValidateUtil.checkIsEmptyOrNull(customer.getAddress())) {
//			errors.rejectValue("address","", "Địa chỉ không được để trống");
//		}
//		
		
	}

	
}
