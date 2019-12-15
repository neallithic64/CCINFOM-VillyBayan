<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Updating Request</title>
    </head>
    <body>
		<% Requests rq = new Requests();
			rq.getAllResidents();
			rq.getAllGroupIDs();
			rq.getAllSlotIDs();
		%>
		<h3 class="col-sm-offset-1">Update Request...</h3>
        <div class="container">
			<form class="form-horizontal" action="procUpdReq.jsp" method="POST">
				<div class="form-group">
					
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
