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
				<div>
					<span id="add_new_add" class="add_btns active">
						My Addresses
					</span>
					<span id="all_add" class="add_btns inactive">
						Add New Address
					</span>
				</div>
				<div id="add_box">
					<div id="label_box_add">
						Choose a Address where You want to deliver Product..
					</div>
					<c:forEach var="address" items="${addresses}"				varStatus="sq">
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
								<input type="button" value="Deliver Now" class="btn_">
								<input type="button" value="Delete Address" class="del_btn_">
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="form_box">
					<div id="title">
						<label>ADD NEW ADDRESS</label>
					</div>
					<form action="all_addresses.do" method="post" id="address_form"> 				
						<label for="city" class="other_labels">NAME</label><br>
						<input type="text" placeholder="Reciever Name" class="fields" autocomplete="off" id="name" name="name"><br>
						<label for="city" class="other_labels">CITY</label><br>
						
						<input type="hidden" name="city_id" id="city_id" value=""> 
						
						<input type="text" name="city" placeholder="City" class="fields" id="city" autocomplete="off">
						
						<div id="srch_res">
						</div>
						<br><br>
						
						<label for="pin" class="other_labels">PIN-CODE</label><br>
						<input type="text" name="pin" placeholder="Pin-code" class="fields" id="pin">
						<br><br
						
						<label for="address" class="other_labels">ADDRESS</label><br>
						<textarea type="text" name="address" placeholder="Address" class="fields" id="address" cols="30" rows="20"></textarea>
						<br><br><br>
						<label for="mobile">
							<img src="static/images/mobile.jpg" id="mobile_image">
						</label>
						<input type="text" name="rec_mobile" placeholder="Enter Reciever mobile" class="fields" id="mobile" maxlength="10" minlength="10"
						>
						<br><br>
						
						<!-- <a href="profile.do" id="back">BACK</a> -->
						<input type="submit" value="Save" id="button">
					</form>
				</div>
			</div>
			<%@ include file="footer_copy_right.jsp"%>	
		</div>
		<script src="static/js/address.js"></script>
		<script src="static/js/menu.js"></script>
		<script src="static/js/all_addresses.js"></script>
	</body>
</html>
