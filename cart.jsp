<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::cart</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/cart.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>		
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<c:forEach var="cartItem" items="${cart}">			
					<input type="hidden" class="prod_id" value="${cartItem.key}">	
				</c:forEach>
				<div id="cart_detls">
					<span>SHOPPING CART</span>
				</div>
				<div id="show_other_products">
					<div id="show_other_products_title">
						Select Some Products To Add...
					</div>
					<div id="show_other_products_viewer">
						<c:forEach var="show" items="${show_cat_forcart}">
							<a href="show_by_caty.do?category_id=${show.categoryId}" value="${show.categoryId}">${show.category}</a>
						</c:forEach>
					</div>
				</div>
				<div id="empty_cart">
					Cart is Empty Please add Some Records....!
				</div>
				<div id="cart_box">
					<c:forEach var="product" items="${products}">
						<div class="prods_crt">
							<div class="lft_view">
								<img 
								src=
								"product_image.do?product_id=${product.productId}" class="view_images_">
							</div>
							<div class="rht_view">	
								<span class="totalBx">
									<div class="total">
										Price
									</div>
									<div class="total_amt">
										
									</div>
								</span>
								
								<span class="remove_prod" data-del="${product.productId}">
								&#x292B; &nbsp; Remove
								</span>
								<span class="prd_name_bx">
									<a href="user_product_view.do?product_id=${product.productId}" class="prd_nm">
										${product.productName}
									</a>
								</span>
								<br>
								<span class="prod_div_o">
									<i>&#x20B9;</i> 
									<span class="price_">
										${product.price*(100-product.discount)/100}
									</span>
									<s class="mrp_">
										(MRP: &#x20B9; ${product.price})
									</s>
									<span class="discount_">
										${product.discount}% off
									</span>
								</span>
								<span class="qt_box">
									<span>Quantity:</span>
									<select class="pro_qt" data-proqt="${product.productId}">
										<c:forEach var="record" items="${cart}">
											<c:choose>
												<c:when test="${record.key==product.productId}">
													<c:forEach var="counter" items="${cart_count}">
														<c:choose>
															<c:when test="${record.value==counter}">
																<option selected>
																	${counter}
																</option>
															</c:when>
															<c:otherwise>
																<option>
																	${counter}
																</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</span>
							</div>
						</div>
					</c:forEach>
				</div>			
				<div id="subtotal_box">
					<i>&#x20B9;</i>
					<span id="tt_amount">
						
					</span>
					<label >
						Total Amount Rs:
					</label>
					<span id="pay_">
						CHECKOUT
					</span>
				</div>
				<div id="loader_container">
					<img src="static/images/loader.gif" id="loader">
				</div>
				<div id="deleting_container">
					<img src="static/images/deleting.gif" id="deleteing">
				</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/cart.js"></script>
	</body>
</html>
