package ccinfom.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reqratings {

    private ArrayList<Integer> reqlist;

    public int req_no;
    public int service;
    public int value;
    public int timeliness;
    public int politeness;
    public int overall;

    public Reqratings(){
        req_no=0;
        service=0;
        value=0;
        timeliness=0;
        politeness=0;
        overall=0;

        reqlist = new ArrayList<>();
    }

    public ArrayList<Integer> getReqlist() {
        return reqlist;
    }

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

    /*
    Method returns true if INSERT is successful, false otherwise.
	*/
    public boolean newRating() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/accessservicedb?user=admin&password=p@ssword");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO reqratings VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, req_no);
            pstmt.setInt(2, service);
            pstmt.setInt(3, value);
            pstmt.setInt(4, timeliness);
            pstmt.setInt(5, politeness);
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

}
