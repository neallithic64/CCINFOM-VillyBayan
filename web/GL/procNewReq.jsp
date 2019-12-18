<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Your Request...</title>
    </head>
    <body>
        <h1 style="text-align: center">Processing submission...</h1>
		<% Requests newRq = new Requests();
			newRq.getNextReqNo();
		%>
		<p style="background-color: tomato"> <%= newRq.req_no %> </p>
		<%
			newRq.date_created = Date.valueOf(LocalDate.now());
			newRq.date_processed = Date.valueOf(LocalDate.now());
			newRq.status = "S";
			newRq.homeservice = "N";
			newRq.special_inst = request.getParameter("spec_inst");
			newRq.saved_date = Date.valueOf(LocalDate.now());
			newRq.confirmed_date = Date.valueOf(LocalDate.now());
			newRq.cancelled_date = Date.valueOf(LocalDate.now());
			newRq.completed_date = Date.valueOf(LocalDate.now());
			newRq.confirmed_time = Time.valueOf(LocalTime.now());
			newRq.cancelled_time = Time.valueOf(LocalTime.now());
			newRq.cancellation_fee = 100.0;
			newRq.cancellation_reason = "None";
			newRq.total_amount = 200.0;
			newRq.resident_email = request.getParameter("resi_email");
			newRq.group_id = Integer.parseInt(request.getParameter("group_id"));
			newRq.slot_id = Integer.parseInt(request.getParameter("slot_id"));
			
			Thread.sleep(5*1000);
			if (newRq.newRequest())
				response.sendRedirect("procRqSucc.html");
			else response.sendRedirect("procRqFail.html");
		%>
		
    </body>
</html>
