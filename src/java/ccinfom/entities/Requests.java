package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Requests {
	private ArrayList<Integer> reqList;
	private ArrayList<String> resiList;
	
	private int req_no;
	private Date date_created;
	private Date date_processed;
	private char status;
	private char homeservice;
	private String special_inst;
	private Date confirmed_date;
	private Date cancelled_date;
	private Date completed_date;
	private Time confirmed_time;
	private Time cancelled_time;
	private double cancellation_fee;
	private String cancellation_reason;
	private double total_amount;
	private String resident_email;
	private int group_id;
	private int slot_id;
	
	public Requests() {
		reqList = new ArrayList<>();
		resiList = new ArrayList<>();
	}
	public ArrayList<Integer> getReqList() {
		return reqList;
	}
	public ArrayList<String> getResiList() {
		return resiList;
	}
	public void setReq_no(int req_no) {
		this.req_no = req_no;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public void setDate_processed(Date date_processed) {
		this.date_processed = date_processed;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public void setHomeservice(char homeservice) {
		this.homeservice = homeservice;
	}
	public void setSpecial_inst(String special_inst) {
		this.special_inst = special_inst;
	}
	public void setConfirmed_date(Date confirmed_date) {
		this.confirmed_date = confirmed_date;
	}
	public void setCancelled_date(Date cancelled_date) {
		this.cancelled_date = cancelled_date;
	}
	public void setCompleted_date(Date completed_date) {
		this.completed_date = completed_date;
	}
	public void setConfirmed_time(Time confirmed_time) {
		this.confirmed_time = confirmed_time;
	}
	public void setCancelled_time(Time cancelled_time) {
		this.cancelled_time = cancelled_time;
	}
	public void setCancellation_fee(double cancellation_fee) {
		this.cancellation_fee = cancellation_fee;
	}
	public void setCancellation_reason(String cancellation_reason) {
		this.cancellation_reason = cancellation_reason;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public void setResident_email(String resident_email) {
		this.resident_email = resident_email;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
	
	public void getAllResidents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT  FROM requests");
			ResultSet rs = pstmt.executeQuery();
			reqList.clear();
			while (rs.next())
				reqList.add(rs.getInt("request_no"));
			System.out.println("size of results: " + reqList.size());
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
	public boolean getAllRequests() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests");
			ResultSet rs = pstmt.executeQuery();
			reqList.clear();
			while (rs.next())
				reqList.add(rs.getInt("request_no"));
			System.out.println("size of results: " + reqList.size());
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	public void newRequest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO requests  VALUES (?)");
//			pstmt.setInt(1, );
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
		}
	}
	
}
