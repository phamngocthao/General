package fa.training.entities;

import java.util.Date;

public class CustomerModel {

	private String customerId;
	private String customerName;
	private String locationComputer;
	private int statusComputer;
	private Date dateStartUseComputer;
	private String timeStartUseComputer;
	private String timeUseComputer;
	private String serviceId;
	private Date dateUseService;
	private String timeUseService;
	private int quantity;
	private double totalMoney;
	
	
	public CustomerModel() {
		super();
	}


	public CustomerModel(String customerId, String customerName, String locationComputer, int statusComputer,
			Date dateStartUseComputer, String timeStartUseComputer, String timeUseComputer, String serviceId,
			Date dateUseService, String timeUseService, int quantity, double totalMoney) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.locationComputer = locationComputer;
		this.statusComputer = statusComputer;
		this.dateStartUseComputer = dateStartUseComputer;
		this.timeStartUseComputer = timeStartUseComputer;
		this.timeUseComputer = timeUseComputer;
		this.serviceId = serviceId;
		this.dateUseService = dateUseService;
		this.timeUseService = timeUseService;
		this.quantity = quantity;
		this.totalMoney = totalMoney;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getLocationComputer() {
		return locationComputer;
	}


	public void setLocationComputer(String locationComputer) {
		this.locationComputer = locationComputer;
	}


	public int getStatusComputer() {
		return statusComputer;
	}


	public void setStatusComputer(int statusComputer) {
		this.statusComputer = statusComputer;
	}


	public Date getDateStartUseComputer() {
		return dateStartUseComputer;
	}


	public void setDateStartUseComputer(Date dateStartUseComputer) {
		this.dateStartUseComputer = dateStartUseComputer;
	}


	public String getTimeStartUseComputer() {
		return timeStartUseComputer;
	}


	public void setTimeStartUseComputer(String timeStartUseComputer) {
		this.timeStartUseComputer = timeStartUseComputer;
	}


	public String getTimeUseComputer() {
		return timeUseComputer;
	}


	public void setTimeUseComputer(String timeUseComputer) {
		this.timeUseComputer = timeUseComputer;
	}


	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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


	public double getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}


	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", customerName=" + customerName + ", locationComputer="
				+ locationComputer + ", statusComputer=" + statusComputer + ", dateStartUseComputer="
				+ dateStartUseComputer + ", timeStartUseComputer=" + timeStartUseComputer + ", timeUseComputer="
				+ timeUseComputer + ", serviceId=" + serviceId + ", dateUseService=" + dateUseService
				+ ", timeUseService=" + timeUseService + ", quantity=" + quantity + ", totalMoney=" + totalMoney + "]";
	}
	
	
	
}
