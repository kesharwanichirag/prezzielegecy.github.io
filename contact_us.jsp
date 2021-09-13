<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::contact Us</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/contact_us.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<div id="main_body">
				<div id="title">
					<label>CONNECT WITH US</label>
					<div class="main">
						<a href="https://www.instagram.com" class="links">
							<div class="box insta">
								<i class="fa fa-instagram fa-2x boxes"></i>
							</div>
						</a>
						<a href="" class="links">
							<div class="box linkedin">
								<i class="fa fa-linkedin fa-2x boxes"></i>
							</div>
						</a>
						<a href="#" class="links">
							<div class="box twit">
								<i class="fa fa-twitter fa-2x boxes"></i>
							</div>
						</a>
						<a href="https://facebook.com" class="links">
							<div class="box face">
								<i class="fa fa-facebook fa-2x boxes"></i>
							</div>
						</a>
					</div>
					<span id="feedback_link_box">
						<img src="static/images/feedback.png">
						<div>CONTACT TO ADMIN</div>
					</span>
				</div>
				<br>
				<div id="alert_box">
					<div id="alert">
						<div>
							<img src="static/images/close.png" id="close">
						</div>
						<br><br>
						<a href="" class="select_optns">
							<img src="static/images/fb.png">
						</a>
						<a href="" class="select_optns">
							<img src="static/images/wap.png">
						</a>
						<a href="" class="select_optns">
							<img src="static/images/twitter.png">
						</a>
						<a href="prezzie_feedback.do" class="select_optns">
							<img src="static/images/logo2.png">
						</a>
						<a href="" class="select_optns">
							<img src="static/images/gmail.png">
						</a>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/contact_us.js"></script>
	</body>
</html>