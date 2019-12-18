<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Processing Request Update...</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
    <body>
		<h1 style="text-align: center">Processing Update Request...</h1>
		<% Requests updRq = new Requests();
			updRq.date_created = Date.valueOf(LocalDate.parse(request.getParameter("date_create")));
			updRq.date_processed = Date.valueOf(LocalDate.parse(request.getParameter("date_proc")));
			updRq.status = request.getParameter("status");
			updRq.homeservice = request.getParameter("homeserv");
			updRq.special_inst = request.getParameter("spec_inst");
			updRq.cancellation_fee = Double.parseDouble(request.getParameter("canc_fee"));
			updRq.cancellation_reason = request.getParameter("canc_reas");
			updRq.total_amount = Double.parseDouble(request.getParameter("tot_amt"));
			updRq.resident_email = request.getParameter("resi_email");
			updRq.group_id = Integer.parseInt(request.getParameter("group_id"));
			updRq.slot_id = Integer.parseInt(request.getParameter("slot_id"));
		%>
		<div class="container">
			
		</div>
		<% if (updRq.updateRequest(Integer.parseInt(request.getParameter("upReq_no"))))
				response.sendRedirect("procRqSucc.html");
			else response.sendRedirect("procRqFail.html");
		%>
    </body>
</html>
