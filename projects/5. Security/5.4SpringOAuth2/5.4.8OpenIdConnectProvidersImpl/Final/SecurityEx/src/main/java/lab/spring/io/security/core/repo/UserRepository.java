package lab.spring.io.security.core.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.io.security.core.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public User findByEmail(String email) {
		
		String sql = "SELECT u.username, u.email, auth.authority"
					+ " FROM users u LEFT JOIN authorities auth"
					+ " ON u.username = auth.username "
					+ " WHERE u.email = ? ";
		
		Connection conn  = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			conn  = dataSource.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			user = this.getUser(resultSet); 
		} catch (SQLException e) {
			throw new RuntimeException("Exception while extracting userInfo from database", e);
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {

				}
			}
			
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {

				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
		
		return user;
		
	}
	
	private User getUser(ResultSet resultSet) throws SQLException {
		User user = null;
		while(resultSet.next()) {
			if(user == null) {
				user = new User();
			}
			
			if(user.getUserName()==null) {
				user.setUserName(resultSet.getString("username"));
			}
			
			if(user.getEmail()==null) {
				user.setEmail(resultSet.getString("email"));
			}
			
			String authority  = resultSet.getString("authority");
			if(authority!=null) {
				if(user.getRoles()==null) {
					user.setRoles(new ArrayList<>());
				}
				user.getRoles().add(authority);
			}
		}
		return user;
	}
}



