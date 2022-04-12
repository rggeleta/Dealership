package dealership.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.ToString;
import lombok.Data;

/**
 * @author William Thomas, wdthomas2
 * CIS175 - Spring 2022
 * Apr 11, 2022
 */

//Utilizing Lombok annotations, the class can be fully defined as below.
//Lombok @Data annotation will automatically generate constructors and getters/setters


@Entity
@Data
@ToString
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String make;
	private String model;
	private String color;
	private float price;
	private boolean sold;
}
