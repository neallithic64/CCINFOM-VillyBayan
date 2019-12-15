<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Top Services Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
    <body>
    <% Reporter rp = new Reporter();
        rp.report4(Integer.parseInt(request.getParameter("year")), request.getParameter("supplier_email"));
        int i, reportSize = rp.overallList.size();
		Reqratings ratingReport = new Reqratings();
		ratingReport.getAllSuppliers();
    %>
    <div class="container">
            <h1 style="text-align: center">Monthly Rating</h1>
            <table class="table">
                <thead><tr>
                    <th scope="col"></th>
                    <th scope="col">Overall</th>
                    <th scope="col">Service</th>
                    <th scope="col">Value</th>
                    <th scope="col">Timeliness</th>
                    <th scope="col">Politeness</th>

                </tr></thead>
                <tbody>
                <% for (i = 0; i < reportSize; i++) { %>
                <tr>
                    <th scope="row"><%=i+1%></th>
                    <td><%=rp.overallList.get(i)%></td>
                    <td><%=rp.servicesList.get(i)%></td>
                    <td><%=rp.valueList.get(i)%></td>
                    <td><%=rp.timelinessList.get(i)%></td>
                    <td><%=rp.politenessList.get(i)%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <form class="form-horizontal" action="procReportYearRate.jsp" method="POST">
                <div class="form-row">
                    <div class="col-sm-2">
                        <label class="control-label" for="supplier_email">Supplier Email: </label>
                    </div>
                    <div class="col-sm-3">
                        <select class="form-control" name="supplier_email">
                            <%	int index, size = ratingReport.getSuppList().size();
                                for (index = 0; index < size; index++) { %>
                            <option value="<%=ratingReport.getSuppList().get(index)%>"> <%=ratingReport.getSuppList().get(index)%></option>
                            <%	}
                            %>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <label class="control-label" for="year">Year: </label>
                    </div>
                    <div class="col-sm-3">
                        <input type="number" class="form-control" value="2019" min="1800" max="5000" name="year" required>
                    </div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
            <br>
        </div>
        <button type="button" onclick="window.location.href = 'index.html';" class="btn btn-default">Return to Home</button>
    </body>
</html>
