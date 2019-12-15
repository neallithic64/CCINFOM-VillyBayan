package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Requests {
	private ArrayList<Integer> reqList;
	private ArrayList<String> resiList;
	private ArrayList<Integer> groupList;
	private ArrayList<Integer> slotList;
	
	public int req_no;
	public Date date_created;
	public Date date_processed;
	public char status;
	public char homeservice;
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
	
	public void getAllResidents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM residents;");
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
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM accessservicedb.groups;;");
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
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM timeslots;");
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
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests");
			ResultSet rs = pstmt.executeQuery();
			reqList.clear();
			while (rs.next())
				reqList.add(rs.getInt("request_no"));
			System.out.println("size of results: " + reqList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
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
			pstmt.setNull(3, java.sql.Types.DATE);
			pstmt.setString(4, "S");
			pstmt.setString(5, "Y");
			pstmt.setString(6, special_inst);
			pstmt.setDate(7, saved_date);
			pstmt.setNull(8, java.sql.Types.DATE);
			pstmt.setNull(9, java.sql.Types.DATE);
			pstmt.setNull(10, java.sql.Types.DATE);
			pstmt.setNull(11, java.sql.Types.TIME);
			pstmt.setNull(12, java.sql.Types.TIME);
			pstmt.setDouble(13, cancellation_fee);
			pstmt.setNull(14, java.sql.Types.VARCHAR);
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
	
}