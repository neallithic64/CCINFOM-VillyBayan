<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "CCINFOM.*, java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing User Registration</title>
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
            if (emp.status==1)
                redirectURL = "http://localhost:8084/myccinfom/newusersuccess.html";
            else
                redirectURL = "http://localhost:8084/myccinfom/newuserfail.html";
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>
