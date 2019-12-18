<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<!-- Columns:
payment_id			int(8) 			PK
payment_date        date
payment_time		time
amount		        decimal(9,2)
status				enum('P','U')
resident_email      varchar(100) 	FK
request_no			int(8) 			FK
-->

<html>
<head>
    <title>Create Payment</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
    <body>
    <% Payments paymentReport = new Payments();
        paymentReport.getAllResidents();
		paymentReport.getAllRequests();
    %>
        <h3 class="col-sm-offset-1">Create Payment...</h3>
        <div class="container">
            <form class="form-horizontal" action="procNewPayment.jsp" method="POST">
                
				<div class="form-group">
						<label class="control-label col-sm-2" for="resident_email">Email:</label>
						<div class="col-sm-10">
							<select class="form-control" name="resident_email">
								<%	int index, size = paymentReport.getResiList().size();
									for (index = 0; index < size; index++) { %>
										<option value="<%=paymentReport.getResiList().get(index)%>"> <%=paymentReport.getResiList().get(index)%></option>
								<%	}
								%>
							</select>
						</div>
					</div>
					
					<div class="form-group">
                    <label class="control-label col-sm-2" for="req_no">Request Number:</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="req_no">
                            <%	size = paymentReport.getReqList().size();
                                for (index = 0; index < size; index++) { %>
                            <option value="<%=paymentReport.getReqList().get(index)%>"> <%=paymentReport.getReqList().get(index)%></option>
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