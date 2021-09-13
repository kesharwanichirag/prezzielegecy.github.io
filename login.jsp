<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::login</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/login.css">
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
					<label>LOGIN</label>
				</div>
				<form action="login.do" method="post" id="loginform">
					<table align="center" >
						<tr>
							<td>
								<img src="static/images/user.png" class="labels">
							</td>
							<td>
								<input type="text" placeholder="Enter UserName/Email" class="fields" name="username_email">
							</td>
						</tr>
						<tr>
							<td>
								<img src="static/images/psw.png" class="labels">
							</td>
							<td>
								<input type="password" placeholder="Enter Password" class="fields" name="password">
							</td>
						</tr>
					</table>
					<div class="g-recaptcha" data-sitekey="6LfostcZAAAAACMAdfJv1x-g0bnfL6j4jDH6LIRk" id="re_captcha">
					</div>
					<input type="submit" value="login" id="button"><br>
					<a href="forgot.do" id="forgot_password">forgot password ?</a>
				</form>
				<a href="#" id="login_facebook" class="login_options">
					Login with	Facebook
				</a>
				<a href="#" id="login_gmail" class="login_options">
					Login with Gmail
				</a>
				<br>
				<a href="register.do" id="create_new_account">
					Create New Account
				</a>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>