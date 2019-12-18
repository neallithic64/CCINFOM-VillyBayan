<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Top Services Report</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<% Reporter rp = new Reporter();
			rp.report5(Integer.parseInt(request.getParameter("month")), Integer.parseInt(request.getParameter("year")));
			int i, reportSize = rp.servList.size();
		%>
		<div class="container">
			<h1 style="text-align: center">Top 3 Services</h1>
			<table class="table">
				<thead><tr>
						<th scope="col"></th>
						<th scope="col">Service</th>
						<th scope="col">Total Payments</th>
				</tr></thead>
				<tbody>
					<% for (i = 0; i < reportSize; i++) { %>
						<tr>
							<th scope="row"><%=i+1%></th>
							<td><%=rp.servList.get(i)%></td>
							<td><%=rp.totpayList.get(i)%></td>
						</tr>
					<%}%>
				</tbody>
			</table>
			<form class="form-horizontal" action="reportTopServProc.jsp" method="POST">
				<div class="form-row">
					<div class="col-sm-2">
						<label class="control-label" for="month">Month: </label>
					</div>
					<div class="col-sm-3">
						<select class="form-control" name="month" required>
							<option value="1">January</option>
							<option value="2">February</option>
							<option value="3">March</option>
							<option value="4">April</option>
							<option value="5">May</option>
							<option value="6">June</option>
							<option value="7">July</option>
							<option value="8">August</option>
							<option value="9">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>
						</select>
					</div>
					<div class="col-sm-2">
						<label class="control-label" for="year">Year: </label>
					</div>
					<div class="col-sm-3">
						<input type="number" class="form-control" value="2019" min="1800" max="5000" name="year" required>
					</div>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
			<br>
		</div>
		<button type="button" onclick="window.location.href = '/CCINFOM_LIMAWA/index.html';" class="btn btn-default">Return to Home</button>
	</body>
</html>
