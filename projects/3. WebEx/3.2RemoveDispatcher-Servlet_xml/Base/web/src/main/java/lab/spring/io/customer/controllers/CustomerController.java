package lab.spring.io.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.io.core.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return "Welcome home";
	}
	
	@RequestMapping("/welcome/{userId}")
	public ModelAndView welcome(@PathVariable("userId")Integer id) {
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("name", customerService.findNameById(id));
		return model;
	}
}
