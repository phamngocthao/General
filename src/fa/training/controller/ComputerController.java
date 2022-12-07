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
import fa.training.entities.Computer;
import fa.training.entities.Customer;
import fa.training.entities.UseComputer;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.ComputerService;
import fa.training.service.CustomerService;
import fa.training.service.UseComputerService;
import fa.training.validator.ComputerValidator;

@Controller
@RequestMapping(value = MappingConstant.COMPUTER)
public class ComputerController {
	
	@Autowired
	ComputerService computerService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UseComputerService useComputerService;
	
	@Autowired
	ComputerValidator computerValidator;
	
	
	@GetMapping(value = MappingConstant.ADD_COMPUTER)
	public String loadAddComputerPage(Model model) {
		
		Computer computer = new Computer();
		
		System.out.println(computer);
		
		computer.isEdit = false;
		
		model.addAttribute("computer",computer);
		
		
		return PageRouters.routerPage(model,PageRouterType.ADD_COMPUTER_PAGE);
	}
	
	
	@PostMapping(value = MappingConstant.ADD_COMPUTER)
	public String addComputer(RedirectAttributes redirectAttributes ,Model model,
			@Valid @ModelAttribute(name = "computer") Computer computer
			, BindingResult result) {
		
		computerValidator.validate(computer, result);

		if(result.hasErrors()) {
			
			return PageRouters.routerPage(model, PageRouterType.ADD_COMPUTER_PAGE);
		}
		
		if(computer != null) {
			
			computerService.insert(computer);
			
			redirectAttributes.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		return "redirect:" + MappingConstant.LIST_COMPUTER;
	}
	
	@GetMapping(value = MappingConstant.EDIT_COMPUTER+"/{id}")
	public String loadEditComputerPage(@PathVariable(name = "id") String computerId,Model model) {
		
		Computer computer = computerService.findById(computerId);
		
		model.addAttribute("computer",computer);
		
		computer.isEdit = true;
		
		return PageRouters.routerPage(model, PageRouterType.ADD_COMPUTER_PAGE);
	}
	
	
	@PostMapping(value = MappingConstant.DELETE_COMPUTER+"/{id}")
	public String deleteComputer(RedirectAttributes redirectAttributes,@PathVariable(name = "id") String computerId) {
		
		Computer computer = computerService.findById(computerId);
		
		if(computer != null) {
			
			computerService.deleteById(computerId);
			
			redirectAttributes.addFlashAttribute(MessageConstant.SUCCESS,MessageConstant.SUCCESS);
		}
		
		return "redirect:/" + MappingConstant.COMPUTER + MappingConstant.LIST_COMPUTER; 
	}
	
	@GetMapping(value = MappingConstant.LIST_COMPUTER)
	public String loadListComputerPage(
			@RequestParam(name = "search",defaultValue = "") String search,
			@RequestParam(name = "page",defaultValue = "1") int page,
			Model model) {
		
		Pageable pageable = new Pageable(page);
		
		Pagination<List<Computer>> computerPagination = computerService.findAllWithSearch(search,page,pageable);

		model.addAttribute("pagination",computerPagination);
		
		return PageRouters.routerPage(model, PageRouterType.LIST_COMPUTER_PAGE);	
	}
	
	@GetMapping(value = MappingConstant.REGISTER_USE_COMPUTER)
	public String loadRegisterComputerPage(Model model) {
		
		UseComputer useComputer = new UseComputer();
		
		model.addAttribute("useComputer",useComputer);
		
		return PageRouters.routerPage(model, PageRouterType.REGISTER_USE_COMPUTER_PAGE);
	}
	
	@PostMapping(value = MappingConstant.REGISTER_USE_COMPUTER)
	public String registerUseComputer(
			@ModelAttribute(name = "useComputer") UseComputer useComputer,
			RedirectAttributes redirectAttribute
			) {
		
		if(useComputer != null) {
			
			useComputerService.insert(useComputer);
			
			Computer computer = computerService.findById(useComputer.getComputer().getComputerId());
			
			if(computer.getStatus() == 0) {
				
				computer.setStatus(1);
				
				computerService.update(computer);
			}
			
			
			redirectAttribute.addFlashAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		
		return "redirect:/" + MappingConstant.CUSTOMER + MappingConstant.PROFILE_CUSTOMER;
	}
	
	
	
	
	@ModelAttribute(name = MappingConstant.LIST_MODEL_CUSTOMER)
	public LinkedHashMap<String, String> listCustomers(){
		
		LinkedHashMap<String, String> customers = new LinkedHashMap<String, String>();
		
		List<Customer> cusList = customerService.findAll();
		
		if(!cusList.isEmpty()) {
			
			cusList.forEach(cus -> {
				
				customers.put(cus.getCustomerId(), cus.getCustomerId() + "-" + cus.getName());
				
			});
		}	
		return customers;
	}
	
	@ModelAttribute(name = MappingConstant.LIST_MODEL_COMPUTER)
	public LinkedHashMap<String, String> listComputers(){
		
		LinkedHashMap<String, String> computers = new LinkedHashMap<String, String>();
		
		List<Computer> comList = computerService.findAllComputerNotBusy();
		
		if(!comList.isEmpty()) {
			
			comList.forEach(com -> {
				
				computers.put(com.getComputerId(), com.getComputerId() + "-" + com.getLocation());
				
			});
		}
		
		return computers;
	}
}
