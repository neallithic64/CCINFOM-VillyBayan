package ccinfom.entities;

import com.mysql.jdbc.Driver;
import java.math.BigInteger;
import java.util.ArrayList;
import java.sql.*;
import java.util.Properties;

public class Requests {
	private ArrayList<BigInteger> reqList;
	private ArrayList<String> reqInfo;
	
	public Requests() {
		reqList = new ArrayList<>();
		reqInfo = new ArrayList<>();
	}
	public ArrayList<BigInteger> getReqList() {
		return reqList;
	}
	public ArrayList<String> getReqInfo() {
		return reqInfo;
	}
	
	public boolean getAllRequests() {
		try {
			Driver d = new Driver();
//			Properties p = new Properties;
//			Connection conn = d.connect("jdbc:mysql://localhost:3307/accessservicedb", "user=admin&password=p@ssword");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?useTimezone=true&serverTimezone=UTC&user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests");
			ResultSet rs = pstmt.executeQuery();
			reqList.clear();
			while (rs.next())
				reqList.add(rs.getBigDecimal("request_no").toBigInteger());
			System.out.println("size of results: " + reqList.size());
			return true;
		} catch (Exception e) {
			System.out.println("error! log:\n" + e.getMessage());
			return false;
		}
	}
	
	/* supposed to store all fields of a single record into reqInfo, but still thinking
		if it's possible to iterate through columns */
	public boolean getReqInfo(int req_no) {
		try {
			int i = 0;
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/CCINFOM?useTimezone=true&serverTimezone=UTC&user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM accessservicedb.requests WHERE request_no = ?;");
			pstmt.setInt(1, req_no);
			ResultSet rs = pstmt.executeQuery();
			reqInfo.clear();
//			if (rs.) {
				reqInfo.add(rs.getString(i));
//				i++;
//			}
			System.out.println("size of AL: " + reqList.size());
			return true;
		} catch (SQLException e) {
			System.out.println("error! log:\n" + e.getMessage());
			return false;
		}
	}
}
