package dealership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dealership.beans.Customer;
import dealership.controller.BeanConfig;
import dealership.repository.CustomerRepository;

@SpringBootApplication
public class DealershipApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	}

}

