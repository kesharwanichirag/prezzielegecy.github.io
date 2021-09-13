<!doctype html>
<html>
	<head>
		<title>setting</title>
		<link rel="stylesheet" type="text/css" href="static/css/setting.css">
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
	<div id="container_body">
		<%@ include file="header.jsp"%>
		<%@ include file="menu.jsp"%>
		<div id="main_body">
			<div id="settings">	
				SETTINGS
			</div>
			<div id="box_">
				<div class="_divs">
					<a href="ac_settings.do">
						<span class="imgs_">
							<img src="static/images/settings/acc.jfif" class="icon">
						</span>	
						<span class="labels__">
							ACCOUNT SETTINGS
						</span>
						<span class="ext_lbs">
							Security & Privacy
						</span>
					</a>
				</div>
				<div class="_divs">
					<a href="show_all_address.do">
						<span class="imgs_">
							<img src="static/images/settings/add.png" id="add" class="icon">
						</span>	
						<span class="labels__">
							YOUR ADDRESSES
						</span>
						<span class="ext_lbs">
							View Addresses
						</span>
					</a>
				</div>
				<div class="_divs">
					<a href="">
						<span class="imgs_">
							<img src="static/images/settings/ord.png" id="ord" class="icon">
						</span>	
						<span class="labels__">
							YOUR ALL ORDERS
						</span>
						<span class="ext_lbs">
							Your Ordered<br>Products
						</span>
					</a>
				</div>
				<br>
				<div class="_divs">
					<a href="">
						<span class="imgs_">
							<img src="static/images/settings/pay.png" class="icon">
						</span>	
						<span class="labels__">PAYMENT SETTINGS</span>
						<span class="ext_lbs">
							Edit Your Payment
							<br>
							Details
						</span>
					</a>
				</div>
				<div class="_divs">
					<!--<a href="">
						<span class="imgs_">
							<img src="static/images/settings/rep.png" class="icon">
						</span>	
						<span class="labels__">ACCOUNT REPORT</span>
						<span class="ext_lbs">
							Your Account Full<br>Report
						</span>
					</a>-->
				</div>
				<div class="_divs">
					
				</div>
			</div>
			<br>
			<br>
		</div>
		<%@ include file="footer.jsp"%>
		<%@ include file="footer_copy_right.jsp"%>
	</div>
	<script src="static/js/menu.js"></script>
	<script src="static/js/setting.js"></script>
	</body>
</html>