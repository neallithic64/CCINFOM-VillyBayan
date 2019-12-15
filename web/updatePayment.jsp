<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Updating Payment</title>
    </head>
    <body>
		<% Payments paymentReport = new Payments();
			paymentReport.getAllPayments();
			paymentReport.getAllRequests();
			paymentReport.getAllResidents();
		%>
		<h3 class="col-sm-offset-1">Update Payment...</h3>
        <div class="container">
			<form class="form-horizontal" action="procUpdPayment.jsp" method="POST">
				<div class="form-group">
					<label class="control-label col-sm-2" for="upPayment_id">Select Payment Id:</label>
					<div class="col-sm-10">
						<select class="form-control" name="upPayment_id">
							<%	int index, size = paymentReport.getPaymentList().size();
								for (index = 0; index < size; index++) { %>
									<option value="<%=paymentReport.getPaymentList().get(index)%>"> <%=paymentReport.getPaymentList().get(index)%></option>
							<%	}
							%>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="payment_date">Payment date:</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="payment_date" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="payment_time">Payment time:</label>
					<div class="col-sm-10">
						<input type="time" class="form-control" name="payment_time" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="amount">Amount:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" placeholder="Amount" name="amount" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="status">Status:</label>
					<div class="col-sm-10">
						<select class="form-control" name="status">
							<option value="P">Paid</option>
							<option value="U">Unpaid</option>
					</div>
				</div>			
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="resident_email">Email:</label>
					<div class="col-sm-10">
						<select class="form-control" name="resident_email">
							<%	size = paymentReport.getResiList().size();
								for (index = 0; index < size; index++) { %>
									<option value="<%=paymentReport.getResiList().get(index)%>"> <%=paymentReport.getResiList().get(index)%></option>
							<%	}
							%>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="req_no">Request number:</label>
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