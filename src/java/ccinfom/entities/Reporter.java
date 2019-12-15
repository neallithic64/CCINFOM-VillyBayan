package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Reporter {
	/* ArrayLists needed to store data from SQL queries, declarations placed
		here. Make them public so that you won't need getters anymore!
	*/
	
	// Report 1: 
	
	
	// Report 2: 
	
	
	// Report 5: String and Double
	public ArrayList<String> servList;
	public ArrayList<Double> totpayList;
	
	/* Constructor. Instantiate your ArrayLists here! */
	public Reporter() {
		
		servList = new ArrayList<>();
		totpayList = new ArrayList<>();
	}
	
	/** Report 5: Top 3 services availed based on sales for a specific month and year
	 * 
	 * @param month User-specified month
	 * @param year User-specified year
	 */
	public void report5(int month, int year) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicesdb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT		s.name AS ServiceName, SUM(p.amount) AS TotalPayments " +
															"FROM		services s " +
															"	JOIN	timeslots t " +
															"	ON		s.service_id = t.service_id " +
															"    JOIN	requests r " +
															"    ON		t.slot_id = r.slot_id " +
															"    JOIN	payments p " +
															"    ON		r.request_no = p.request_no " +
															"WHERE		MONTH(p.payment_date) = ? " +
															"	AND		YEAR(p.payment_date) = ? " +
															"GROUP BY	s.name " +
															"ORDER BY	TotalPayments DESC " +
															"LIMIT		3;");
			pstmt.setInt(1, month);
			pstmt.setInt(2, year);
			ResultSet rs = pstmt.executeQuery();
			servList.clear();
			totpayList.clear();
			while (rs.next()) {
				servList.add(rs.getString(1));
				totpayList.add(rs.getDouble(2));
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("error generating report! " + e.getMessage());
		}
	}
}
