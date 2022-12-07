package fa.training.dao;

public interface CommonDAO<E>{

	boolean save(E entity);
	
	boolean update(E entity);
	
}
