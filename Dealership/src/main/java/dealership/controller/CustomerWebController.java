package dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dealership.repository.CustomerRepository;
import dealership.repository.VehicleRepository;
import dealership.beans.Customer;
import dealership.beans.Vehicle;

@Controller
public class CustomerWebController {
	@Autowired
	CustomerRepository repo;
	@Autowired
	VehicleRepository repo_vehicle;
	
	@GetMapping("/viewCustomers")
	public String viewAllCustomers(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customer", repo.findAll());
		return "customerResults";
	}
	
	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "customerInput";
	}
	
	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id")long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllCustomers(model);
	}
	
	//Selling vehicles
	@GetMapping("/sell/{id}")
	public String sellVehicle(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		List<Vehicle> v = repo_vehicle.findAll();
		model.addAttribute("customer", c);
		model.addAttribute("vehicles", v);
		return "customerSelect";
	}
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}
}
