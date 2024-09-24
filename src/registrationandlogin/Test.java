package registrationandlogin;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	 public static void main(String[] args) {

	        // Step 1: Test Database Connection
	        testDatabaseConnection();

	        // Step 2: Test User Registration with different roles
	        //testUserRegistration();

	        // Step 3: Test User Login and Role-based access
	        testUserLogin();

	        // Step 4: Test Password Hashing (using BCrypt)
	        testPasswordHashing();
	    }

	    // Test Database Connection
	    public static void testDatabaseConnection() {
	        try (Connection connection = DatabaseConnection.getConnection()) {
	            if (connection != null) {
	                System.out.println("Database connection successful!");
	            } else {
	                System.out.println("Failed to connect to the database.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Test User Registration
	    public static void testUserRegistration() {
	        // Create a customer, an admin, and a delivery guy
	        boolean isCustomerRegistered = UserRegistration.registerUser("customer1", "cust123", "customer");
	        boolean isAdminRegistered = UserRegistration.registerUser("admin1", "admin123", "admin");
	        boolean isDeliveryGuyRegistered = UserRegistration.registerUser("delivery1", "del123", "delivery_guy");

	        System.out.println("Customer registration successful: " + isCustomerRegistered);
	        System.out.println("Admin registration successful: " + isAdminRegistered);
	        System.out.println("Delivery guy registration successful: " + isDeliveryGuyRegistered);
	    }

	    // Test User Login
	    public static void testUserLogin() {
	        // Test login for each type of user
	        boolean customerLogin = UserLogin.loginUser("customer1", "cust123");
	        boolean adminLogin = UserLogin.loginUser("admin1", "admin123");
	        boolean deliveryGuyLogin = UserLogin.loginUser("delivery1", "del123");

	        System.out.println("Customer login successful: " + customerLogin);
	        System.out.println("Admin login successful: " + adminLogin);
	        System.out.println("Delivery guy login successful: " + deliveryGuyLogin);

	        // Retrieve and print roles
	        System.out.println("Customer role: " + UserLogin.getUserRole("customer1"));
	        System.out.println("Admin role: " + UserLogin.getUserRole("admin1"));
	        System.out.println("Delivery Guy role: " + UserLogin.getUserRole("delivery1"));
	    }

	    // Test Password Hashing
	    public static void testPasswordHashing() {
	        String plainPassword = "mypassword";
	        String hashedPassword = PasswordHashing.hashPassword(plainPassword);

	        System.out.println("Plain Password: " + plainPassword);
	        System.out.println("Hashed Password: " + hashedPassword);

	        // Test Password Verification
	        boolean isPasswordCorrect = PasswordHashing.checkPassword(plainPassword, hashedPassword);
	        System.out.println("Password verification successful: " + isPasswordCorrect);
	    }
}
