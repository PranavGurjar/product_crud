package product_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/add_product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
}
