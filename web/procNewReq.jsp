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
			newRq.saved_date = Date.valueOf(LocalDate.now());
			newRq.special_inst = request.getParameter("spec_inst");
			newRq.resident_email = request.getParameter("resi_email");
			newRq.group_id = Integer.parseInt(request.getParameter("group_id"));
			newRq.slot_id = Integer.parseInt(request.getParameter("slot_id"));
			
			Thread.sleep(5*1000);
			if (newRq.newRequest())
				response.sendRedirect("newRqSucc.html");
			else response.sendRedirect("newRqFail.html");
		%>
		
    </body>
</html>
