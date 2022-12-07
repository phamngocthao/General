package fa.training.service;

import java.util.List;

import fa.training.entities.Computer;
import fa.training.model.Pageable;
import fa.training.model.Pagination;

public interface ComputerService extends CommonService<Computer>{
	
	List<Computer> findAll();

	Computer findById(String computerId);

	boolean deleteById(String computerId);

	Pagination<List<Computer>> findAllWithSearch(String search,int index, Pageable pageable);

	List<Computer> findAllComputerNotBusy();
	
}
