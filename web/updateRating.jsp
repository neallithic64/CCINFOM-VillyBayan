<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<!-- Columns:
request_no			int(8) PK, FK
service		        int(2)
value		        int(2)
timeliness		    int(2)
politeness			int(2)
overall         	int(2)
-->

<html>
    <head>
        <title>Update Rating</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
    <% Reqratings ratingReport = new Reqratings();
        ratingReport.getReqNos();
    %>
        <h3 class="col-sm-offset-1">Update Rating...</h3>
        <div class="container">
            <form class="form-horizontal" action="procUpdRate.jsp" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="req_no">Request Number:</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="req_no">
                            <%	int index, size = ratingReport.getReqList().size();
                                for (index = 0; index < size; index++) { %>
                            <option value="<%=ratingReport.getReqList().get(index)%>"> <%=ratingReport.getReqList().get(index)%></option>
                            <%	}
                            %>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="service">Service Rating:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Service Rating" name="service" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="value">Value Rating:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Value Rating" name="value" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="timeliness">Timeliness Rating:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Timeliness Rating" name="timeliness" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="politeness">Politeness Rating:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Politeness Rating" name="politeness" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>

    <p style="background-color: tomato"> <%= ratingReport.overall %> </p>

    </body>
</html>
