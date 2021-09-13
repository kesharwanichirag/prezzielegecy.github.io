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
				<a href="index.do" class="seller_process_viewers seller_cram">
					Home
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<div id="product_current_page"  class="seller_process_viewers">
					${product.productName}
				</div>
			</div>
			<div id="msg">
				Product Added Successfully...!
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
						Seller - ${product.seller.sellerAccountName} 
					</label>
					<br>
					<span class="rating_box">
						<span class="rate" id="rate_s"> </span>
						<span class="rev" id="rev"></span>
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
					<span class="instock">Available:${product.quantity}</span>
					<br>
					<div class="hrs"></div>
					<div>
						<span id="buy_now" class="but_add">Buy Now &#8377;${product.price*(100-product.discount)/100}</span>
						<span id="add_to_cart" class="but_add" data-actb="${product.productId}">Add To Cart</span>
						<label id="pro_quanity_">Quantity:</label>
						<select id="pro_qt">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
					</div>
					<br>
					<div class="point_oths__">
					<div id="points_">Product Information</div>
						<table id="product_points_table">
						
						</table>
					</div>
				</div>
			</div>
			<br>
			<div id="all_dtls_box">
				<div class="dtls__BOx" id="dtls_container__box">
					<span class="__dtls" id="box_1">
						
					</span>
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
				<br>
				<div class="dtls__BOx" id="rev_container__box">
					<span class="__dtls">
						RATING & REVIEWS
					</span>
					<br><br>
					<div id="show_rev_box">
						<span id="_rate_"></span>
						<span class="_rate_oth">/</span>
						<span class="_rate_oth">5.0</span>
						<br><br>
						<!--<i class="fa fa-star" aria-hidden="true"></i>
						<i class="fa fa-star" aria-hidden="true"></i>
						<i class="fa fa-star" aria-hidden="true"></i>
						<i class="fa fa-star" aria-hidden="true"></i>
						<i class="fa fa-star" aria-hidden="true"></i>-->
						<span class="rating_box">
							<span class="rate">4.0 &#9733;</span>
							<span class="rev" id="show_rate_part"></span>
							<br>
							<span id="view_rev_">
								view all Ratings &#8595;
							</span>
						</span>
						<br><br>
					</div>
					<div id="give_rev_box">
						<span>
							<span id="do_you_want">
								Do You Want To Review Product ?
							</span>
							<br>
							<span id="hint_rev">
								if you have used this product then<br>&nbsp;&nbsp;only you can RATE this product
							</span><br>
							<span id="rev_btn">REVIEW NOW</span>
						</span>
					</div>
					<div id="user_rate_box">
						<form id="user_rate_box_form">
							<div>
								<img src="static/images/close.png" id="close">
							</div>
							<br>
							<div id="hint_rev_">
								SLIDE BAR FOR RATING
							</div>
							<small id="rate_numbers">
							1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5</small>
							<input type="range" id="rate_range_bar" name="rating" min="1" max="5"><br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span id="select_msg">
								<span id="select_hint">How Was The Product</span><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<select name="key_message" id="key_message">
									<option>Poor</option>
									<option selected>Good</option>
									<option>Very Good</option>
									<option>Excellent</option>
								</select>
								<!--<span class="key_msg"></span>
								<span class="key_msg">Good</span>
								<span class="key_msg">very Good</span>
								<span class="key_msg">Excellent</span>-->
							</span>
							<br>
							<textarea placeholder="Write a Review(optional)" id="text_area_field" name="review"></textarea>
							<br>
							<input type="submit" value="Submit" id="button">
							<input type="hidden" name="product_id" value="${product.productId}">
						</form>
					</div>
				</div>
				<div class="dtls__BOx" id="view_all_reviews_in_box">
					
				</div>
			</div>
			<br>
			<input type="hidden" id="product_id" value="${product.productId}">
			<!---------------------------------------------->
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/product.js"></script>
		<script src="static/js/user_product.js"></script>
	</body>
</html>