<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Processing Payment Delete...</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
		<h1 style="text-align: center">Processing Payment Delete...</h1>
		<% Payments pay = new Payments();
			Thread.sleep(5000);
			if (pay.deletePayment(Integer.parseInt(request.getParameter("delPayID"))))
				response.sendRedirect("procPaySucc.html");
			else response.sendRedirect("procPayFail.html");
		%>
    </body>
</html>
