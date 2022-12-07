package fa.training.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.CommonDAO;
import fa.training.service.CommonService;

@Service
public class CommonServiceImpl<E> implements CommonService<E>{

	@Autowired
	CommonDAO<E> commonDao;
	
	@Transactional
	@Override
	public boolean insert(E entity) {
		
		return commonDao.save(entity);
		
	}
	
	@Transactional
	@Override
	public boolean update(E entity) {
		
		return commonDao.update(entity);
	}

}
