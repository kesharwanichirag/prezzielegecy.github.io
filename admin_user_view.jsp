<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::admin</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/admin_user_view.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="_heading_">ADMIN USER VIEW</div>
				<div id="bred_">
					<a href="admin_page.do" class="seller_process_viewers" id="seller_home_top">
						Admin Dashboard
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<a href="admin_all_user.do" class="seller_process_viewers" id="seller_home_top">
						ALL REGISTERATIONS
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<span id="seller_dashboard_current_page"  class="seller_process_viewers">
						USER VIEW
					</span>
				</div>
				<div id="user_box">
					<br><br><br>
					<div id="dtls_box">
						<span id="user_name">${users.userName}</span><br>
						<span id="user_eml">${users.email}</span><br>
					</div>
					<br><br>
					<div id="user_details_box">
						<span class="user_details">Mobile :${users.mobile}</span><br>
						<span class="user_details">First Name :${users.firstName}</span><br>
						<span class="user_details">Middle Name :${users.middleName}</span><br>
						<span class="user_details">Last Name :
						${users.lastName}</span><br>
						<span class="user_details">Status :${users.status.statusId}</span>
					</div>
				</div>
				<br>
				<div id="account_changes">
					<span id="unblock_user">
						<span>UNBLOCK USER...?</span>
					</span>
					<span id="block_user">
						<i class="fa fa-ban" aria-hidden="true"></i>
						<span>BLOCK USER...?</span>
					</span>
				</div>
				<br><br>
				<input type="hidden" name="user_id" value="${users_temp.userId}">
				<div id="alert_box">
					<div id="alert">
						<label>ARE YOU REALLY WANT TO BLOCK THIS USER</label>
						<br><br>
						<a href="block_user.do" id="yes">YES</a>
						<span id="no">NO</span>
					</div>
				</div>
				<div id="alert_box2">
					<div id="alert2">
						<label>ARE YOU REALLY WANT TO UNBLOCK THIS USER</label>
						<br><br>
						<a href="unblock_user.do" id="yes2">YES</a>
						<span id="no2">NO</span>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/admin.js"></script>
	</body>
</html>