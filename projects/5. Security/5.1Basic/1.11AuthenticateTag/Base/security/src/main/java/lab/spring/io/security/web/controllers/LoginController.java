package lab.spring.io.security.web.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(value = {"/", "/login"})
	public String login() {
		if(isAnonymous()) {
			return "login";
		}else {
			return "index";
		}
	}
	
	private boolean isAnonymous() {
		return SecurityContextHolder.getContext().getAuthentication()
									.getAuthorities()
									.stream()
									.anyMatch(grantedAuthority->grantedAuthority.getAuthority().trim().equalsIgnoreCase("ROLE_ANONYMOUS"));
									
	}
}
