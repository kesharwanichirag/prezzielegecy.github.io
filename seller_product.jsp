<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::product</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/product.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css">
    <link rel="stylesheet" href="static/css/chat.css">-->
	</head>
	<body>		
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<!--------------------------------------------->
			<div id="breadcram">
				<a href="seller.do" class="seller_process_viewers seller_cram" id="">
					Seller Home
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<a href="seller_dashboard.do?seller_id=${seller.sellerId}&seller_name=${seller.sellerAccountName}" class="seller_process_viewers seller_cram">
					${seller.sellerAccountName}
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<div id="product_current_page"  class="seller_process_viewers">
					${product.productName}
				</div>
			</div>		
			<div id="main_body">
				<div id="img_div">
					<div id="small_image_box">
						
					</div>
					<div class="pro_image_div" id="big_image_box">
						
					</div>
					<br>
				</div>
				<div class="pro_details_div">
					<header>
						${product.productName}
					</header>
					<br>
					<label class="pro_seller">
						${product.seller.sellerAccountName} 
					</label>
					<br>
					<span class="rating_box">
						<span id="rate">4.0 &#9733;</span>
						<span class="rev">Ratings:100</span>
						<span class="rev">|</span>
						<span class="rev">Reviews:500</span>
					</span>
					<span id="share">
						<a href="">
							<img src="static/images/fb.png" class="share_">
						</a>
						<a href="">
							<img src="static/images/wap.png" class="share_">
						</a>
						<a href="" >
							<img src="static/images/gmail.png" class="share_">
						</a>
						<a href="" id="twt">
							<img src="static/images/twitter.png" class="share_">
						</a>
					</span>
					<div class="hrs"></div>
					<label class="price_label">
						Discount Price - 
					</label>
					<label class="price">
						&#8377;${product.price*(100-product.discount)/100}
					</label>
					<br>
					<label class="price_label">
						Price - 
					</label>
					<s class="mrp">
						(&#8377; ${product.price}.00)
					</s>
					<span class="disc_per">
						${product.discount}% off
					</span>
					<br>
					<span class="price_label">
						Stock -
					</span>
					<span class="instock">Available.</span>
					<br>
					<div class="hrs"></div>
					<div>
						<span id="delete" class="but_add" data-actb="${product.productId}">Delete Product</span>
						
					</div>
					
					<br>
					<div class="point_oths__">
					<div id="points_">Product Information</div>
						<table id="product_points_table">
						
						</table>
					</div>
				</div>
				<br>
				<div class="dtls__BOx">
					<div class="dtls_hds">
						Description
					</div>
					<div class="dtls_per_text">
						${product.description}
					</div>
					<div class="hrs"></div>
					<div class="dtls_hds">
						Disclamer
					</div>
					<div class="dtls_per_text">
						${product.disclamer}
					</div>
					<div class="hrs"></div>
					<div class="dtls_hds">
						Shipping Details
					</div>
					<div class="dtls_per_text">
						${product.shippingDetails}
					</div>
					<div class="hrs"></div>
					<div class="dtls_hds">
						Warrenty
					</div>
					<div class="dtls_per_text">
						${product.warranty}
					</div>
					<div class="hrs"></div>
					<div class="dtls_hds">
						Specification
					</div>
					<div class="dtls_per_text">
						${product.specification}
					</div>
					<div class="hrs"></div>
					<div class="dtls_hds">
						Returning Policy
					</div>
					<div class="dtls_per_text">
						${product.returningPolicy}
					</div>
				</div>
			</div>
			<input type="hidden" id="product_id" value="${product.productId}">
			<!---------------------------------------------->
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/product.js"></script>
		<!--<script src="https://cdn.jsdelivr.net/npm/@joeattardi/emoji-button@3.1.1/dist/index.min.js"></script>
		<script src="static/js/chat.js"></script>-->
	</body>
</html>
