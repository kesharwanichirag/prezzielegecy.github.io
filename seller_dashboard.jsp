<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::sellerdashboard</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/seller_dashboard.css">
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
					<label>SELLER DASHBOARD</label>
				</div>
				<div id="bred_">
					<a href="seller.do" class="seller_process_viewers" id="seller_home_top">
						Seller Home
					</a>
					<span class="seller_process_viewers">
						&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
					</span>
					<span  class="seller_process_viewers" id="seller_dashboard_current_page">
						${seller.sellerAccountName}
					</span>
				</div>					
				<input type="hidden" id="sel_id" value="${seller.sellerId}">
				<div id="seller_dashboard_details_box">
					<div class="seller_dashboard_details">
						<a href="new_product.do" class="seller_oths ">
							<img src="static/images/seller/add new.ico" class="imgs_">
							<br><br>
							ADD NEW PRODUCT
						</a>
					</div>
					<div class="seller_dashboard_details">
						<a href="my_products.do?seller_id=${seller.sellerId}&seller_name=${seller.sellerAccountName}" class="seller_oths ">
							<img src="static/images/seller/prod.png" class="imgs_">
							<br><br>
							My PRODUCTS
						</a>
					</div>
					<div class="seller_dashboard_details">
						<a href="" class="seller_oths">
							<img src="static/images/seller/deli.png" class="imgs_">
							<br><br>
							DELIVERED PRODUCTS
						</a>
					</div>
					<div class="seller_dashboard_details">
						<a href="" class="seller_oths">
							<img src="static/images/seller/ord.png" class="imgs_">
							<br><br>
							MY ORDERS
						</a>
						
					</div>
					<div class="seller_dashboard_details">
						<a href="" class="seller_oths">
							<img src="static/images/seller/ret.png" class="imgs_">
							<br><br>
							RETURNING REQUEST
						</a>
					</div>
				</div>
			<br>
			<br>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/seller_dashboard.js"></script>
	</body>
</html>