<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::admin</title>
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
				<div id="title">
					<label>ADMIN LOGIN</label>
				</div>
				<form action="admin_login.do" method="post" id="loginform">
					<table align="center" >
						<tr>
							<td>
								<img src="static/images/user.png" class="labels">
							</td>
							<td>
								<input type="text" placeholder="ENTER KEY" class="fields" name="key" autocomplete="off" >
							</td>
						</tr>
						<tr>
							<td>
								<img src="static/images/psw.png" class="labels">
							</td>
							<td>
								<input type="password" placeholder="ENTER PIN" class="fields" name="pin">
							</td>
						</tr>
					</table>
					<input type="submit" value="LOGIN ADMIN" id="button"><br>
				</form>
			</div>
			<br><br><br><br><br><br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>