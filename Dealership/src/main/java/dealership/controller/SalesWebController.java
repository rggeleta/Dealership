package dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dealership.beans.SalesPerson;
import dealership.repository.SalesPersonRepository;


@Controller
public class SalesWebController {
	

	
	@Autowired
	//Injecting the salesPerson repository
	private SalesPersonRepository repo;
	
		
		//Method Handller to display all list of sales
		//for the home page (sales.html)
	
		@GetMapping("/")
		public String viewSalesHomePage(Model model) {
			
			//Add data to the model
			model.addAttribute("listOfSales",repo.getAllSales());
			return "salesView";
			
		}
	public List<SalesPerson> getAllSales() {
		//return null;
		return repo.findAll();
	}


}
