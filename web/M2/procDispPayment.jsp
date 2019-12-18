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
        <h1 class="jumbotron" style="text-align: center">Displaying Payment...</h1>
		<% Payments pay = new Payments();
			pay.getPaymentData(Integer.parseInt(request.getParameter("dispPaymentId")));
		%>
		<p class="container"><%= pay.toString() %></p>
    </body>
</html>