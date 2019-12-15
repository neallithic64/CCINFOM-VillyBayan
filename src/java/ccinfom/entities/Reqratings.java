package ccinfom.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reqratings {

    private ArrayList<Integer> reqlist;
    private ArrayList<String> suppList;

    public int req_no;
    public int service;
    public int value;
    public int timeliness;
    public int politeness;
    public int overall;

    public Reqratings(){
        req_no = 0;
        service = 0;
        value = 0;
        timeliness = 0;
        politeness = 0;
        overall = 0;

        reqlist = new ArrayList<>();
		suppList = new ArrayList<>();
    }

    public ArrayList<Integer> getReqList() {
        return reqlist;
    }
    public ArrayList<String> getSuppList() {
		return suppList;
	}

    public void getReqNos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("SELECT request_no FROM requests ORDER BY request_no;");
            ResultSet rs = pstmt.executeQuery();
            reqlist.clear();
            while (rs.next())
                reqlist.add(rs.getInt("request_no"));
            System.out.println("size of results: " + reqlist.size());
        } catch (Exception e) {
            System.out.println("error! " + e.getMessage());
        }
    }

    public void getAllSuppliers() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM suppliers ORDER BY supplier_email");
            ResultSet rs = pstmt.executeQuery();
            suppList.clear();
            while (rs.next())
                suppList.add(rs.getString("supplier_email"));
            System.out.println("size of results: " + suppList.size());
        } catch (Exception e) {
            System.out.println("error! " + e.getMessage());
        }
    }


    public void getRateData(int req_no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM reqrating WHERE request_no = ?");
            pstmt.setInt(1, req_no);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.req_no = rs.getInt("request_no");
                service = rs.getInt("service");
                value = rs.getInt("value");
                timeliness = rs.getInt("timeliness");
                politeness = rs.getInt("politeness");
                overall = rs.getInt("overall");
            }
        } catch (Exception e) {
            System.out.println("error! " + e.getMessage());
        }
    }



    private boolean isValNull() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM reqrating WHERE request_no = ?");
            pstmt.setInt(1, req_no);
            ResultSet rs = pstmt.executeQuery();
			boolean allNull = false;
            while (rs.next())
                if (rs.getInt(1) == java.sql.Types.NULL)
                    allNull = true;
			pstmt.close();
			conn.close();
            return allNull;
        }
        catch (Exception e) {
            System.out.println("error! " + e.getMessage());
            return false;
        }
    }

    public void computeOverall() {
        overall = req_no+service+value+timeliness+politeness;
    }

	/* Method returns true if INSERT is successful, false otherwise.
	*/
    public boolean newRating() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");

            if (isValNull()) {
				conn.close();
				return false;
			}
                

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO reqrating VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, req_no);
            pstmt.setInt(2, service);
            pstmt.setInt(3, value);
            pstmt.setInt(4, timeliness);
            pstmt.setInt(5, politeness);
            computeOverall();
            pstmt.setInt(6, overall);
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
    public boolean updateRating(int req_no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE reqrating "
                    + "SET service = ?, value = ?, timeliness = ?, politeness = ?, overall = ? "
                    + "WHERE request_no = ?");

            pstmt.setInt(1, service);
            pstmt.setInt(2, value);
            pstmt.setInt(3, timeliness);
            pstmt.setInt(4, politeness);

            computeOverall();

            pstmt.setInt(5, overall);
            pstmt.setInt(6, req_no);

            pstmt.execute();
            pstmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("error! " + e.getMessage());
            return false;
        }
    }

    public boolean deleteRating(int req_no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=root&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM reqrating WHERE request_no= ?");
            pstmt.setInt(1, req_no);
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
        String strData = "Request Number " + req_no + "\n";
        strData += "\tService Rating: " + service + "\n";
        strData += "\tValue Rating: " + value + "\n";
        strData += "\tTimeliness Rating: " + timeliness + "\n";
        strData += "\tPoliteness Rating: " + politeness + "\n";
        strData += "\tOverall Rating: " + overall + "\n";

        return strData;
    }

}
