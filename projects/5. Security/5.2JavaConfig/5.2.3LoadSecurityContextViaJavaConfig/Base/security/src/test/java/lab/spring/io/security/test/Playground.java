package lab.spring.io.security.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Playground {

	private static final Logger logger = LogManager.getLogger(Playground.class);
	
	@Test	
	public void printHashPassword() {
		String plainTextPassword = "123456";
		String hashedPwd = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
		logger.info(hashedPwd);
	}
}
