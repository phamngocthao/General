package fa.training.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.entities.Account;
import fa.training.service.AccountService;
import fa.training.validator.AccountValidator;

@Controller
@RequestMapping("/account/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountValidator accountValidator;
	
	@Autowired
	HttpSession session;
	
	@GetMapping(value = "login")
	public String getLoginPage(Model model) {
		
		Account account = new Account();
		
		model.addAttribute("account",account);
		
		return "login/login";
	}
	
	@PostMapping(value = "login")
	public String login(@Valid @ModelAttribute(name = "account") Account account, BindingResult result, Model model) {
		
		account.setLogin(true);
		
		accountValidator.validate(account, result);
		
		if(result.hasErrors()) {
			
			return "login/login";
		}
		
		session.setAttribute("account", account);
		
		String back_url = (String) session.getAttribute("back-url");
		
		if(back_url != null) {
			
			return "redirect:" + back_url;
		}

		return "redirect:/";
	}
	
	
	@GetMapping(value = "register")
	public String getRegisterPage(Model model) {
		
		Account account = new  Account();
		
		model.addAttribute("account",account);
		
		return "login/register";
	}
	
	@PostMapping(value = "register")
	public String register(@Valid @ModelAttribute(name = "account") Account account, BindingResult result) {
		
		account.setLogin(false);
		
		accountValidator.validate(account, result);
		
		if(result.hasErrors()) {
			
			return "login/register";
		}
		
		accountService.insert(account);
		
		return "redirect:login";
	}
	
	@GetMapping(value = "logout")
	public String logout() {
	
		session.removeAttribute("account");
		
		return "redirect:/";
	}
}
