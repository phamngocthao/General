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
@Table(name = "use_computer")
public class UseComputer implements Serializable{

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
	@JoinColumn(name = "computer_id",referencedColumnName = "id")
	private Computer computer;
	
	@Id
	@Column(name = "date_start_use_computer")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateStartUse;
	
	@Id
	@Column(name = "time_start_use_computer")
	private String timeStartUse;
	
	@Column(name = "time_use")
	private String timeUse;

	public UseComputer() {
		super();
	}

	public UseComputer(Customer customer, Computer computer, Date dateStartUse, String timeStartUse, String timeUse) {
		super();
		this.customer = customer;
		this.computer = computer;
		this.dateStartUse = dateStartUse;
		this.timeStartUse = timeStartUse;
		this.timeUse = timeUse;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Date getDateStartUse() {
		return dateStartUse;
	}

	public void setDateStartUse(Date dateStartUse) {
		this.dateStartUse = dateStartUse;
	}

	public String getTimeStartUse() {
		return timeStartUse;
	}

	public void setTimeStartUse(String timeStartUse) {
		this.timeStartUse = timeStartUse;
	}

	public String getTimeUse() {
		return timeUse;
	}

	public void setTimeUse(String timeUse) {
		this.timeUse = timeUse;
	}

	@Override
	public String toString() {
		return "UseComputer [customer=" + customer.getCustomerId() + ", computer=" + computer.getComputerId() + ", dateStartUse=" + dateStartUse
				+ ", timeStartUse=" + timeStartUse + ", timeUse=" + timeUse + "]";
	}
	 
	
}
