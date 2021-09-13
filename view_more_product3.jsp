<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::30+</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/cat_pro.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<!--------------------------------------------->
			<div id="main_body">
				<div id="msg">
					Product Added Successfully...!
				</div>
				<div id="block1">
					<div id="not_found">NO RESULT FOUND....!</div>
				</div>
				<c:forEach var="product" items="${pro_cat2}">
					<div class="prods_1">
						<div class="lft_view">
							<img src="product_image.do?product_id=${product.productId}" class="view_images_">
						</div>
						<div class="rht_view">
							
							<span class="addcart_ but_add" data-actb="${product.productId}">Add To Cart</span>
							
							<span class="buynow_ but_add">Buy Now</span>
							<select class="pro_qt">
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
							<span class="prd_name_bx">
								<a href="user_product_view.do
									?product_id=${product.productId}">
									${product.productName}
								</a>
							</span>
							<br>
							<!--<span class="rating_box">
								<span id="rate">4.0 &#9733;</span>
								<span class="rev">Ratings:100</span>
								<span class="rev">|</span>
								<span class="rev">Reviews:500</span>
							</span>-->
							<span class="rating_box">
								<span id="rate">&#10004;</span>
								<span class="rev">Available:${product.quantity}</span>
								<!--<span class="rev">|</span>
								<span class="rev">Reviews:500</span>-->
							</span>
							<br>
							<span class="labl_">
								Price -
							</span>
							<span class="price_">
								&#x20B9; ${product.price*(100-product.discount)/100}
							</span>
							<s class="mrp_">
								(MRP: &#x20B9; ${product.price})
							</s>
							<span class="discount_">
								${product.discount}% off
							</span>
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
