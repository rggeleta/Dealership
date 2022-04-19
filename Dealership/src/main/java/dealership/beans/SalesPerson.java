package dealership.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name ="SalesPerson")
public class SalesPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "First Name", nullable = false)  //required
	private String firstName;
	
	@Column(name = "Last Name", nullable = false)   // required
	private String lastName;
	
	@Column(name = "Vehicle Name")   //if we don't provide column name jpa will provide as the field name name
	private String  vehicleName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getVihicleName() {
		return vehicleName;
	}
	public void setVihicleName(String vihicleName) {
		this.vehicleName = vihicleName;
	}
	
}