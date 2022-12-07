package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "service")
public class Service {

	@Id
	@Column(name = "id")
	@NotBlank(message = "Mã dịch vụ không được để trống")
	@Pattern(regexp = "DV[0-9]{3}", message = "Mã dịch vụ sai định dạng")
	private String serviceId;
	
	@Column(name = "name")
	@NotBlank(message = "Tên dịch vụ không được để trống")
	private String serviceName;
	
	@Column(name = "service_unit")
	@NotBlank(message = "Đơn vị tính không được để trống")
	private String serviceUnit;
	
	@Column(name = "price")
	@NotNull(message = "Giá không được để trống")
	@Range(min = 1000, message = "Giá phải lớn hơn 1000")
	private double price;
	
	@OneToMany(mappedBy = "service",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<UseService> useComputers;

	public Service() {
		super();
	}

	public Service(String serviceId,String serviceName, String serviceUnit, double price) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceUnit = serviceUnit;
		this.price = price;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUnit() {
		return serviceUnit;
	}

	public void setServiceUnit(String serviceUnit) {
		this.serviceUnit = serviceUnit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<UseService> getUseComputers() {
		return useComputers;
	}

	public void setUseComputers(List<UseService> useComputers) {
		this.useComputers = useComputers;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceUnit=" + serviceUnit
				+ ", price=" + price + "]";
	}
	
	
	
}
