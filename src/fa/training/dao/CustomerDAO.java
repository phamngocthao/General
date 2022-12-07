package fa.training.dao;

import java.util.List;

import fa.training.entities.Customer;
import fa.training.entities.CustomerModel;
import fa.training.model.Pageable;

public interface CustomerDAO extends CommonDAO<Customer>{

	List<Customer> findAllWithPageable(Pageable pageable);

	long getTotalAll();

	List<Customer> findWithSearchAndPageable(String search, Pageable pageable);

	long getTotalWithSearch(String search);

	Customer findById(String customerId);

	boolean deleteById(String customerId);

	List<Customer> findCustomerIsNotUseComputer();

	List<Customer> findAll();

	List<Customer> findCustomerIsUsingAndStillTimeWithNavtiveSQL();

	List<CustomerModel> findAllProfileCustomerWithPageable(int page, Pageable pageable);

	long getTotalProfileCustomer();

}
