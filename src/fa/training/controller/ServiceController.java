package fa.training.controller;

import java.util.LinkedHashMap;
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
import fa.training.entities.Service;
import fa.training.entities.UseService;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.CustomerService;
import fa.training.service.ServiceService;
import fa.training.service.UseServiceService;

@Controller
@RequestMapping(value = MappingConstant.SERVICE)
public class ServiceController {
	
	@Autowired
	ServiceService serviceService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UseServiceService useServiceService;


	@GetMapping(value = MappingConstant.ADD_SERVICE)
	public String getAddServicePage(Model model) {
		
		Service service = new Service();
		
		model.addAttribute("service",service);
		
		return PageRouters.routerPage(model, PageRouterType.ADD_SERVICE_PAGE);
	}
	
	@PostMapping(value = MappingConstant.ADD_SERVICE)
	public String addService(@Valid @ModelAttribute(name = "service") Service service
			,BindingResult result, RedirectAttributes redirectAttribute, Model model) {
		
		if(result.hasErrors()) {
			
			return PageRouters.routerPage(model, PageRouterType.ADD_SERVICE_PAGE);
		}
		
		if(service != null) {
			
			serviceService.insert(service);
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		return "redirect:" + MappingConstant.LIST_SERVICE;
	}
	
	@GetMapping(value = MappingConstant.EDIT_SERVICE + "/{id}")
	public String getEditPage(@PathVariable(name = "id") String serviceId,Model model) {
		
		Service service = serviceService.findById(serviceId);
		
		model.addAttribute("service",service);
		
		return PageRouters.routerPage(model, PageRouterType.ADD_SERVICE_PAGE);
	}
	
	@PostMapping(value = MappingConstant.DELETE_SERVICE + "/{id}")
	public String deleteService(@PathVariable(name = "id") String serviceId,
			RedirectAttributes redirectAttribute,Model model) {
		
		Service serviceIsExists = serviceService.findById(serviceId);
		
		if(serviceIsExists != null) {
			
			serviceService.deleteById(serviceId);
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		return "redirect:/" + MappingConstant.SERVICE + MappingConstant.LIST_SERVICE;
	}
	
	
	@GetMapping(value = MappingConstant.LIST_SERVICE)
	public String getListServicePage(
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "search", defaultValue = "") String search,
			Model model) {
		
		Pageable pageable = new Pageable(page);
		
		Pagination<List<Service>> servicePagination = serviceService.findWithSearchAndPageable(search,page,pageable);
		
		model.addAttribute("pagination",servicePagination);
		
		return PageRouters.routerPage(model, PageRouterType.LIST_SERVICE_PAGE);
	}
	
	@GetMapping(value = MappingConstant.USE_SERVICE)
	public String getUseServicePage(Model model) {
		
		UseService useService = new UseService();
		
		model.addAttribute("useService",useService);
		
		return PageRouters.routerPage(model, PageRouterType.USE_SERVICE_PAGE);
	}
	
	@PostMapping(value = MappingConstant.USE_SERVICE)
	public String regisUseService(@Valid @ModelAttribute(name = "useService") UseService useService
			,BindingResult result,RedirectAttributes redirectAttribute,Model model) {
		
		if(result.hasErrors()) {
			return PageRouters.routerPage(model, PageRouterType.USE_SERVICE_PAGE);
		}
		
		if(useService != null) {
			
			useServiceService.insert(useService);
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		return "redirect:/" + MappingConstant.CUSTOMER + MappingConstant.PROFILE_CUSTOMER	;
	}
	
	
	
	@ModelAttribute(name = MappingConstant.LIST_MODEL_CUSTOMER)
	public LinkedHashMap<String, String> listCustomers(){
		
		LinkedHashMap<String, String> customers = new LinkedHashMap<String, String>();
		
		List<Customer> cusList = customerService.findCustomerIsUsingAndStillTime();
		
		if(!cusList.isEmpty()) {
			
			cusList.forEach(cus -> {
				
				customers.put(cus.getCustomerId(), cus.getCustomerId() + "-" + cus.getName());
				
			});
		}	
		return customers;
	}
	
	@ModelAttribute(name = MappingConstant.LIST_MODEL_SERVICE)
	public LinkedHashMap<String, String> listServices(){
		
		LinkedHashMap<String, String> services = new LinkedHashMap<String, String>();
		
		List<Service> serviceList = serviceService.findAll();
		
		if(!serviceList.isEmpty()) {
			
			serviceList.forEach(ser -> {
				
				services.put(ser.getServiceId(), ser.getServiceName());
				
			});
		}	
		return services;
	}
	
	
	@ModelAttribute(name = MappingConstant.LIST_SERVICE_UNIT)
	public LinkedHashMap<String, String> listUnitService(){
		
		LinkedHashMap<String, String> units = new LinkedHashMap<String, String>();
		units.put("Chai", "Chai");
		units.put("Gói", "Gói");
		units.put("Dĩa", "Dĩa");
		units.put("Ly", "Ly");
		
		return units;
		
	}
	
	
}
