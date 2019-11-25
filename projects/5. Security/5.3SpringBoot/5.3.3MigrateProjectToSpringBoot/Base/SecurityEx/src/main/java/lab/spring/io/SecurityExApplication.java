package lab.spring.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SecurityExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExApplication.class, args);
	}
	

	@GetMapping("/")
	public String helloSpringBoot() {
		return "login";
	}

}
