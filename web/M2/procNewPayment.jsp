<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Your Payment...</title>
    </head>
    <body>
        <h1 style="text-align: center">Processing submission...</h1>
		<% Payments newPayment = new Payments();
			newPayment.getNextPaymentID();
		%>
		<p style="background-color: tomato"> <%= newPayment.payment_id %> </p>
		<%
			newPayment.payment_date = Date.valueOf(LocalDate.now());
			newPayment.payment_time= Time.valueOf(LocalTime.now());
			newPayment.amount = 100.0;
			newPayment.status = "U";
			newPayment.resident_email = request.getParameter("resident_email");
			newPayment.req_no = Integer.parseInt(request.getParameter("req_no"));
			
			
			Thread.sleep(5*1000);
			if (newPayment.newPayment())
				response.sendRedirect("procPaymentSucc.html");
			else response.sendRedirect("procPaymentFail.html");
		%>
		
    </body>
</html>
