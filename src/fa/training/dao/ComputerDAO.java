package fa.training.dao;

import java.util.List;

import fa.training.entities.Computer;
import fa.training.model.Pageable;

public interface ComputerDAO extends CommonDAO<Computer>{

	List<Computer> findAll();

	Computer findById(String computerId);

	boolean deleteById(String computerId);

	List<Computer> findWithSearchAndPageable(String search, Pageable pageable);

	long getTotalAll();

	long getTotalPageWithSearch(String search);

	List<Computer> findAllWithPageable(Pageable pageable);

	List<Computer> findAllComputerNotBusy();

}
