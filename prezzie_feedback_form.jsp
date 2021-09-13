<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::feedback</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/prezzie_feedback_form.css">
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
					<label>MESSAGE ADMIN</label>
				</div>
				<form action="prezzie_feedback.do" method="post" id="loginform">
					<table align="center" >
						<span class="text_area_labels">Enter Your Message</span>
						<tr>
							<td>
								<textarea placeholder="Enter Message" class="fields" name="user_feedback">
								</textarea>
							</td>
						</tr>
					</table>
					<input type="submit" id="button"><br>
				</form>
			</div>
			<br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
		<script src="static/js/contact_us.js"></script>
	</body>
</html>