package ccinfom.entities;

import java.sql.*;
import java.time.LocalDate;

public class User {
	private String email;
	private String username;
	private String password;
	private char sex;
	private String firstname;
	private String lastname;
	private Date birthday;

	public User(String email, String username, String password, char sex, String firstname, String lastname, LocalDate birthday) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = Date.valueOf(birthday);
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public char getSex() {
		return sex;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	
	public boolean register() {
		try {
			String query = "INSERT INTO accessservicedb.USERS (email, username, password, sex, birthday) VALUES (?,?,?,?,?)";
			// 1. Connect to the database
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/CCINFOM?useTimezone=true&serverTimezone=UTC&user=admin&password=p@ssword");
			// 2. Prepare the SQL Statement
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, Character.toString(sex));
			stmt.setDate(5, (Date)birthday);
			// 3. Execute the SQL Statement
			stmt.executeUpdate();
			// 4. Process the results
			
			// 5. Disconnect
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
			return false;
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
				//rs.
			}
			// 5. Disconnect
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
		}
	}
}
