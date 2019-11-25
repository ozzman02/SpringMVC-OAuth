package lab.spring.io.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@ComponentScan("lab.spring.io.security.core")
@EnableWebSecurity
@Import(DbConfig.class)
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","/login").permitAll()
			.antMatchers("/index.jsp").hasRole("USER")
			.antMatchers("/*").denyAll()
			.and()
			.oauth2Login()
				.loginPage("/login")
					.userInfoEndpoint()
						.userService(this.oauth2UserService())
						.oidcUserService(this.oidcUserService());
	}



	
	@Bean
	Map<String,String> oauth2AuthenticationUris(){
		
		String authorizationRequestBaseUri = "oauth2/authorization";
		
		Map<String,String> oauth2AuthenticationUris = new HashMap<>();
		oauth2AuthenticationUris.put("Login via Google", authorizationRequestBaseUri + "/google");
		oauth2AuthenticationUris.put("Login via GitHub", authorizationRequestBaseUri + "/github");
		
		return oauth2AuthenticationUris;
	}
	
	private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService(){
		
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService(); 
		return (OAuth2UserRequest userRequest) ->{
			OAuth2User auth2User = delegate.loadUser(userRequest);
			
			return auth2User;
		};
	}
		
	private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService(){
		
		OAuth2UserService<OidcUserRequest, OidcUser> delegate = new OidcUserService(); 
		return (OidcUserRequest userRequest) ->{
			OidcUser oidcUser = delegate.loadUser(userRequest);
			
			return oidcUser;
		};
	}

}
