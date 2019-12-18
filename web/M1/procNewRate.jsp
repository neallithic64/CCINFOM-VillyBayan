<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "ccinfom.entities.*, java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Your Request...</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% Reqratings newRate = new Reqratings();
            newRate.req_no = Integer.parseInt(request.getParameter("req_no"));
        %>
        <p style="background-color: tomato"> <%= newRate.req_no %> </p>
        <%
            newRate.service = Integer.parseInt(request.getParameter("service"));
            newRate.value = Integer.parseInt(request.getParameter("value"));
            newRate.timeliness = Integer.parseInt(request.getParameter("timeliness"));
            newRate.politeness = Integer.parseInt(request.getParameter("politeness"));

            if (newRate.newRating())
                response.sendRedirect("procRateSucc.html");
            else response.sendRedirect("procRateFail.html");
        %>

    </body>
</html>
