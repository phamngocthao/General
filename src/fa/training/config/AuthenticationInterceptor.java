package fa.training.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import fa.training.entities.Account;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account");
		
		if(account == null) {
			
			session.setAttribute("back-url", request.getServletPath()); 
			
			response.sendRedirect("/general/account/login");
			
			return false;
		}
		
		return true;
	}
	
}
