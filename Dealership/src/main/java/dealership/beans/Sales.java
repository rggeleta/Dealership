/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Apr 28, 2022
 */
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


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="Sales")
public class Sales {
	@Id
	@Column(name = "ID")
	private long id;
	@Column(name = "First Name", nullable = false)  //required
	private String firstName;
	
	@Column(name = "Last Name", nullable = false)   // required
	private String lastName;
	
	@Column(name = "Vehicle Name")   //if we don't provide column name jpa will provide as the field name name
	private String  vehicleName;
	
	public Optional<Sales> findByVehicleName(String string) {
		return null;
	}

}
