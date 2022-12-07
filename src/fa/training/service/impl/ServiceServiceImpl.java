package fa.training.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fa.training.dao.ServiceDAO;
import fa.training.entities.Service;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl extends CommonServiceImpl<Service> implements ServiceService{

	@Autowired
	ServiceDAO serviceDao;
	
	
	@Override
	@Transactional
	public Pagination<List<Service>> findWithSearchAndPageable(String search, int page, Pageable pageable) {
		
		List<Service> services = null;
		
		Pagination<List<Service>> pagination = new Pagination<>();
		
		long totalPage = serviceDao.getTotalWithSearch(search);
		
		if(search.equals("")) {
			
			services = serviceDao.findAllWithPageable(pageable);			
		}
		else {
			
			services = serviceDao.findWithSearchAndPageable(search,pageable);
		}
		
		
		pagination.setObject(services);
		pagination.setTotalPage((int) Math.ceil((double)totalPage / pageable.getPageSize()));
		pagination.setIndex(page);
		pagination.setSearch(search);
		
		return pagination;
	}


	@Override
	@Transactional
	public Service findById(String serviceId) {
		
		Service service = serviceDao.findById(serviceId);
		
		return service;
	}


	@Override
	@Transactional
	public boolean deleteById(String serviceId) {
		
		
		return serviceDao.deleteById(serviceId);
	}


	@Override
	@Transactional
	public List<Service> findAll() {
		
		List<Service> services = serviceDao.findAll();
		
		return services;
	}

}
