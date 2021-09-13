<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::account</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/account_settings.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="title">
					<label>ACCOUNT SETTINGS</label>
				</div>
				<% String msg = (String)request.getAttribute("msg_");%>
				<div id="message_"
				style='display:<%= msg=="your password has successfully changed"?"block":"none"%>'>
					<%= msg %>
				</div>
				<div id="bred_">
					<a href="settings.do" class="seller_process_viewers" id="seller_home_top">
						Settings
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<span  class="seller_process_viewers" id="seller_dashboard_current_page">
						Account Settings
					</span>
				</div>					
				<div id="seller_dashboard_details_box">
					<div class="seller_dashboard_details">
						<a href="check_psw.do" class="seller_oths ">
							<img src="static/images/settings/c_psw.png" class="imgs_">
							<br><br>
							CHANGE PASSWORD
						</a>
					</div>
					<div class="seller_dashboard_details">
						<a href="check_password_email.do" class="seller_oths ">
							<img src="static/images/settings/eml.png" class="imgs_">
							<br><br>
							CHANGE EMAIL
						</a>
					</div>
					<div class="seller_dashboard_details">
						<a href="change_username.do" class="seller_oths">
							<img src="static/images/settings/user.png" class="imgs_">
							<br><br>
							CHANGE USERNAME
						</a>
					</div>
				</div>
			</div>
			<br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/seller_dashboard.js"></script>
	</body>
</html>