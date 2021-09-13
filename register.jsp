
<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::register</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/register.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
		
			<div id="main_body">
				<% String error = (String)request.getAttribute("error"); %>
				<div id="error_message"
				style='display:<%= error==null?"none":"block"%>'>
					<%= error %>
				</div>
			
				<div id="title">
					<label>REGISTER/SIGNUP</label>
				</div>
				<form action="register.do" method="post" id="form">
					<table align="center">
						<tr>
							<td>
								<label for="username">
									<img src="static/images/user.png" class="labels">
								</label>
							</td>
							<td>
								<input type="text" name="username" id="username" placeholder="Enter UserName" class="fields" maxlength="30" minlength="6"> 
							</td>
						</tr>
						<tr>
							<td>
								<label for="email">
									<img src="static/images/email.png" class="labels" id="email_image">
								</label>
							</td>
							<td>
								<input type="email" name="email" placeholder="Enter Email" class="fields" id="email">
							</td>
						</tr>
						<!--<tr>
							<td>
								<label for="mobile">
									<img src="static/images/mobile.jpg" class="labels" id="mobile_image">
								</label>
							</td>
							<td>
								<input type="text" name="mobile" placeholder="Enter mobile" class="fields" id="mobile" maxlength="10" minlength="10">
							</td>
						</tr>-->
						<tr>
							<td>
								<label for="password">
									<img src="static/images/psw.png" class="labels"/>
								</label>
							</td>
							<td>
								<input type="password" class="fields" id="password" placeholder="Enter Password" name="password">
							</td>
						</tr>
						<tr>
							<td>
								<label for="repassword">
									<img src="static/images/psw.png" class="labels">
								</label>
							</td>
							<td>
								<input type="password" name="repassword" id="repassword" name="repassword" class="fields" placeholder="Re Enter Password">
							</td>
						</tr>
					</table>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="g-recaptcha" data-sitekey="6LfostcZAAAAACMAdfJv1x-g0bnfL6j4jDH6LIRk" id="re_captcha">
					</div>
					<input type="submit" value="Register" id="button">
				</form>
				<!----------------------------------------------->
				<br>
			</div>	
			<br><br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/register.js"></script>
		<script src="static/js/menu.js"></script>
	</body>
</html>