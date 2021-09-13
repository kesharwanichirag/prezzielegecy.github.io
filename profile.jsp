<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::profile</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/profile.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			
			<div id="main_body">
				<div id="profile_menu_box">
					<a href="profile.do" class="user_profile_menu  fa fa-user-o fa-4x"></a>
					<a href="address.do" class="user_profile_menu fa fa-address-card-o fa-4x"></a>
					<a href="profile_pic.do" class="user_profile_menu fa fa-picture-o fa-4x" ></a>
				</div>
				<div id="title">
					<label>PROFILE</label>
				</div>
				<% String error = (String)request.getAttribute("error"); %>
				<div id="error_message"
				style='display:<%= error==null?"none":"block"%>'>
					<%= error %>
				</div>
				<div id="user_box">
					<div id="img_box">
						<img src="save_profilepic.do" id="user_img">
					</div>
					
					<div id="dtls_box">
						<span id="user_name">${user.userName}</span><br>
						<span id="user_eml">${user.email}</span>
					</div>
				</div>	
				<br><br>
				<form action="profile.do" method="post" id="form"> 
					<table align="center" id="table">
						<tr>
							<td>
								<label for="firstname">
									<img src="static/images/user.png" class="user_image">
								</label>
							</td>
							<td>
								<input type="text" name="firstname" id="firstname" placeholder="First Name" class="fields" maxlength="30" minlength="6" value="${user.firstName}"> 
							</td>
						</tr>
						
						<tr>
							<td>
								<label for="middlename">
									<img src="static/images/user.png" class="user_image">
								</label>
							</td>
							<td>
								<input type="text" name="middlename" placeholder="Middle Name" class="fields" id="middlename" value="${user.middleName}">
							</td>
						</tr>
						<tr>
							<td>
								<label for="lastname">
									<img src="static/images/user.png" class="user_image">
								</label>
							</td>
							<td>
								<input type="text" name="lastname" placeholder="Last Name" class="fields" id="lastname" value="${user.lastName}">
							</td>
						</tr>
						<tr>
							<td>
								<label for="mobile">
									<img src="static/images/mobile.jpg" id="mobile_image">
								</label>
							</td>
							<td>
								<input type="text" name="mobile" placeholder="Enter mobile" class="fields" id="mobile" maxlength="10" minlength="10"
								 value="${user.mobile}">
							</td>
						</tr>
						
					</table>
					<br>
					<!--<div id="otp_box">
						<div>
							<input type="text" name="otp" id="otp"  placeholder="enter 5 digits OTP">
							<button id="otp_button">VERIFY</button>
						</div>
					</div>-->
					<br>
					<input type="submit" value="Save" id="button">
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
									WE HAVE SEND YOU AN (ONE TIME PASSWORD) OTP ON ENTERED NUMBER
								</h5>
								<br>
								<input type="password" name="otp" id="otp" maxlength="5" minlength="5" placeholder="OTP">
								
								<input type="submit" value="VERIFY" id="otp_button"><br><br>

								<span href="" id="resend_otp">RESEND OTP</span>
							</div>
						</div>
					</div>
				</form>
			</div>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/profile.js"></script>
		<script src="static/js/menu.js"></script>
	</body>
</html>
