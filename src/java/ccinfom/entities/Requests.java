package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Requests {
	private ArrayList<Integer> reqList;
	private ArrayList<String> reqInfo;
	
	public Requests() {
		reqList = new ArrayList<>();
		reqInfo = new ArrayList<>();
	}
	public ArrayList<Integer> getReqList() {
		return reqList;
	}
	public ArrayList<String> getReqInfo() {
		return reqInfo;
	}
	
	public boolean getAllRequests() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT special_instruct FROM requests");
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
	
	/* supposed to store all fields of a single record into reqInfo, but still thinking
		if it's possible to iterate through columns */
	public boolean getReqInfo(String spec_inst) {
		try {
			int i = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM accessservicedb.requests WHERE special_instruct = ?;");
			pstmt.setString(1, spec_inst);
			ResultSet rs = pstmt.executeQuery();
			reqInfo.clear();
			if (rs.next()) {
				reqInfo.add(rs.getString(6));
				i++;
			}
			System.out.println("size of AL: " + reqList.size());
			return true;
		} catch (Exception e) {
			System.out.println("error! " + e.getMessage());
			return false;
		}
	}
	
	public static void main(String[] args) {
		Requests b = new Requests();
		b.getAllRequests();
		b.getReqInfo("None");
	}
}
