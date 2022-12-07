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

@Entity
@Table(name = "computer")
public class Computer {
	
	@Id
	@Column(name = "id")
	@NotBlank(message = "Mã máy không được để trống")
	@Pattern(regexp = "M[0-9]{3}", message = "Mã máy không đúng định dạng")
	private String computerId;
	
	@Column(name = "location")
	@NotBlank(message = "Vị trí máy không được để trống")
	private String location;
	
	@Column(name = "status")
	private int status;
	
	@OneToMany(mappedBy = "computer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<UseComputer> useComputers;
	
	public static boolean isEdit = false;

	public Computer() {
		super();
	}

	public Computer(String computerId,String location, int status) {
		super();
		this.computerId = computerId;
		this.location = location;
		this.status = status;
	}

	public String getComputerId() {
		return computerId;
	}

	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<UseComputer> getUseComputers() {
		return useComputers;
	}

	public void setUseComputers(List<UseComputer> useComputers) {
		this.useComputers = useComputers;
	}

	@Override
	public String toString() {
		return "Computer [computerId=" + computerId + ", location=" + location + ", status=" + status + "]";
	}

	public static boolean isEdit() {
		return isEdit;
	}

	public static void setEdit(boolean isEdit) {
		Computer.isEdit = isEdit;
	}
	
	
	
	
	
}
