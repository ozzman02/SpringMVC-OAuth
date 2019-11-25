package lab.spring.io.security.core.model;

import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class OAuth2UserInfo extends DefaultOAuth2User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OAuth2UserInfo(Set<GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey) {
		super(authorities, attributes, nameAttributeKey);
	}
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
