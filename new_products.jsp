<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::newproduct</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/new_product.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="title">
					<label>NEW PRODUCT</label>
				</div>
				<a href="seller.do" class="seller_process_viewers" id="seller_home_top">
					Seller Home
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<a href="seller_dashboard.do?seller_id=${seller.sellerId}&seller_name=${seller.sellerAccountName}" class="seller_process_viewers">
					${seller.sellerAccountName}
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<span class="seller_process_viewers" id="new_product_current_page">
					New Product 
				</span>
				
				<!------------------------->
				<br>
				<div id="add_product_process_box">
					<ul id="steps_ul">
						<li class="open">1</li>
						&nbsp;&nbsp;---&nbsp;
						<li>2</li>
						&nbsp;&nbsp;---&nbsp;
						<li>3</li>
						&nbsp;&nbsp;---&nbsp;
						<li>4</li>
						&nbsp;&nbsp;---&nbsp;
						<li>5</li>
						&nbsp;&nbsp;---&nbsp;
						<li>6</li>
						&nbsp;&nbsp;---&nbsp;
						<li>7</li>
						&nbsp;&nbsp;---&nbsp;
						<li>8</li>
						&nbsp;&nbsp;---&nbsp;
						<li>9</li>
						&nbsp;&nbsp;---&nbsp;
						<li>10</li>
					</ul>
				</div>
				<div id="steps_box">
					<div id="add_products_step1"class="show add_products_steps">
						<form id="seller_form_1">
							<table align="center">
								<tr>
									<td>
										<label class="product_labels" for="">
											Categroy
										</label>
									</td>
									<td>
										<select name="category_id" class="fields" id="category">
											<option value="0">select</option>
											
											<c:forEach var="category" items="${categories}">
												<option value="${category.categoryId}">
													${category.category}
												</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										<label class="product_labels" for="">
											Product Name
										</label>
									</td>
									<td>
										<input type="text" placeholder="Enter Product Name" class="fields" name="product_name">
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="product_labels" for="">
											Quantity
										</label>
									</td>
									<td>
										<input type="number" placeholder="Enter Quantity You Have" class="fields" name="product_quantity">
									</td>
								</tr>
								<tr>
									<td>
										<label class="product_labels" for="">
											Price(&#8377;)
										</label>
									</td>
									<td>
										<input type="number" placeholder="Enter Price(in RS)" class="fields" name="product_price">
									</td>
								</tr>
								<tr>
									<td>
										<label class="product_labels" for="sub_category">
											Discount %
										</label>
									</td>
									<td>
										<input type="number" value="0" class="fields" name="product_discount">
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>							
					</div>

					<div id="add_products_step2"class="hide
					add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_2">
							<table align="center">
								<span class="text_area_labels">Enter Your product Description</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_description" placeholder="Enter product Description">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step3"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_3">
							<table align="center">
								<span class="text_area_labels">Enter Your product Specification</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_specification">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step4"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_4">
							<table align="center">
								<span class="text_area_labels">Enter Your product Disclamer</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_disclamer">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step5"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_5">
							<table align="center">
								<span class="text_area_labels">Enter Your product Shipping Details</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_shipping_details">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step6"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_6">
							<table align="center">
								<span class="text_area_labels">Enter Your product Payment Details</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_payment_details">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step7"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_7">
							<table align="center">
								<span class="text_area_labels">Enter Your product Returning Policy</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_returning_policy">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step8"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_8">
							<table align="center">
								<span class="text_area_labels">Enter Your product Warranty</span>
								<tr>
									<td>
										<textarea class="fields textareas" name="product_warranty">
										</textarea>
									</td>
								</tr>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step9"class="hide add_products_steps">
						<h4 class="product_name_headings">JAVA</h4>
						<form id="seller_form_9">
							<table align="center">
								<span class="text_area_labels">Enter Product main Points</span>
								<thead>
									<tr>
										<th class="block1">
											<span>&#8226;</span>
										</th>
										<th class="block2">
											<span>Point Titles</span>
										</th>
										<th class="block3">
											<span>Point Values</span>
										</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<td>
											
										</td>
										<td>
											
										</td>
										<td>
											<i class="fa fa-plus-square fa-3x plus_icon" id="add_more_button" aria-hidden="true"></i>
										</td>
									</tr>
								</tfoot>
								<tbody id="product_point_record">
									<tr>
										<td>
											&#9733;	
										</td>
										<td>
											<input type="text" class="point_header" placeholder="Enter Points">	
										</td>
										<td>
											<textarea class="point_value" placeholder="Enter Points Details"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
					<div id="add_products_step10"class="hide add_products_steps">
						<form id="seller_form_10" action="save_product_pics.do" 
						enctype="multipart/form-data" method="post">
							<table align="center">
								<span class="text_area_labels" id="label_10">
									Upload Product Pics
								</span>
								<thead>
									<tr>
										<th class="block1">
											<span>&#8226;</span>
										</th>
										<th class="block2">
											<span>Product Images</span>
										</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<td>
											
										</td>
										<td>
											
										</td>
										<td>
											<i class="fa fa-plus-square fa-3x plus_icon" id="add_more_button_img" aria-hidden="true"></i>
										</td>
									</tr>
								</tfoot>
								<tbody id="product_image_record">
									<tr>
										<td>
											&#9733;	
										</td>
										<td>
											<input type="file" class="product_images" name="product_images">	
										</td>
									</tr>
								</tbody>
							</table>
							<input type="submit" value="Next" class="button"><br>
						</form>
					</div>
				</div>
				<input type="hidden" value="" id="product_id">
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/new_product.js"></script>
	</body>
</html>