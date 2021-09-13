<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::sellerdashboard</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/myproductall.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="title">
					<label>MY PRODUCTS</label>
				</div>
				<div id="bred_">
					<a href="seller.do" class="seller_process_viewers" id="seller_home_top">
						Seller Home
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<a href="seller_dashboard.do?seller_id=${seller.sellerId}&seller_name=${seller.sellerAccountName}" class="seller_process_viewers" id="seller_home_top">
						${seller.sellerAccountName}
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<span id="seller_dashboard_current_page"  class="seller_process_viewers">
						MY PRODUCTS
					</span>
				</div>
				<input type="hidden" id="sel_id" value="${seller.sellerId}">
				<div id="box">
					<!--<div>
						<img src="static/images/close.png" id="close">
					</div>-->
					<div class="view_blocks" id="block1">
						<div id="not_found">NO PRODUCT FOUND....!</div>
					</div>
				</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/seller_dashboard.js"></script>
	</body>
</html>