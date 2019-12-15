<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Monthly Services Request Report and Total Sales in a specific year Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
    <body>
		<% Reporter rp = new Reporter();
			rp.report1(Integer.parseInt(request.getParameter("year")), );
			int i, reportSize = rp.salesList.size();
		%>
		<div class="container">
			<h1 style="text-align: center">Monthly Completed and Cancelled Services and Total Sales in a specific year</h1>
			<table class="table">
				<thead><tr>
						<th scope="col"></th>
						<th scope="col">Month</th>
						<th scope="col">Completed Service Requests</th>
						<th scope="col">Cancelled Service Requests</th>
						<th scope="col">Total Sales</th>
				</tr></thead>
				<tbody>
					<% for (i = 0; i < reportSize; i++) { %>
						<tr>
							<th scope="row"><%=i+1%></th>
							<td><%=rp.monthList.get(i)%></td>
							<td><%=rp.completedList.get(i)%></td>
							<td><%=rp.cancelledList.get(i)%></td>
							<td><%=rp.salesList.get(i)%></td>
						</tr>
					<%}%>
				</tbody>
			</table>
			<form class="form-horizontal" action="reportMonthlyReqSales.jsp" method="POST">
				<div class="form-group">
                    <label class="control-label col-sm-2" for="year">Year: </label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" value="2019" min="1800" max="5000" name="year" required>
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