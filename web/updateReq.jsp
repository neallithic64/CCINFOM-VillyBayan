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
		<% Requests reqReport = new Requests();
			reqReport.getAllResidents();
			reqReport.getAllGroupIDs();
			reqReport.getAllSlotIDs();
			reqReport.getAllRequests();
		%>
		<h3 class="col-sm-offset-1">Update Request...</h3>
        <div class="container">
			<form class="form-horizontal" action="procUpdReq.jsp" method="POST">
				<div class="form-group">
					<label class="control-label col-sm-2" for="upReq_no">Select Request Number:</label>
					<div class="col-sm-10">
						<select class="form-control" name="upReq_no">
							<%	int index, size = reqReport.getReqList().size();
								for (index = 0; index < size; index++) { %>
									<option value="<%=reqReport.getReqList().get(index)%>"> <%=reqReport.getReqList().get(index)%></option>
							<%	}
							%>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="date_create">Date Created:</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="date_create" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="date_proc">Date Processed:</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="date_proc" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="status">Status:</label>
					<div class="col-sm-10">
						<select class="form-control" name="status">
							<option value="S">Saved</option>
							<option value="D">Deleted</option>
							<option value="C">Confirmed</option>
							<option value="X">Cancelled</option>
							<option value="P">Pending</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="homeserv">Home Service:</label>
					<div class="col-sm-10">
						<select class="form-control" name="homeserv">
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="spec_inst">Special Instructions:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Special instructions" name="spec_inst" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="canc_fee">Cancellation Fee:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" placeholder="Cancellation fee" name="canc_fee" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="canc_reas">Cancellation Reason:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Cancellation reason" name="canc_reas" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="tot_amt">Total Amount:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" placeholder="Total amount" name="tot_amt" required>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="resi_email">Email:</label>
					<div class="col-sm-10">
						<select class="form-control" name="resi_email">
							<%	size = reqReport.getResiList().size();
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
