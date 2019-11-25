package lab.spring.io.security.core.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

public class OidcUserInfo extends DefaultOidcUser {

	public OidcUserInfo(Set<GrantedAuthority> authorities, OidcIdToken idToken) {
		super(authorities, idToken);
	}
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
