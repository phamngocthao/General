package fa.training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "use_service")
public class UseService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id",referencedColumnName = "id")
	private Service service;
	
	@Id
	@Column(name = "date_use_service")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateUseService;
	
	@Id
	@Column(name = "time_use_service")
	private String timeUseService;
	
	@Column(name = "quantity")
	private int quantity;

	public UseService() {
		super();
	}

	public UseService(Customer customer, Service service, Date dateUseService, String timeUseService, int quantity) {
		super();
		this.customer = customer;
		this.service = service;
		this.dateUseService = dateUseService;
		this.timeUseService = timeUseService;
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getDateUseService() {
		return dateUseService;
	}

	public void setDateUseService(Date dateUseService) {
		this.dateUseService = dateUseService;
	}

	public String getTimeUseService() {
		return timeUseService;
	}

	public void setTimeUseService(String timeUseService) {
		this.timeUseService = timeUseService;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UseService [customer=" + customer.getCustomerId() + ", service=" + service.getServiceId() + ", dateUseService=" + dateUseService
				+ ", timeUseService=" + timeUseService + ", quantity=" + quantity + "]";
	}
	
	
}
