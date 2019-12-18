<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting a Payment</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 style="text-align: center">Processing Delete Payment...</h1>
        <% Payments paymentReport = new Payments();
            paymentReport.getAllPayments();
        %>
        <h3 class="col-sm-offset-1">Select Payment...</h3>
        <div class="container">
            <form class="form-horizontal" action="procDelPay.jsp" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="delPaymentId">Select Payment ID:</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="delPaymentId">
                            <%	int index, size = paymentReport.getPaymentList().size();
                                for (index = 0; index < size; index++) { %>
                            <option value="<%=paymentReport.getPaymentList().get(index)%>"> <%=paymentReport.getPaymentList().get(index)%></option>
                            <%	}
                            %>
                        </select>
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
