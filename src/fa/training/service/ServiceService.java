package fa.training.service;

import java.util.List;

import fa.training.entities.Service;
import fa.training.model.Pageable;
import fa.training.model.Pagination;

public interface ServiceService extends CommonService<Service>{

	Pagination<List<Service>> findWithSearchAndPageable(String search, int page, Pageable pageable);

	Service findById(String serviceId);

	boolean deleteById(String serviceId);

	List<Service> findAll();

}
