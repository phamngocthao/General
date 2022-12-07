package fa.training.service;

import fa.training.entities.Computer;

public interface CommonService<E>{

	boolean insert(E entity);
	
	boolean update(E entity);
	
}
