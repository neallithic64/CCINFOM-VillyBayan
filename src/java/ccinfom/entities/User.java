package ccinfom.entities;

import java.sql.*;

public class User {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public User(String first, String last, String em, String pass) {
		firstname = first;
		lastname = last;
		email = em;
		password = pass;
	}
	
	public String getFirstN() {
		return firstname;
	}
	public String getLastN() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public void register() {
		try {
			String query = "INSERT INTO accessservicedb.USERS (username, password, completename, currentpoints) VALUES (?,?,?,?)";
			// 1. Connect to the database
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/CCINFOM?useTimezone=true&serverTimezone=UTC&user=admin&password=p@ssword");
			// 2. Prepare the SQL Statement
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, lastname);
			stmt.setString(2, firstname);
			stmt.setString(3, email);
			stmt.setString(4, password);
			// 3. Execute the SQL Statement
			stmt.executeUpdate();
			// 4. Process the results
			
			// 5. Disconnect
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
		}
	}
	
	/** Log in method used for logging in a User. In the context of the application,
	 * this means getting the object's attributes filled out with the fields from
	 * the MySQL database.<br>
	 * Method of authentication is to 
	 */
	public void login() {
		try {
			String query = "SELECT * FROM accessservicedb.USERS;";
			// 1. Connect to the database
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/CCINFOM?useTimezone=true&serverTimezone=UTC&user=admin&password=p@ssword");
			// 2. Prepare the SQL Statement
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// 3. Execute the SQL Statement
			stmt.executeUpdate();
			// 4. Process the results
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
			}
			// 5. Disconnect
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
		}
	}
}
