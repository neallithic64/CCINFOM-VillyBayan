<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
    <body>
        <h1 class="jumbotron" style="text-align: center">Displaying Request...</h1>
		<% Requests req = new Requests();
			req.getReqData(Integer.parseInt(request.getParameter("dispReqNo")));
		%>
		<table class="table">
			<tbody>
				<tr>
					<th scope="row">Request Number</th>
					<td><%= req.req_no %></td>
				</tr>
				<tr>
					<th scope="row">Date Created</th>
					<td><%= req.date_created != null ? req.date_created.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Date Processed</th>
					<td><%= req.date_processed != null ? req.date_processed.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Status</th>
					<td><% switch (req.status) {
							case "S": out.print("Saved"); break;
							case "D": out.print("Deleted"); break;
							case "C": out.print("Confirmed"); break;
							case "X": out.print("Cancelled"); break;
							case "P": out.print("Pending"); break;
						} %></td>
				</tr>
				<tr>
					<th scope="row">Home Service</th>
					<td><% switch (req.homeservice) {
							case "Y": out.print("Yes"); break;
							case "N": out.print("No"); break;
						} %></td>
				</tr>
				<tr>
					<th scope="row">Special Instructions</th>
					<td><%= req.special_inst %></td>
				</tr>
				<tr>
					<th scope="row">Date Saved</th>
					<td><%= req.saved_date != null ? req.saved_date.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Date Confirmed</th>
					<td><%= req.confirmed_date != null ? req.confirmed_date.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Date Cancelled</th>
					<td><%= req.cancelled_date != null ? req.cancelled_date.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Date Completed</th>
					<td><%= req.completed_date != null ? req.completed_date.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Time Confirmed</th>
					<td><%= req.confirmed_time != null ? req.confirmed_time.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Time Cancelled</th>
					<td><%= req.cancelled_time != null ? req.cancelled_time.toString() : "null" %></td>
				</tr>
				<tr>
					<th scope="row">Cancellation Fee</th>
					<td><%= req.cancellation_fee %></td>
				</tr>
				<tr>
					<th scope="row">Cancellation Reason</th>
					<td><%= req.cancellation_reason %></td>
				</tr>
				<tr>
					<th scope="row">Total Amount</th>
					<td><%= req.total_amount %></td>
				</tr>
				<tr>
					<th scope="row">Resident Email</th>
					<td><%= req.resident_email %></td>
				</tr>
				<tr>
					<th scope="row">Group ID</th>
					<td><%= req.group_id %></td>
				</tr>
				<tr>
					<th scope="row">Slot ID</th>
					<td><%= req.slot_id %></td>
				</tr>
			</tbody>
		</table>
		<button type="button" onclick="window.location.href = '/CCINFOM_LIMAWA/index.html';" class="btn btn-default">Return to Home</button>
    </body>
</html>
