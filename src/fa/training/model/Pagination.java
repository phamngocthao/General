package fa.training.model;

import java.util.List;

public class Pagination<T> {

	private T object;
	private int totalPage;
	private int index;
	private long totalElements;
	private String search;

	
	public Pagination() {
		super();
	}


	public Pagination(T object, int elementsCurrentPage, int totalPage, int index, long totalElements) {
		super();
		this.object = object;
		this.totalPage = totalPage;
		this.index = index;
		this.totalElements = totalElements;
	}


	public T getObject() {
		return object;
	}


	public void setObject(T object) {
		this.object = object;
	}

	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public long getTotalElements() {
		return totalElements;
	}


	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	@Override
	public String toString() {
		return "Pagination [object=" + object + ", totalPage="
				+ totalPage + ", index=" + index + ", totalElements=" + totalElements + "]";
	}
	
	
	
	
	
	
}
