<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::check password</title>
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
					<label>CHECK PASSWORD</label>
				</div>
				<% String msg = (String)request.getAttribute("psw_");%>
				<div id="error_message"
				style='display:<%= msg==null?"none":"block"%>'>
					<%= msg %>
				</div>
				<div id="bred_">
					<a href="settings.do" class="seller_process_viewers" id="seller_home_top">
						Settings
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<a href="" class="seller_process_viewers" id="seller_home_top">
						Account Settings
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<span class="seller_process_viewers" id="seller_dashboard_current_page">
						Check Password
					</span>
				</div>
				<form action="check_password_email.do" method="post" id="loginform">
					<div id="user_box">
						<div id="img_box">
							<img src="save_profilepic.do" id="user_img">
						</div>
						<div id="dtls_box">
							<span id="user_name">${user.userName}</span><br>
							<span id="user_eml">${user.email}</span>
						</div>
					</div>
					<table align="center" >
						<tr>
							<td>
								<img src="static/images/psw.png" class="labels">
							</td>
							<td>
								<input type="password" placeholder="Current Password" class="fields" name="password">
							</td>
						</tr>
					</table>
					<input type="submit" value="Continue" id="button"><br><br><br><br>
				</form>
				
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>