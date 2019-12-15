package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Payments {
	private ArrayList<Integer> reqList;
	private ArrayList<String> resiList;
	
	public int payment_no;
	public Date payment_date;
	public Time payment_time;
	public double amount;
	public char status;
	public String resident_email;
	public int req_no;
	
	public Payments() {
		payment_no = 0;
		amount = 0;
		req_no = 0;
		
		reqList = new ArrayList<>();
		resiList = new ArrayList<>();
	}
	
	/* Getters for the ArrayLists
	*/
	public ArrayList<Integer> getReqList() {
		return reqList;
	}
	public ArrayList<String> getResiList() {
		return resiList;
	}
	
	/* Populating ArrayLists with database data
	*/
	public void getReqNos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests ORDER BY request_no;");
			ResultSet rs = pstmt.executeQuery();
			reqlist.clear();
			while (rs.next())
				reqlist.add(rs.getInt("requests"));
			System.out.println("size of results: " + reqlist.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
	
	/* By default, the following values are NULL:
		- payment_date
		- payment_time
	** Method returns true if INSERT is successful, false otherwise.
	*/
	
	public boolean newPayment() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO payments VALUES (?,?,?,?,?,?,?)");
			pstmt.setInt(1, payment_no);
			pstmt.setNull(2, java.sql.Types.DATE);
			pstmt.setNull(3, java.sql.Types.TIME);
			pstmt.setDouble(4, amount);
			pstmt.setString(5, "U");
			pstmt.setString(6, resident_email);
			pstmt.setInt(7, req_no);
		
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	/* Update the payment record that matches the input payment_no input/parameter
	*/
	public boolean updatePayment(int updatePaymentNo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("UPDATE payments "
					+ "SET payment_date = ?, payment_time = ?, amount = ?, status = ?, resident_email = ?, "
					+ "req_no = ?,"
					+ "WHERE payment_no = ?");
			
			
			pstmt.setNull(1, java.sql.Types.DATE);
			pstmt.setNull(2, java.sql.Types.TIME);
			pstmt.setDouble(3, amount);
			pstmt.setString(4, "U");
			pstmt.setString(5, resident_email);
			pstmt.setInt(6, req_no);
			pstmt.setInt(7, updatePaymentNo);
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
