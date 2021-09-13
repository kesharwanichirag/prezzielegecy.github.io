<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="gift" uri="gift_tld" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>gift::seller</title>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/seller.css">
		<link rel="stylesheet" type="text/css" href="static/css/footer.css">
		<link rel="stylesheet" type="text/css" href="static/css/menu.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>		
		<div id="container_body">
			<%@ include file="header.jsp"%>
			<%@ include file="menu.jsp"%>
			<!--------------------------------------------->
			<div id="main_body">
				<div id="title">
					<label>SELLER ACCOUNT</label>
				</div>
				<div>
					<a href="new_seller.do" id="new_seller">ADD NEW SELLER</a>
				</div>
				<div id="table_box">
					<c:choose>
						<c:when test="${empty seller}">
							NO SELLER ACCOUNT FOUND....!	
						</c:when>
						<c:otherwise>
							<table align="center" id="table">
								<tr>
									<td  class="table_header">
										<label class="table_labels">
											ACCOUNT NO.
										</label>
									</td>
									<td class="table_header">
										<label class="table_labels">
											ACCOUNT NAME
										</label>
									</td>
									<td class="table_header">
										<label class="table_labels">
											DATE
										</label>
									</td>
									<td class="table_header">
										<label class="table_labels">
											BUISNESS TYPE
										</label>
									</td>
								</tr>
								<c:forEach var="seller" items="${seller}">
									<tr>
										<td>
											<input type="checkbox" value="${seller.sellerId}">
										</td>
										<td>
											<a href="seller_dashboard.do?seller_id=${seller.sellerId}&seller_name=${seller.sellerAccountName}" class="my_seller_account_details seller_account_names">
												${seller.sellerAccountName}
											</a>
										</td>
										<td>
											<label class="my_seller_account_details">
												${gift:dateformat(seller.startDate)}
											</label>
										</td>
										<td>
											<label class="my_seller_account_details">
												${seller.buisnessType}
											</label>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
				</div>			
			</div>
			<!--------------------------------------------->
			<br><br><br><br><br><br><br>
			<%@ include file="footer.jsp"%>
			<%@ include file="footer_copy_right.jsp"%>
		</div>
		<script src="static/js/menu.js"></script>
	</body>
</html>
