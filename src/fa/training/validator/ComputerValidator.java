package fa.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fa.training.entities.Computer;
import fa.training.service.ComputerService;
import fa.training.utils.ValidateUtil;

@Component
public class ComputerValidator implements Validator{

	@Autowired
	ComputerService computerService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Computer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Computer computer = (Computer) target;
		
		if(computer.isEdit != true) {
			
			Computer computerIsExits = computerService.findById(computer.getComputerId());
			
			if(computerIsExits != null) {
				errors.rejectValue("computerId","", "Mã máy đã tồn tại");
			}
			
		}
		
	}

}
