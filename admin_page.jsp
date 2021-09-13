
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::admin</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/admin_page.css">
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
				<div>
					<div id="left_part">
						<div id="admin_img_box">
							<img src="static/images/user_profile.png" ><br>
							<span>Prezzie legecy Admin</span>
						</div>
						<div id="select_box">
							<div class="selected select_box_elements">USERS</div>
							<div class="select_box_elements">SELLERS</div>
							<div class="select_box_elements">PRODUCTS</div>
							<div class="select_box_elements">ORDERS</div>
							<div class="select_box_elements">REPORTS</div>
						</div>
					</div>
					<div id="right_part">
						<div class="boxes_">
							<a href="admin_all_user.do" class="dashboard_details" id="box_1">
								<span class="total_count">${fn:length(all_users_count)}</span>
								<span class="fa fa-users fa-2x imgs"></span>
								<br>
								<span class="norm_">REGISTERED USERS</span>
							</a>
							<a href="" class="dashboard_details">
								<span class="total_count">10</span>
								<span class="fa fa-user-times fa-2x imgs"></span>
								<br>
								<span class="norm_">BLOCKED USERS</span>
							</a>
							<a href=""  class="dashboard_details">
								<span class="total_count">55</span>
								<span class="fa fa-user-plus fa-2x imgs"></span>
								<br>
								<span class="norm_">ACTIVED USERS</span>
							</a>
							<a href=""  class="dashboard_details">
								<span class="total_count">55</span>
								<span class="fa fa-commenting fa-2x imgs"></span>
								<br>
								<span class="norm_">NEW MESSAGES</span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>