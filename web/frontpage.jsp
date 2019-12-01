<%-- 
    Document   : frontpage
    Created on : Nov 28, 2019, 2:08:47 PM
    Author     : Neal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "ccinfom.entities.*, java.util.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome!</title>
	</head>
	<body>
		<%  // Capture the data sent from the form
			String first			= request.getParameter("firstname");
			String last				= request.getParameter("lastname");
//			String v_completename	= request.getParameter("completename");
//			int v_currentpoints		= Integer.parseInt(request.getParameter("currpoints"));
			
			// Instantiate the class that will process the registration
			User usr = new User(first, last);
			usr.register();
			
			// Redirect to the correct message page
			String redirectURL;
			if (usr.status == 1)
				redirectURL = "http://localhost:8084/myccinfom/newusersuccess.html";
			else redirectURL = "http://localhost:8084/myccinfom/newuserfail.html";
			response.sendRedirect(redirectURL);
		%>
		<h1>Hello World!</h1>
	</body>
</html>
