package lab.spring.io.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return "Welcome home";
	}
}
