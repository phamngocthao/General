package fa.training.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parent;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "id")
	@NotBlank(message = "Mã khách hàng không được để trống")
	@Pattern(regexp = "KH[0-9]{5}", message = "Mã khách hàng không đúng định dạng")
	private String customerId;
	
	@Column(name = "name")
	@NotBlank(message = "Tên khách hàng không được để trống")
	private String name;
	
	@Column(name = "address")
	@NotNull(message = "Địa chỉ không được để trống")
	private String address;
	
	@Column(name = "phone")
	@NotBlank(message = "Số điện thoại không được để trông")
	@Pattern(regexp = "(((090)|(091)|[(][8][4][)][+][9][0])|[(][8][4][)][+][9][1])[0-9]{7}", message = "Số điện thoại không đúng định dạng")
	private String phone;
	
	@Column(name = "email")
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không đúng định dạng")
	private String email;

	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private Set<UseService> useServices;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private Set<UseComputer> useComputers;
	
	public static boolean isEdit = false;
	
	public Customer() {
		super();
	}

	public Customer(String customerId,String name, String address, String phone, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UseService> getUseServices() {
		return useServices;
	}

	public void setUseServices(Set<UseService> useServices) {
		this.useServices = useServices;
	}

	public Set<UseComputer> getUseComputers() {
		return useComputers;
	}

	public void setUseComputers(Set<UseComputer> useComputers) {
		this.useComputers = useComputers;
	}

	public static boolean isEdit() {
		return isEdit;
	}

	public static void setEdit(boolean isEdit) {
		Customer.isEdit = isEdit;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", useServices=" + useServices.toString() + ", useComputers=" + useComputers.toString() + "]";
	}

//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", phone=" + phone
//				+ ", email=" + email + "]";
//	}
//
//	
//	
	
	
}
