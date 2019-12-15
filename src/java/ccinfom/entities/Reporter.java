package ccinfom.entities;

import java.util.ArrayList;
import java.sql.*;

public class Reporter {
	/* ArrayLists needed to store data from SQL queries, declarations placed
		here. Make them public so that you won't need getters anymore!
	*/
	
	// Report 1: 
	public ArrayList<Integer> monthList
	public ArrayList<Integer> completedList
	public ArrayList<Integer> cancelledList
	public ArrayList<Double> salesList

	// Report 4:
	public ArrayList<Double> overallList;
	public ArrayList<Double> servicesList;
	public ArrayList<Double> valueList;
	public ArrayList<Double> timelinessList;
	public ArrayList<Double> politenessList;
	
	// Report 5: String and Double
	public ArrayList<String> servList;
	public ArrayList<Double> totpayList;
	
	/* Constructor. Instantiate your ArrayLists here! */
	public Reporter() {
		
		monthList = new ArrayList<>();
		completedList = new ArrayList<>();
		cancelledList = new ArrayList<>();
		salesList = new ArrayList<>();
		
		servList = new ArrayList<>();
		totpayList = new ArrayList<>();
		
		overallList = new ArrayList<>();
		servicesList = new ArrayList<>();
		valueList = new ArrayList<>();
		timelinessList = new ArrayList<>();
		politenessList = new ArrayList<>();
	}

	/** Report 1: Monthly completed and cancelled service requests and total sales given a specific year
	 * 
	 * @param year User-specified year
	 */
	public void report1(int year) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("SELECT		A.Month, A.Completed_Service_Requests, B.Cancelled_Service_Requests, C.Total_Sales " +
															"FROM		(SELECT	Month(r.date_created) AS Month, COUNT(r.completed_date) AS Completed_Service_Requests " +
															"				FROM		requests r " +
															"				WHERE		r.completed_date IS NOT NULL AND YEAR(r.date_created) = ? " +
															"				ORDER BY	Month(r.completed_date)) A " +
															"LEFT JOIN		(SELECT	Month(r.date_created) AS Month, COUNT(r.cancelled_date) AS Cancelled_Service_Requests " +
															"				FROM		requests r " +
															"				WHERE		r.cancelled_date IS NOT NULL AND YEAR(r.date_created) = ? " +
															"				ORDER BY	Month(r.completed_date)) B ON A.Month = B.Month " +
																"LEFT JOIN		(SELECT	Month(r.date_created) AS Month, SUM(p.amount) AS Total_Sales " +
																"				FROM		requests r 		JOIN payments p" +
																"											ON	p.req_no = r.req_no" +
																"				WHERE		r.cancelled_date IS NOT NULL AND p.status = 'P' AND YEAR(r.date_created) = ? " +
																"				ORDER BY	MONTH(r.completed_date)) C ON B.Month = C.Month; ");
			pstmt.setInt(1, year);
			ResultSet rs = pstmt.executeQuery();
			monthList.clear();
			completedList.clear();
			cancelledList.clear();
			salesList.clear();
			while (rs.next()) {
				servList.add(rs.getInteger(1));
				completedList.add(rs.getInteger(2));
				cancelledList.add(rs.getInteger(3);
				salesList.add(rs.getDouble(4));
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("error generating report! " + e.getMessage());
		}
	}
	 
	 
	/** Report 4: Monthly ratings per year
	 *
	 * @param year User-specified year
	 * @param supplier_email User-specified supplier email
	 */
	public void report4(int year, String supplier_email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicesdb?user=admin&password=p@ssword");
			PreparedStatement pstmt = conn.prepareStatement("" +
					"SELECT		AVG(overall) AS "Overall Rating", AVG(service) AS Service," +
					"AVG(value) AS Value, AVG(Timeliness) AS Timeliness, AVG(Politeness) AS Politeness"
					"FROM		reqratings r JOIN requests req ON r.request_no = req.request_no " +
					"WHERE		req.slot_id IN (SELECT t.slot_id FROM timeslots t" +
					"							WHERE t.service_id IN (SELECT s.service_id FROM services s" +
					"												   WHERE supplier_email = ?)" +
					"												   )" +
					"			AND	YEAR(completed_date) = ?)" +
					"GROUP BY 	month(req.completed_date)" +
					"ORDER BY	month(req.completed_date)")
			pstmt.setInt(1, year);
			pstmt.setString(2, supplier_email);
			ResultSet rs = pstmt.executeQuery();

			overallList.clear();
			servicesList.clear();
			valueList.clear();
			timelinessList.clear();
			politenessList.clear();

			while (rs.next()) {
				overallList.add(rs.getDouble(1));
				servicesList.add(rs.getDouble(2));
				valueList.add(rs.getDouble(3));
				timelinessList.add(rs.getDouble(4));
				politenessList.add(rs.getDouble(5));
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("error generating report! " + e.getMessage());
		}
	}


	/** Report 5: Top 3 services availed based on sales for a specific month and year
	 * 
	 * @param month User-specified month
	 * @param year User-specified year
	 */
	public void report5(int month, int year) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
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
