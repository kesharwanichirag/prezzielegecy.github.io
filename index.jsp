<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::index</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/index.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<!--------------------------------------------->
			<div class="slideshow-container">
				<div class="mySlides fade">
					<span>
						<img src="static/images/slides/AA1.png" class="img_slide">
					</span>
				</div>

				<div class="mySlides fade">
					<span href="#">
						<img src="static/images/slides/AA6.png" class="img_slide">
					</span>
				</div>

				<div class="mySlides fade">
					<span href="#">
						<img src="static/images/slides/AA3.png" class="img_slide">
					</span>
				</div>

				<div class="mySlides fade">
					<span href="#">
						<img src="static/images/slides/AA4.png" class="img_slide">
					</span>
				</div>

				<div class="mySlides fade">
					<span href="#">
						<img src="static/images/slides/AA5.png" class="img_slide">
					</span>
				</div>
				
				<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
				<a class="next" onclick="plusSlides(1)">&#10095;</a>
			</div>
			<br>

			<div style="text-align:center">
			  <span class="dot" onclick="currentSlide(1)"></span> 
			  <span class="dot" onclick="currentSlide(2)"></span> 
			  <span class="dot" onclick="currentSlide(3)"></span>
			  <span class="dot" onclick="currentSlide(5)"></span> 
			  <span class="dot" onclick="currentSlide(5)"></span>
			</div>
			<!---------------------------------------------->
			<div class="recom_">
				<span>Recommends to you...</span>
			</div>
			<div id="cat_box__">
				<c:forEach var="prods" items="${pro_index}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<br>
			<!----------------------------------------------------->
			<span class="view_more_box">
				<a href="show_by_caty.do?category_id=69" class="view_more_">View More</a>
			</span>
			<span class="recom_">
				<span>Fresh Cakes...</span>
			</span>
			<div id="cat_box__">
				<c:forEach var="prods" items="${index_cake}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat" value="${prods.productId}">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<!----------------------------------------------------->
			<span class="view_more_box">
				<a href="show_by_caty.do?category_id=${70}" class="view_more_">View More</a>
			</span>
			<span class="recom_">
				<span>Fresh Flowers...</span>
			</span>
			<div id="cat_box__">
				<c:forEach var="prods" items="${flowers}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat" value="${prods.productId}">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<!----------------------------------------------------->
			<span class="view_more_box">
				<a href="view_more1.do" class="view_more_">View More</a>
			</span>
			<span class="recom_">
				<span>10% to 20% Discount...</span>
			</span>
			<div id="cat_box__">
				<c:forEach var="prods" items="${twenty_percent_disc}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat" value="${prods.productId}">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<!----------------------------------------------------->
			<span class="view_more_box">
				<a href="view_more2.do" class="view_more_">View More</a>
			</span>
			<span class="recom_">
				<span>20% to 30% Discount...</span>
			</span>
			<div id="cat_box__">
				<c:forEach var="prods" items="${thirty_percent_disc}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat" value="${prods.productId}">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<!----------------------------------------------------->
			<span class="view_more_box">
				<a href="view_more3.do" class="view_more_">View More</a>
			</span>
			<span class="recom_">
				<span>More Than 30% Discount...</span>
			</span>
			<div id="cat_box__">
				<c:forEach var="prods" items="${thirty_plus}">
					<a href="user_product_view.do
						?product_id=${prods.productId}" class="index_cat" value="${prods.productId}">
						<span class="prod_img">
							<img src="product_image.do?product_id=${prods.productId}" class="prod_img_view">
						</span>
						<span class="ind_prods_name">
							${prods.productName}
						</span>
						<span class='prod_price'>
							<span class="price__">
								Price: &#8377;${prods.price*(100-prods.discount)/100}
							</span>
							<s class="price_bef">&#8377;${prods.price}</s>
						</span>
						<br>
						<span class="disc__">Discount : ${prods.discount}%</span>
					</a>
				</c:forEach>
			</div>
			<!----------------------------------------------------->
			<c:choose>
				<c:when test="${user ne null}">
					
				</c:when>
				<c:otherwise>
					<div id="login_box">
						<div id="index_form">
							<div>
								<img src="static/images/close.png" id="close">
							</div>
							<div id="title">
								<label>LOGIN</label>
							</div>
							<form action="login.do" method="post">
								<table align="center" >
									<tr>
										<td>
											<img src="static/images/user.png" class="labels">
										</td>
										<td>
											<input type="text" placeholder="Enter UserName/Email" class="fields" name="username_email">
										</td>
									</tr>
									<tr>
										<td>
											<img src="static/images/psw.png" class="labels">
										</td>
										<td>
											<input type="password" placeholder="Enter Password" class="fields" name="password">
										</td>
									</tr>
								</table>
								<div class="g-recaptcha" data-sitekey="6LfostcZAAAAACMAdfJv1x-g0bnfL6j4jDH6LIRk" id="re_captcha">
								</div>
								<input type="submit" value="login" id="button"><br>
								<a href="#" id="forgot_password">forgot password ?</a>
							</form>
							
							<a href="#" id="login_facebook" class="login_options">
								Login with	Facebook
							</a>
							<a href="#" id="login_gmail" class="login_options">
								Login with Gmail
							</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/index.js"></script>
		<script src="static/js/index_2.js"></script>
		<script src="static/js/menu.js"></script>
	</body>
</html>
