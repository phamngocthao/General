package fa.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.common.PageRouterType;
import fa.training.common.PageRouters;
import fa.training.constant.MappingConstant;
import fa.training.constant.MessageConstant;
import fa.training.entities.Customer;
import fa.training.entities.CustomerModel;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.CustomerService;
import fa.training.validator.CustomerValidator;

@Controller
@RequestMapping(value = MappingConstant.CUSTOMER)
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerValidator customerValidator;

	@GetMapping(value = MappingConstant.ADD_CUSTOMER)
	public String getAddCustomerPage(Model model) {
		
		Customer customer = new Customer();
		
		customer.isEdit = false;
		
		model.addAttribute("customer",customer);
		
		return PageRouters.routerPage(model, PageRouterType.ADD_CUSTOMER_PAGE);
	}
	
	@PostMapping(value = MappingConstant.ADD_CUSTOMER)
	public String addCustomer(@Valid @ModelAttribute(name = "customer") Customer customer,
			BindingResult result,RedirectAttributes redirectAttribute,Model model) {
		
		customerValidator.validate(customer, result);
		
		if(result.hasErrors()) {
			
			return PageRouters.routerPage(model, PageRouterType.ADD_CUSTOMER_PAGE);
		};
		
		if(customer != null) {
			
			customerService.insert(customer);
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS,MessageConstant.SUCCESS);
		}
		
		return "redirect:" + MappingConstant.LIST_CUSTOMER;
	}
	
	@GetMapping(value = MappingConstant.EDIT_CUSTOMER + "/{id}")
	public String getEditCustomerPage(@PathVariable(name = "id") String customerId,Model model) {
		
		Customer customer = customerService.findById(customerId);
		
		customer.isEdit = true;
		
		model.addAttribute("customer",customer);
		
		return PageRouters.routerPage(model, PageRouterType.ADD_CUSTOMER_PAGE);
	}
	
	@PostMapping(value = MappingConstant.DELETE_CUSTOMER + "/{id}")
	public String deleteCustomer(@PathVariable(name = "id") String customerId
			,RedirectAttributes redirectAttribute,Model model) {
		
		Customer customerIsExists = customerService.findById(customerId);
		
		if(customerIsExists != null) {
			
			customerService.deleteById(customerId);
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		return "redirect:/" + MappingConstant.CUSTOMER + MappingConstant.LIST_CUSTOMER;
	}
	
	@GetMapping(value = MappingConstant.LIST_CUSTOMER)
	public String getListCustomerPage(
			@RequestParam(name = "page",defaultValue = "1") int page, 
			@RequestParam(name = "search", defaultValue = "") String search,
			Model model) {

		Pageable pageable = new Pageable(page);
		
		Pagination<List<Customer>> customerPagination = customerService.findAllWithSearch(search,page,pageable);
		
		model.addAttribute("pagination",customerPagination);
		
		return PageRouters.routerPage(model, PageRouterType.LIST_CUSTOMER_PAGE);
	}
	
	@GetMapping(value = MappingConstant.PROFILE_CUSTOMER)
	public String getAddPageCustomer(
			@RequestParam(name = "page", defaultValue = "1") int page,
			Model model) {
		
//		List<CustomerModel> customers = customerService.findAllProfileCustomer();
		
		Pageable pageable = new Pageable(page);

		Pagination<List<CustomerModel>> customerPagination = customerService.findAllProfileCustomer(page,pageable);
		
		
		model.addAttribute("pagination",customerPagination);
		
		return PageRouters.routerPage(model, PageRouterType.PROFILE_CUSTOMER_PAGE);
	}
	
}
