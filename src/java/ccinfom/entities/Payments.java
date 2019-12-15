package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Payments {
	private ArrayList<Integer> paymentList;
	private ArrayList<Integer> reqList;
	private ArrayList<String> resiList;
	
	public int payment_id;
	public Date payment_date;
	public Time payment_time;
	public double amount;
	public String status;
	public String resident_email;
	public int req_no;
	
	public Payments() {
		paymentList = new ArrayList<>();
		reqList = new ArrayList<>();
		resiList = new ArrayList<>();
	}
	
	/* Getters for the ArrayLists
	*/
	public ArrayList<Integer> getPaymentList(){
		return paymentList;
	}
	public ArrayList<Integer> getReqList() {
		return reqList;
	}
	public ArrayList<String> getResiList() {
		return resiList;
	}
	
	/* Populating ArrayLists with database data
	*/
	public void getAllPayments() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT payment_id FROM payments ORDER BY payment_id;");
			ResultSet rs = pstmt.executeQuery();
			paymentList.clear();
			while (rs.next())
				paymentList.add(rs.getInt("payment_id"));
			System.out.println("size of results: " + paymentList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}

	public void getAllRequests() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests ORDER BY request_no;");
			ResultSet rs = pstmt.executeQuery();
			reqList.clear();
			while (rs.next())
				reqList.add(rs.getInt("request_no"));
			System.out.println("size of results: " + reqList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	public void getAllResidents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM residents ORDER BY resident_email");
			ResultSet rs = pstmt.executeQuery();
			resiList.clear();
			while (rs.next())
				resiList.add(rs.getString("resident_email"));
			System.out.println("size of results: " + resiList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}	
	
	public void getPaymentData(int paymentno_Query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM payments WHERE payment_id = ?");
			pstmt.setInt(1, paymentno_Query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				payment_id = rs.getInt("payment_id");
				payment_date = rs.getDate("payment_date");
				payment_time = rs.getTime("payment_time");
				amount = rs.getDouble("amount");
				status = rs.getString("status");
				resident_email = rs.getString("resident_email");
				req_no = rs.getInt("req_no");
	
			}
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
	/* Helper method to get the next request_no, to avoid data clashing of
		primary key. Sets req_no to the next available request_no
	*/
	public void getNextPaymentID() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT payment_id FROM payments order by payment_id;");
			ResultSet rs = pstmt.executeQuery();
			payment_id = 0;
			while (rs.next())
				payment_id = rs.getInt(1);
			payment_id++;
			pstmt.close();
			conn.close();
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO payments VALUES (?,?,?,?,?,?,?)");
			pstmt.setInt(1, payment_id);
			pstmt.setDate(2, payment_date);
			pstmt.setTime(3, payment_time);
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
	

	
	/* Update the payment record that matches the input payment_id input/parameter
	*/
	public boolean updatePayment(int updatePaymentId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("UPDATE payments "
					+ "SET payment_date = ?, payment_time = ?, amount = ?, status = ?, resident_email = ?, "
					+ "request_no = ? "
					+ "WHERE payment_id = ?");
			
			
			pstmt.setDate(1, payment_date);
			pstmt.setTime(2, payment_time);
			pstmt.setDouble(3, amount);
			pstmt.setString(4, status);
			pstmt.setString(5, resident_email);
			pstmt.setInt(6, req_no);
			pstmt.setInt(7, updatePaymentId);
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	public boolean deletePayment(int delPaymentId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM payments WHERE payment_id= ?");
			pstmt.setInt(1, delPaymentId);
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	@Override
	public String toString() {
		String strData = "Payment ID " + payment_id + "\n";
		strData += "\tPayment Date: " + payment_date.toString() + "\n";
		strData += "\tPayment Time: " + payment_date.toString() + "\n";
		strData += "\tAmount: " + amount + "\n";
		
		switch (status) {
			case "P": strData += "\tStatus: Paid\n"; break;
			case "U": strData += "\tStatus: Unpaid\n"; break;
		}

		strData += "\tResident Email: " + resident_email + "\n";
		strData += "Request Number " + req_no + "\n";
		
		return strData;
	}
}
	
