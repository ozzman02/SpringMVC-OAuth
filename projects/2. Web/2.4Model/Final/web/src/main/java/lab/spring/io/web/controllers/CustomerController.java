package lab.spring.io.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return "Welcome home";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("name","INAM");
		return model;
	}
}
