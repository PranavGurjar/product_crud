package product_crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import product_crud.dao.ProductDao;
import product_crud.entity.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//show add products
	@RequestMapping("/add_product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	//handle_product
	@RequestMapping(value="/handle_product", method = RequestMethod.POST)
	public RedirectView handle_product(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		this.productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
}
