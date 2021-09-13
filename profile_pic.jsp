<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::profile_pic</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/profile_pic.css">
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
					<label>PROFILE PIC</label>
				</div>
				<% String error = (String)request.getAttribute("error"); %>
				<div id="error_message"
				style='display:<%= error==null?"none":"block"%>'>
					<%= error %>
				</div>				
				<form action="profile_pic.do" method="post" enctype="multipart/form-data"> 
					<img src="save_profilepic.do" id="profile_pic"><br><br>
					<input type="file" id="profile_pic_upload" name="profilepic">
					<br>
					<span id="remove_profile">
						Remove Profile Pic
					</span>
					<br>
					<input type="submit" value="Save" id="button">
				</form>
				<div id="alert_box">
					<div id="alert">
						<label>ARE YOU REALLY WANT TO REMOVE YOUR PROFILE PIC</label>
						<br><br>
						<a href="remove_profile_pic.do" id="yes">YES</a>
						<span id="no">NO</span>
					</div>
				</div>
			</div>
			<div id="img_click_view">
				<div>
					<img src="static/images/close.png" id="close">
					<img src="save_profilepic.do" id="show_profile_pic">
				</div>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/profile_pic.js"></script>
		<script src="static/js/menu.js"></script>
	</body>
</html>
