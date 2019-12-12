<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "CCINFOM.*, java.util.*" %>
<html>
	<head>
		<title>Processing User Registration</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%  // Capture the data sent from the form
			String v_username       = request.getParameter("username");
			String v_password       = request.getParameter("password");
			String v_completename   = request.getParameter("completename");
			int v_currentpoints     = Integer.parseInt(request.getParameter("currpoints"));
			
			// Instantiate the class that will process the registration
			employee emp = new employee();
			emp.completename  = v_completename;
			emp.username      = v_username;
			emp.password      = v_password;
			emp.currentpoints = v_currentpoints;
			emp.register();
			
			// Redirect to the correct message page
			String redirectURL;
			if (emp.status == 1)
				redirectURL = "usRegSuccess.html";
			else redirectURL = "usRegFail.html";
			response.sendRedirect(redirectURL);
		%>
	</body>
</html>
