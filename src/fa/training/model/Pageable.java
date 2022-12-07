package fa.training.model;

public class Pageable {
	
	private int page;
	private int pageSize = 4;
	
	public int getOffset() {
		return (page - 1) * pageSize;
	}
	
	public Pageable() {
		super();
	}


	public Pageable(int page) {
		super();
		this.page = page;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
