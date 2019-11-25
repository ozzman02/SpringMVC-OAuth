package lab.spring.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("lab.spring.io.customer.controllers")
public class CustomerWebContextConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/customer/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
