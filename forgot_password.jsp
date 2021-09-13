<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::forget psw</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/forgot.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
					<label>FORGOT PASSWORD</label>
				</div>
				<form action="forgot.do" method="post" id="_form">
					<table align="center" >
						<tr>
							<td>
								<label for="email">
									<img src="static/images/user.png" class="labels" >
								</label>
							</td>
							<td>
								<input type="text" placeholder="Enter Email" class="fields" name="email" id="email">
							</td>
						</tr>
						<tr>
							<td>
								<label for="password">
									<img src="static/images/psw.png" class="labels" >
								</label>
							</td>
							<td>
								<input type="password" placeholder="Enter New Password" class="fields" name="password" id="password">
							</td>
						</tr>
						<!--<tr>
							<td>
								<label for="re_password">
									<img src="static/images/psw.png" class="labels" >
								</label>
							</td>
							<td>
								<input type="password" placeholder="ReEnter New Password" class="fields" name="re_password" id="re_password">
							</td>
						</tr>-->
						
					</table>
					<input type="submit" value="Change Password" id="button"><br>
					<!------------------------->
					<div id="otp_container">
						<div>
							<img src="static/images/loader.gif" id="loader">
						</div>
						<div id="otp_box">
							<div>
								<img src="static/images/close.png" id="close">
							</div>
							<div id="otp_field_box">
								<h5>
									WE HAVE SEND YOU AN (ONE TIME PASSWORD) OTP ON ENTERED EMAIL
								</h5>
								<br>
								<input type="password" name="otp" id="otp" maxlength="5" minlength="5" placeholder="OTP">
								
								<input type="submit" value="VERIFY" id="otp_button"><br><br>

								<span id="resend_otp">RESEND OTP</span>
							</div>
						</div>
					</div>
				</form>
			</div>
			<a href="" id="forgot_help">Need Any Help?</a>
			<br>
			<br>
			<br>
			<br>
			<br>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/email_otp.js"></script>
	</body>
</html>