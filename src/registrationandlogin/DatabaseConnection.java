package registrationandlogin;
import java.sql.*;

public class DatabaseConnection {
	private static final  String URL = "jdbc:mysql://localhost:3306/home_delivery_management_system";
	private static final String USER = "root";
	private static final String PASSWORD = "20044@";
	public static Connection getConnection()throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
