package fa.training.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomHadlerException {

	@ExceptionHandler(value = {NoHandlerFoundException.class})
	public String noHandlerFound(HttpServletRequest httpServletRequest, HttpServletResponse response, Exception exception) {
		
		response.setStatus(HttpStatus.NOT_FOUND.value());
		 
		return "error/page-404";
	}
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public String serverError(HttpServletRequest httpServletRequest, HttpServletResponse response, Exception exception) {
		
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return "error/page-500";
	}
	
	
	
}
