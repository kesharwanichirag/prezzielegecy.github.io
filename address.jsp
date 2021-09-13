<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::address</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/address.css">
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
					<label>MAIN ADDRESS</label>
				</div>
				<br><br>
				<form action="address.do" method="post" id="address_form"> 
					<label for="city" class="other_labels">CITY</label><br>
					
					<input type="hidden" name="city_id" id="city_id" value=""> 
					
					<input type="text" name="city" placeholder="City" class="fields" id="city" value="${address.city.city}" autocomplete="off">
					
					<div id="srch_res">
					</div>
					<br><br>
					
					<label for="pin" class="other_labels">PIN-CODE</label><br>
					<input type="text" name="pin" placeholder="Pin-code" class="fields" id="pin" value="${address.pin}">
					<br><br
					
					<label for="address" class="other_labels">ADDRESS</label><br>
					<textarea type="text" name="address" placeholder="Address" class="fields" id="address" cols="30" rows="20">${address.address}</textarea>
					<br><br>
					
					<!-- <a href="profile.do" id="back">BACK</a> -->
					<input type="submit" value="Save" id="button">
				</form>
			</div>
			<%@ include file="footer_copy_right.jsp"%>
			
		</div>
		<script src="static/js/address.js"></script>
		<script src="static/js/menu.js"></script>
	</body>
</html>
