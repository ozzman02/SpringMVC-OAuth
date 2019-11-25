package lab.spring.io.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","/login").permitAll()
			.antMatchers("/index.jsp").hasRole("USER")
			.antMatchers("/*").denyAll()
			.and()
			.formLogin()
				.loginPage("/login");
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserBuilder bcryptUsers = User.builder().passwordEncoder(p -> "{bcrypt}" + p);
		
		UserDetails inam = bcryptUsers.username("INAM").password("$2a$10$z59TK3XhcZOcyeevNbCrxusYtR6Vi4KvrRCZGAjZdyQX.8GE95NU6").roles("USER","HR").build();
		UserDetails david = bcryptUsers.username("DAVID").password("$2a$10$z59TK3XhcZOcyeevNbCrxusYtR6Vi4KvrRCZGAjZdyQX.8GE95NU6").roles("USER","ADMIN").build();
	
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(inam);
		manager.createUser(david);
		
		return manager;
	}
	

}
