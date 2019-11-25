package lab.spring.io.security.web.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	Map<String, String> oauth2AuthenticationUris;
	
	@GetMapping(value = {"/", "/login"})
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		
		if(isAnonymous()) {
			model.addObject("uriMap", oauth2AuthenticationUris);
			model.setViewName("login");
		}else {
			model.addObject("userName", this.getUserName());
			model.addObject("email", this.getEmail());
			model.setViewName("index");
		}
		return model;
	}
	
	private boolean isAnonymous() {
		return SecurityContextHolder.getContext().getAuthentication()
									.getAuthorities()
									.stream()
									.anyMatch(grantedAuthority->grantedAuthority.getAuthority().trim().equalsIgnoreCase("ROLE_ANONYMOUS"));
									
	}
	
	private String getUserName() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
	}
	
	private String getEmail() {
		return this.getUserName()+ "@inam.online";
	}
}
