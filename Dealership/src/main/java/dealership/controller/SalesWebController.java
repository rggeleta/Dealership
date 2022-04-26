package dealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dealership.beans.Sales;
import dealership.beans.Vehicle;
import dealership.repository.SalesRepository;


@Controller
public class SalesWebController {
	
	@Autowired
	SalesRepository repo;
	

	@GetMapping("/viewSales")
	public String viewAllSales(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewSales(model);
		}
		model.addAttribute("sales", repo.findAll());
		return "salesResults";
	}
	
	@GetMapping("/inputSales")
	public String addNewSales(Model model) {
		Sales s = new Sales();
		model.addAttribute("newSales", s);
		return "salesInput";
	}
	
	@PostMapping("/inputSales")
	public String addNewCustomer(@ModelAttribute Sales s, Model model) {
		repo.save(s);
		return viewAllSales(model);
	}
	
	@GetMapping("/deleteSales/{id}")
	public String deleteSales(@PathVariable("id")long id, Model model) {
		Sales s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSales(model);
	}
}
