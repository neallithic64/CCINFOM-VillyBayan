<%-- 
    Document   : loginauth
    Created on : Dec 2, 2019, 12:03:24 AM
    Author     : Neal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "ccinfom.entities.*, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging you in...</title>
    </head>
    <body>
		<%
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
		%>
    </body>
</html>
