package registrationandlogin;
import java.sql.*;
public class UserLogin {
	
	 public static boolean loginUser(String username, String password) {
	        String query = "SELECT password FROM users WHERE username = ?";

	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setString(1, username);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                String storedPassword = resultSet.getString("password");
	                return PasswordHashing.checkPassword(password, storedPassword);
	            } else {
	                return false;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	 public static String getUserRole(String username) {
	        String query = "SELECT role FROM users WHERE username = ?";

	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setString(1, username);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                return resultSet.getString("role");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null; 
	    }
}
