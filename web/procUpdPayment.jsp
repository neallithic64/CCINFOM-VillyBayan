<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Processing Payment Update...</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
    <body>
		<h1 style="text-align: center">Processing Update Payment...</h1>
		<% Payments updPayment = new Payments();
			updPayment.payment_date = Date.valueOf(LocalDate.parse(request.getParameter("payment_date")));
			updPayment.payment_time = Time.valueOf(LocalTime.parse(request.getParameter("payment_time")));
			updPayment.amount = Double.parseDouble(request.getParameter("amount"));
			updPayment.status = request.getParameter("status");
			updPayment.resident_email = request.getParameter("resident_email");
			updPayment.req_no = Integer.parseInt(request.getParameter("req_no"));
		%>
		<div class="container">
			
		</div>
		<% if (updPayment.updatePayment(Integer.parseInt(request.getParameter("upPayment_id"))))
				response.sendRedirect("procPaymentSucc.html");
			else response.sendRedirect("procPaymentFail.html");
		%>
    </body>
</html>