package fa.training.dao;

import java.util.List;

import fa.training.entities.Service;
import fa.training.model.Pageable;

public interface ServiceDAO extends CommonDAO<Service>{

	List<Service> findAllWithPageable(Pageable pageable);

	long getTotalAll();

	List<Service> findWithSearchAndPageable(String search, Pageable pageable);

	long getTotalWithSearch(String search);

	Service findById(String serviceId);

	boolean deleteById(String serviceId);

	List<Service> findAll();

}
