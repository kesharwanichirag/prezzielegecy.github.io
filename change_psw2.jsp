<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::change Password</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/change.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<% String error = (String)request.getAttribute("error");%>
				<div id="error_message"
				style='display:<%= error==null?"none":"block"%>'>
					<%= error %>
				</div>
			
				<div id="title">
					<label>CHANGE PASSWORD</label>
				</div>
				<form action="change_psw.do" method="post" id="loginform">
					<table align="center" >
						<tr>
							<td>
								<img src="static/images/psw.png" class="labels">
							</td>
							<td>
								<input type="password" placeholder="New Password" class="fields" name="new_psw">
							</td>
						</tr>
						<tr>
							<td>
								<img src="static/images/psw.png" class="labels">
							</td>
							<td>
								<input type="password" placeholder="Re-Enter New Password" class="fields" name="re_new_psw">
							</td>
						</tr>
					</table>
					<input type="submit" value="Submit" id="button"><br><br><br><br>
				</form>
				
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>