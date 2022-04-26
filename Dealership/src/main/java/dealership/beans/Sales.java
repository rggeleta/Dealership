package dealership.beans;

import java.util.Optional;

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

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
@Entity
@Table(name ="Sales")
public class Sales {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "First Name", nullable = false)  //required
	private String firstName;
	
	@Column(name = "Last Name", nullable = false)   // required
	private String lastName;
	
	@Column(name = "Vehicle Name")   //if we don't provide column name jpa will provide as the field name name
	private String  vehicleName;
	
	
	/* I commented aut all the getter, setter and conestructions because 
	 * i am using the @NoArgsConstructor and @AllArgsConstructor annotatins
	 * 
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sales(long id, String firstName, String lastName, String vehicleName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleName = vehicleName;
	}
	
	
	
	public Sales(String firstName, String lastName, String vehicleName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleName = vehicleName;
	}
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
	@Override
	public String toString() {
		return "SalesPerson [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", vehicleName="
				+ vehicleName + "]";
	}*/
	public Optional<Sales> findByVehicleName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}