<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::alladdress</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/all_addresses.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="text_lbl">
					Your All Addresses
				</div>
				<div id="label_box_add">
					you can add address while shopping anything this is a addresses entered by you
				</div>
				<c:forEach var="address" items="${addresses_}"				varStatus="sq">
					<div class="addr_">
						<div class="add_num">
							Address ${sq.count}
						</div>
						<span class="rcv_name">
							Reciever Name:
						</span>
						<span class="_name_">
							${address.name}
						</span>
						
						<br>
						<span class="address_label">
							Address:
						</span>
						<span class="address__">
							${address.address}
						</span>
						<br>
						<span class="address_det">
							State:
						</span>
						<span class="_name_">
						
						</span>
						<span class="address_det">
							City:
						</span>
						<span class="_name_">
							${address.city.city}
						</span>
						<span class="address_det">
							Pin:
						</span>
						<span class="_name_">
							${address.pin}
						</span>
						<span class="address_det">
							Reciever Mobile:
						</span>
						<span class="_name_">
							${address.recieverMobile}
						</span>
						<br>
						<div>
							<input type="button" value="Delete Address" class="del_btn_">
						</div>
					</div>
				</c:forEach>
			</div>	
			<%@ include file="footer_copy_right.jsp"%>	
		</div>
		<script src="static/js/address.js"></script>
		<script src="static/js/menu.js"></script>
		<script src="static/js/all_addresses.js"></script>
	</body>
</html>
