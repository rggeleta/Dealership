package dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dealership.beans.Vehicle;
import dealership.repository.VehicleRepository;

/**
 * @author William Thomas, wdthomas2
 * CIS175 - Spring 2022
 * Apr 12, 2022
 */
@Controller
public class VehicleWebController {
	@Autowired
	VehicleRepository repo;
	
	@GetMapping("/viewVehicles")
	public String viewAllVehicles(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewVehicle(model);
		}
		model.addAttribute("vehicles", repo.findAll());
		return "vehicleResults";
	}
	
	@GetMapping("/addVehicle")
	public String addNewVehicle(Model model) {
		Vehicle v = new Vehicle();
		model.addAttribute("newVehicle", v);
		return "vehicleInput";
	}
	
	@PostMapping("/addVehicle")
	public String addNewVehicle(@ModelAttribute Vehicle v, Model model) {
		repo.save(v);
		return viewAllVehicles(model);
	}
	
	@GetMapping("/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable("id") long id, Model model) {
		Vehicle v = repo.findById(id).orElse(null);
		repo.delete(v);
		return viewAllVehicles(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateVehicle(@PathVariable("id") long id, Model model) {
		Vehicle v = repo.findById(id).orElse(null);
		model.addAttribute("newVehicle", v);
		return "vehicleInput";
	}
	
	@PostMapping("/update/{id}")
	public String reviseVehicle(Vehicle v, Model model) {
		repo.save(v);
		return viewAllVehicles(model);
	}
	
	//Queries by details
	@GetMapping("/makeSearch")
	public String byMakeSearch(String make, Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewVehicle(model);
		}
		Vehicle v = new Vehicle();
		model.addAttribute("makeObject", v);
		return "makeSearch";
	}
	
	@PostMapping("/byMake")
	public String byMake(@ModelAttribute Vehicle v, Model model) {
			model.addAttribute("vehicles", repo.findAllByMakeIgnoreCase(v.getMake()));
			return "vehicleResults";
	}
		
}
