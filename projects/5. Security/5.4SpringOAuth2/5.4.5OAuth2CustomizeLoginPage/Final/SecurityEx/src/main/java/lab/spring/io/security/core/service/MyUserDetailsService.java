package lab.spring.io.security.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lab.spring.io.security.core.model.User;
import lab.spring.io.security.core.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(authority ->{
			authorities.add(new SimpleGrantedAuthority("ROLE_" + authority));
		});
		
		
		return org.springframework.security.core.userdetails.User.builder().username(user.getUserName()).password(user.getPassword()).authorities(authorities).build();
	}

}
