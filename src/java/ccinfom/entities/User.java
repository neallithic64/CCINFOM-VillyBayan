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

	public User(String email, String username, String password, char sex, String firstname, String lastname, Date birthday) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
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
	
	/* Submits a new user into the database. However, this will not always work, since the
		email attribute is a primary key. If the email inputted is a duplicate, data won't
		be inserted.
	*/
	public boolean register() {
		try {
			String query = "INSERT INTO accessservicedb.USERS (email, username, password, sex, birthday) VALUES (?,?,?,?,?)";
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?useTimezone=true&serverTimezone=UTC&user=root&password=p@ssword");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, Character.toString(sex));
			stmt.setDate(5, birthday);
			stmt.executeUpdate();
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
	 */
	public boolean login(String email, String pass) {
		boolean loginSuccess = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?useTimezone=true&serverTimezone=UTC&user=root&password=p@ssword");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accessservicedb.USERS WHERE email = ? AND password = ?;");
			stmt.setString(1, email);
			stmt.setString(2, pass);
			stmt.executeUpdate();
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				this.lastname = rs.getString("last_name");
				this.firstname = rs.getString("first_name");
				loginSuccess = true;
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
		}
		return loginSuccess;
	}
}
