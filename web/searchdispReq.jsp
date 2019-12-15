<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList, ccinfom.entities.*, java.sql.*, java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search and Display a Request</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
		<h1 style="text-align: center">Processing Update Request...</h1>
		<% Requests reqReport = new Requests();
			reqReport.getAllRequests();
		%>
		<h3 class="col-sm-offset-1">Select Request...</h3>
        <div class="container">
			<form class="form-horizontal" action="procDispReq.jsp" method="POST">
				<div class="form-group">
					<label class="control-label col-sm-2" for="dispReqNo">Select Request Number:</label>
					<div class="col-sm-10">
						<select class="form-control" name="dispReqNo">
							<%	int index, size = reqReport.getReqList().size();
								for (index = 0; index < size; index++) { %>
									<option value="<%=reqReport.getReqList().get(index)%>"> <%=reqReport.getReqList().get(index)%></option>
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
