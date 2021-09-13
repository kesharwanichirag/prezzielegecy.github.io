<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::newseller</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/new_seller.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<!--------------------------------------------->
			<div id="main_body">
				<% String error = (String)request.getAttribute("error"); %>
				<div id="error_message"
				style='display:<%= error==null?"none":"block"%>'>
					<%= error %>
				</div>				
				
				<div id="title">
					<label>SELLER ACCOUNT</label>
				</div>
				<a href="seller.do" class="seller_process_viewers" id="seller_home_top">
					Seller Home
				</a>
				<span class="seller_process_viewers">
					&nbsp;&nbsp;&raquo;&nbsp;&nbsp;
				</span>
				<span id="current_page" class="seller_process_viewers">
					New Seller Account
				</span>
				<form action="new_seller.do" id="seller_form" method="post">
					<table align="center">
						<tr>
							<td>
								<label for="seller_account_name">
									<img src="static/images/seller.png" class="labels">
								</label>
							</td>
							<td>
								<input type="text" class="fields" placeholder="ENTER NEW ACCOUNT NAME" name="seller_account_name" class="seller_details" id="seller_account_name">
							</td>
						</tr>
						<tr>
							<td>
								<label for="select_buisness_type">
									<img src="static/images/buisness.png" class="labels" id="buisness_image">
								</label>
							</td>
							<td>
								<!--<input type="text" class="fields" placeholder="ENTER BUISNESS TYPE" name="seller_buisness_type" class="seller_details" id="seller_buisness_type">-->
								<select name="seller_buisness_type" id="select_buisness_type">
									<option>
										WholeSale
									</option>
									<option>
										Destributor
									</option>
									<option>
										Retailer
									</option>
									<option>
										Others...
									</option>
								</select>
							</td>
						</tr>
						<!--<tr>
							<td>
								<label for="seller_adhaar">
									<img src="static/images/adhaarcardd.png" id="adhaar_image">
								</label>
							</td>
						</tr>-->
					</table>
					<!--<table id="table_2">
						<tr>
							<td>
								
							</td>
							<td>
								<label id="adhaar_hint">
									Upload Your Adhaar-Card Front Side Image
								</label><br>
								<label id="adhaar_warning">
									(Warning: Adhaar-Card image Number and Input Adhaar No. <br>must match Otherwise your Account will be BLOCK)
								</label>
							</td>
						</tr>
						<tr>
							<td>
								
							</td>
							<td>
								<br>
								<input type="file" name="adhaar_image">
							</td>
						</tr>
						
					</table>-->
					<br><br>
					<div class="g-recaptcha" data-sitekey="6LfostcZAAAAACMAdfJv1x-g0bnfL6j4jDH6LIRk" id="re_captcha">
					</div>
					<input type="submit" value="CREATE" id="button"><br>
				</form>	
			</div>
			<!--------------------------------------------->

			<br><br><br><br><br><br><br><br><br><br><br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>
