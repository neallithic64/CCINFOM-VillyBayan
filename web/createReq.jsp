<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<!-- Columns:
		request_no			int(8) PK
		date_created		date
		date_processed		date
		status				enum('S','D','C','X','P')
		homeservice			enum('Y','N')
		special_instruct	varchar(100)
		saved_date			date
		confirmed_date		date
		cancelled_date		date
		completed_date		date
		confirmed_time		time
		cancelled_time		time
		cancellation_fee	decimal(9,2)
		cancellation_reason	varchar(100)
		total_amount		decimal(9,2)
		resident_email		varchar(100)
		group_id			int(8)
		slot_id				int(8)
-->

<html>
	<head>
		<title>Create Request</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<% Requests reqReport = new Requests();
			reqReport.getAllRequests();
		%>
		<h3 class="col-sm-offset-1">Create Request...</h3>
			<div class="container">
				<!--<h4 class="col-sm-offset-2 container">Shortcut Requesting!</h4>-->
				<form class="form-horizontal" action="procNewReq.jsp" method="POST">
					<select class="form-control" name="itemkindselector">
						<%	int index, size = reqReport.getReqList().size();
							for (index = 0; index < size; index++) { %>
								<option value="<%=reqReport.getReqList().get(index)%>"> <%=reqReport.getReqList().get(index)%></option>
						<%	}
						%>
					</select>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" placeholder="Enter email" name="email">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="password">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="Enter password" name="password">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form>
			</div>
	</body>
</html>
