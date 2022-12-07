package fa.training.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;
import fa.training.entities.CustomerModel;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.CustomerService;

@Service
public class CustomerServiceImpl extends CommonServiceImpl<Customer> implements CustomerService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CustomerDAO customerDao;
	
	
	@Override
	@Transactional
	public Pagination<List<Customer>> findAllWithSearch(String search, int page, Pageable pageable) {
		
		List<Customer> customers = null;
		
		Pagination<List<Customer>> pagination = new Pagination<>();
		
		long totalPage = customerDao.getTotalWithSearch(search);
		
		if(search.equals("")) {
			
			customers = customerDao.findAllWithPageable(pageable);			
		}
		else {
			
			customers = customerDao.findWithSearchAndPageable(search,pageable);
		}
		
		pagination.setObject(customers);
		pagination.setSearch(search);
		pagination.setTotalPage((int) Math.ceil((double) totalPage / pageable.getPageSize()));
		pagination.setIndex(page);
		
		return pagination;
	}


	@Override
	@Transactional
	public Customer findById(String customerId) {
		
		Customer customer = customerDao.findById(customerId);
		
		return customer;
	}


	@Override
	@Transactional
	public boolean deleteById(String customerId) {		
		
		return customerDao.deleteById(customerId);
	}


	@Override
	@Transactional
	public List<Customer> findCustomerIsNotUseComputer() {
		
		List<Customer> customers = customerDao.findCustomerIsNotUseComputer();
		
		return customers;
	}


	@Override
	@Transactional
	public List<Customer> findAll() {
		
		List<Customer> customes = customerDao.findAll();
		
		return customes;
	}


	@Override
	@Transactional
	public List<Customer> findCustomerIsUsingAndStillTime() {
		
		List<Customer> customers = customerDao.findCustomerIsUsingAndStillTimeWithNavtiveSQL();
		
		return customers;
	}


	@Override
	@Transactional
	public Pagination<List<CustomerModel>> findAllProfileCustomer(int page, Pageable pageable) {
		
		Pagination<List<CustomerModel>> pagination = new Pagination<List<CustomerModel>>();
		
		List<CustomerModel> customers = customerDao.findAllProfileCustomerWithPageable(page, pageable);
		
		long totalPage = customerDao.getTotalProfileCustomer();
		
		pagination.setObject(customers);
		pagination.setTotalPage((int) Math.ceil((double) totalPage / pageable.getPageSize()));
		pagination.setIndex(page);
		
		return pagination;
	}

}
