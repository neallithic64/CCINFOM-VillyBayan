<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Monthly Rating Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
    <body>
    <% Reqratings ratingReport = new Reqratings();
        ratingReport.getAllSuppliers();
    %>
        <h1 style="text-align: center">Processing submission...</h1>
        <div class="container">
            <form class="form-horizontal" action="procReportYearRate.jsp" method="POST">

                <div class="form-group">
                    <label class="control-label col-sm-2" for="supplier_email">Supplier Email:</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="supplier_email">
                            <%	int index, size = ratingReport.getReqList().size();
                            for (index = 0; index < size; index++) { %>
                            <option value="<%=ratingReport.getSuppList().get(index)%>"> <%=ratingReport.getSuppList().get(index)%></option>
                            <%	}
                            %>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="year">Year: </label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" value="2019" min="1800" max="5000" name="year" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
