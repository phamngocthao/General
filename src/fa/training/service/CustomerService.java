package fa.training.service;

import java.util.List;

import fa.training.entities.Customer;
import fa.training.entities.CustomerModel;
import fa.training.model.Pageable;
import fa.training.model.Pagination;

public interface CustomerService extends CommonService<Customer>{

	Pagination<List<Customer>> findAllWithSearch(String search, int page, Pageable pageable);

	Customer findById(String customerId);

	boolean deleteById(String customerId);

	List<Customer> findCustomerIsNotUseComputer();

	List<Customer> findAll();

	List<Customer> findCustomerIsUsingAndStillTime();

	Pagination<List<CustomerModel>> findAllProfileCustomer(int page, Pageable pageable);

}
