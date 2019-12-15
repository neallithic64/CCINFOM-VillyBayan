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
        <% Reqratings updRate = new Reqratings();
            updRate.req_no = Integer.parseInt(request.getParameter("req_no"));
        %>
        <p style="background-color: tomato"> <%= updRate.req_no %> </p>
        <%
            updRate.service = Integer.parseInt(request.getParameter("service"));
            updRate.value = Integer.parseInt(request.getParameter("value"));
            updRate.timeliness = Integer.parseInt(request.getParameter("timeliness"));
            updRate.politeness = Integer.parseInt(request.getParameter("politeness"));

            if (updRate.updateRating(updRate.req_no))
                response.sendRedirect("procRateSucc.html");
            else response.sendRedirect("procRateFail.html");
        %>

    </body>
</html>
