<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Rating Display...</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 class="jumbotron" style="text-align: center">Displaying Request...</h1>
        <% Reqratings rating = new Reqratings();
            rating.getRateData(Integer.parseInt(request.getParameter("req_no")));
        %>
        <table class="table">
			<tbody>
				<tr>
					<th scope="row">Request Number</th>
					<td><%= rating.req_no %></td>
				</tr>
				<tr>
					<th scope="row">Service</th>
					<td><%= rating.service %></td>
				</tr>
				<tr>
					<th scope="row">Value</th>
					<td><%= rating.value %></td>
				</tr>
				<tr>
					<th scope="row">Politeness</th>
					<td><%= rating.politeness %></td>
				</tr>
				<tr>
					<th scope="row">Timeliness</th>
					<td><%= rating.timeliness %></td>
				</tr>
				<tr>
					<th scope="row">Overall</th>
					<td><%= rating.overall %></td>
				</tr>
			</tbody>
		</table>
    </body>
</html>