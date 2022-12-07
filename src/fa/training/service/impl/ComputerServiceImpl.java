package fa.training.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.ComputerDAO;
import fa.training.entities.Computer;
import fa.training.model.Pageable;
import fa.training.model.Pagination;
import fa.training.service.ComputerService;

@Service
public class ComputerServiceImpl extends CommonServiceImpl<Computer> implements ComputerService{

	@Autowired
	ComputerDAO computerDao;
	
	@Override
	@Transactional
	public List<Computer> findAll() {
		
		List<Computer> computers = computerDao.findAll();
		
		return computers;
	}

	@Override
	@Transactional
	public Computer findById(String computerId) {
		
		Computer computer = computerDao.findById(computerId);
		
		return computer;
	}

	@Override
	@Transactional
	public boolean deleteById(String computerId) { 
		
		return computerDao.deleteById(computerId);
		
	}

	@Override
	@Transactional
	public Pagination<List<Computer>> findAllWithSearch(String search,int index, Pageable pageable) {
		
		List<Computer> computers = null;
		
		Pagination<List<Computer>> pagination = new Pagination<>();
		
		long totalPage = computerDao.getTotalPageWithSearch(search);
		
		if(search.equals("")) {
			
			computers = computerDao.findAllWithPageable(pageable);
		}
		else {
			
			computers = computerDao.findWithSearchAndPageable(search,pageable);
		}
		
		pagination.setObject(computers);
		pagination.setSearch(search);
		pagination.setTotalPage((int) Math.ceil((double) totalPage / pageable.getPageSize()));
		pagination.setIndex(index);
		
		return pagination;
	}

	@Override
	@Transactional
	public List<Computer> findAllComputerNotBusy() {
		
		List<Computer> computers = computerDao.findAllComputerNotBusy();
		
		return computers;
	}

}
