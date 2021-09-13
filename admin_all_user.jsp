<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::sellerdashboard</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/admin_user.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="_heading_">ALL USERS IN YOUR SHOP</div>
				<div id="bred_">
					<a href="admin_page.do" class="seller_process_viewers" id="seller_home_top">
						Admin Dashboard
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<a href="" class="seller_process_viewers" id="seller_home_top">
						${seller.sellerAccountName}
					</a>
					<span id="seller_dashboard_current_page"  class="seller_process_viewers">
						ALL REGISTERATIONS
					</span>
				</div>
				<c:forEach var="users" items="${all_users}">
					<div class="all_users">
						<div class="right_view">
							<input type="hidden" value="${users.userId}" name="user_id">
							<a href="admin_user_view.do?user_id=${users.userId}" class="usernames"  value="${users.userId}">${users.userName}</a><br>
							<span class="emails">${users.email}</span>
							<span class="mobiles">Mobile:${users.mobile}</span><br>
							&nbsp;&nbsp;&nbsp;&nbsp;<span>Status:${users.status.statusId}</span>
							<!-- <a href="" class="block_user">Block User?</a> -->
						</div>
					</div>
				</c:forEach>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>