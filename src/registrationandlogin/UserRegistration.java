package registrationandlogin;
import java.sql.*;

public class UserRegistration {

	public static boolean registerUser(String username, String password, String role) {
		String hashedPassword = PasswordHashing.hashPassword(password);
	    String checkUserQuery = "SELECT * FROM users WHERE username = ?";
	    String insertUserQuery = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement checkStatement = connection.prepareStatement(checkUserQuery);
	         PreparedStatement insertStatement = connection.prepareStatement(insertUserQuery)) {

	        checkStatement.setString(1, username);
	        ResultSet resultSet = checkStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            return false;
	        }
	        insertStatement.setString(1, username);
	        insertStatement.setString(2, hashedPassword); 
	        insertStatement.setString(3, role);

	        int result = insertStatement.executeUpdate();
	        return result > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; 
	    }
	}


}
