package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

/* First four ArrayLists represent foreign key datasets from other tables, used
	in creation of a request
*/
public class Requests {
	private ArrayList<Integer> reqList;
	private ArrayList<String> resiList;
	private ArrayList<Integer> groupList;
	private ArrayList<Integer> slotList;
	
	public int req_no;
	public Date date_created;
	public Date date_processed;
	public String status;
	public String homeservice;
	public String special_inst;
	public Date saved_date;
	public Date confirmed_date;
	public Date cancelled_date;
	public Date completed_date;
	public Time confirmed_time;
	public Time cancelled_time;
	public double cancellation_fee;
	public String cancellation_reason;
	public double total_amount;
	public String resident_email;
	public int group_id;
	public int slot_id;
	
	public Requests() {
		reqList = new ArrayList<>();
		resiList = new ArrayList<>();
		groupList = new ArrayList<>();
		slotList = new ArrayList<>();
	}
	/* Getters for the ArrayLists
	*/
	public ArrayList<Integer> getReqList() {
		return reqList;
	}
	public ArrayList<String> getResiList() {
		return resiList;
	}
	public ArrayList<Integer> getGroupList() {
		return groupList;
	}
	public ArrayList<Integer> getSlotList() {
		return slotList;
	}
	
	/* Populating ArrayLists with database data
	*/
	public void getAllResidents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
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
	public void getAllGroupIDs() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM accessservicedb.groups ORDER BY group_id");
			ResultSet rs = pstmt.executeQuery();
			groupList.clear();
			while (rs.next())
				groupList.add(rs.getInt("group_id"));
			System.out.println("size of results: " + groupList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	public void getAllSlotIDs() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM timeslots ORDER BY slot_id;");
			ResultSet rs = pstmt.executeQuery();
			slotList.clear();
			while (rs.next())
				slotList.add(rs.getInt("slot_id"));
			System.out.println("size of results: " + slotList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	public void getAllRequests() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
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
	public void getReqData(int reqno_Query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM requests WHERE request_no = ?");
			pstmt.setInt(1, reqno_Query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				req_no = rs.getInt("request_no");
				date_created = rs.getDate("date_created");
				date_processed = rs.getDate("date_processed");
				status = rs.getString("status");
				homeservice = rs.getString("homeservice");
				special_inst = rs.getString("resident_email");
				saved_date = rs.getDate("saved_date");
				confirmed_date = rs.getDate("confirmed_date");
				cancelled_date = rs.getDate("cancelled_date");
				completed_date = rs.getDate("completed_date");
				confirmed_time = rs.getTime("confirmed_time");
				cancelled_time = rs.getTime("cancelled_time");
				cancellation_fee = rs.getDouble("cancellation_fee");
				cancellation_reason = rs.getString("resident_email");
				total_amount = rs.getDouble("total_amount");
				resident_email = rs.getString("resident_email");
				group_id = rs.getInt("group_id");
				slot_id = rs.getInt("slot_id");
			}
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
	/* Helper method to get the next request_no, to avoid data clashing of
		primary key. Sets req_no to the next available request_no
	*/
	public void getNextReqNo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests order by request_no;");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				req_no = rs.getInt(1);
			req_no++;
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
	/* By default, the following values are NULL:
		- date_processed
		- confirmed_date
		- cancelled_date
		- completed_date
		- confirmed_time
		- cancelled_time
	** Method returns true if INSERT is successful, false otherwise.
	*/
	public boolean newRequest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO requests VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, req_no);
			pstmt.setDate(2, date_created);
			pstmt.setDate(3, date_processed);
			pstmt.setString(4, status);
			pstmt.setString(5, homeservice);
			pstmt.setString(6, special_inst);
			pstmt.setDate(7, saved_date);
			pstmt.setDate(8, confirmed_date);
			pstmt.setDate(9, cancelled_date);
			pstmt.setDate(10, completed_date);
			pstmt.setTime(11, confirmed_time);
			pstmt.setTime(12, cancelled_time);
			pstmt.setDouble(13, cancellation_fee);
			pstmt.setString(14, cancellation_reason);
			pstmt.setDouble(15, total_amount);
			pstmt.setString(16, resident_email);
			pstmt.setInt(17, group_id);
			pstmt.setInt(18, slot_id);
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	/* Update the request record that matches the input request_no input/parameter
		with the currently-set attributes of the object
	*/
	public boolean updateRequest(int updateReqNo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("UPDATE requests "
					+ "SET date_created = ?, date_processed = ?, status = ?, homeservice = ?, special_instruct = ?, "
					+ "cancellation_fee = ?, cancellation_reason = ?, total_amount = ?, resident_email = ?, group_id = ?, "
					+ "slot_id = ? "
					+ "WHERE request_no = ?");
			
			pstmt.setDate(1, date_created);
			pstmt.setDate(2, date_processed);
			pstmt.setString(3, status);
			pstmt.setString(4, homeservice);
			pstmt.setString(5, special_inst);
			pstmt.setDouble(6, cancellation_fee);
			pstmt.setString(7, cancellation_reason);
			pstmt.setDouble(8, total_amount);
			pstmt.setString(9, resident_email);
			pstmt.setInt(10, group_id);
			pstmt.setInt(11, slot_id);
			pstmt.setInt(12, updateReqNo);
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	public boolean deletePayment(int delPayID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM payments WHERE payment_id= ?");
			pstmt.setInt(1, delPayID);
			pstmt.execute();
			pstmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	public void makeReport() {
		
	}
	
	@Override
	public String toString() {
		String strData = "Request Number " + req_no + "\n";
		strData += "\tDate Created: " + date_created.toString() + "\n";
		strData += "\tDate Processed: " + date_processed.toString() + "\n";
		
		switch (status) {
			case "S": strData += "\tStatus: Saved\n"; break;
			case "D": strData += "\tStatus: Deleted\n"; break;
			case "C": strData += "\tStatus: Confirmed\n"; break;
			case "X": strData += "\tStatus: Cancelled\n"; break;
			case "P": strData += "\tStatus: Pending\n"; break;
		}
		switch (homeservice) {
			case "Y": strData += "\tHome Service: Yes\n"; break;
			case "N": strData += "\tHome Service: No\n"; break;
		}
		strData += "\tSpecial Instructions: " + special_inst + "\n";
		strData += "\tDate Saved: " + saved_date.toString() + "\n";
		strData += "\tDate Confirmed: " + confirmed_date.toString() + "\n";
		strData += "\tDate Cancelled: " + cancelled_date.toString() + "\n";
		strData += "\tDate Completed: " + completed_date.toString() + "\n";
		strData += "\tTime Confirmed: " + confirmed_time.toString() + "\n";
		strData += "\tTime Cancelled: " + cancelled_time.toString() + "\n";
		strData += "\tCancellation Fee: " + cancellation_fee + "\n";
		strData += "\tCancellation Reason: " + cancellation_reason + "\n";
		strData += "\tTotal Amount: " + total_amount + "\n";
		strData += "\tResident Email: " + resident_email + "\n";
		strData += "\tGroup ID: " + group_id + "\n";
		strData += "\tSlot ID: " + slot_id + "\n";
		
		return strData;
	}
}