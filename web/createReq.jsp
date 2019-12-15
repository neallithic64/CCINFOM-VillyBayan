<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, ccinfom.entities.*" %>

<html>
	<head>
		<title>Creating Request</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<% Requests reqReport = new Requests();
			reqReport.getAllResidents();
			reqReport.getAllGroupIDs();
			reqReport.getAllSlotIDs();
		%>
		
		<h3 class="col-sm-offset-1">Create Request...</h3>
			<div class="container">
				<form class="form-horizontal" action="procNewReq.jsp" method="POST">
					<div class="form-group">
						<label class="control-label col-sm-2" for="spec_inst">Special Instructions:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Special instructions" name="spec_inst" required>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="resi_email">Email:</label>
						<div class="col-sm-10">
							<select class="form-control" name="resi_email">
								<%	int index, size = reqReport.getResiList().size();
									for (index = 0; index < size; index++) { %>
										<option value="<%=reqReport.getResiList().get(index)%>"> <%=reqReport.getResiList().get(index)%></option>
								<%	}
								%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="group_id">Group ID</label>
						<div class="col-sm-10">
							<select class="form-control" name="group_id">
								<%	size = reqReport.getGroupList().size();
									for (index = 0; index < size; index++) { %>
										<option value="<%=reqReport.getGroupList().get(index)%>"> <%=reqReport.getGroupList().get(index)%></option>
								<%	}
								%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="slot_id">Slot ID</label>
						<div class="col-sm-10">
							<select class="form-control" name="slot_id">
								<%	size = reqReport.getSlotList().size();
									for (index = 0; index < size; index++) { %>
										<option value="<%=reqReport.getSlotList().get(index)%>"> <%=reqReport.getSlotList().get(index)%></option>
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
