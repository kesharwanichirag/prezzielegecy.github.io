<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
			<div id="menu_bar">
				<!------------------ocassions------------------->
				<a href="index.do" id="home_box">
					<i class="fa fa-home" id="home"></i>
					<span >Home</span>
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="menu" onclick="openCat()">
					Categories
				</span>
				<div id="cat_nav" class="cat_nav">
					<a href="javascript:void(0)" class="closebtn_" onclick="closeCat()">&times;</a>
					<div id="div1">
						<span>
							Men Accessories
						</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category1}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>

					<div id="div2">
						<span>Women Accessories</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category2}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>

					<div id="div3">
						<span>HOME GIFTS</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category5}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>
					<br>
					<div id="div4">
						<span>TOYS</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category4}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>
					<div id="div5">
						<span>PHOTO GIFTS</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category3}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>

					<div id="div6">
						<span>STATIONARY GIFTS</span>
						<br>
						<br>
						<c:forEach var="category" items="${all_category6}">
							<a href="show_by_caty.do?category_id=${category.categoryId}" class="cate___" value="${category.categoryId}">
								${category.category}
							</a>	
							<br>
						</c:forEach>
					</div>
				</div>
				<!-- <a href="" id="cake_tx">
					<i class="fa fa-birthday-cake" aria-hidden="true"></i>
					Order Fresh Cakes
				</a> -->
				<span style="font-size:30px;cursor:pointer" id="icon_bar">
					&#9776;
				</span>
				<!---------------------->
				<div id="search_box">
					<input type="search" id="search"
					placeholder="Search..." name="search" autocomplete="off">
					<input type="button" id="search_button" value="&#128269;">
					<img onclick="startDictation()" src="https://i.imgur.com/cHidSVu.gif" id="mic">
				</div>
				<!---------------------->
				<span class="fa fa-search" id="search_icon"></span>
				<img src="static/images/cross.png" id="cross_icon1">
				<a href="show_cart.do" class="fa fa-shopping-cart" id="cart_icon">
					<span id="cart_count">
						<c:choose>	
							<c:when test="${cartcount ne null}">
								${cartcount}
							</c:when>
							<c:otherwise>
								0
							</c:otherwise>
						</c:choose>
					</span>
				</a>
				<div id="mySidenav" class="sidenav">
					<a href="javascript:void(0)" class="closebtn sidenv_data" onclick="closeNav()">&times;</a>
					<a href="seller.do" class="sidenv_data">Seller Account</a>
					<a href="settings.do" class="sidenv_data">Settings</a>
					<a href="" class="sidenv_data">My Orders</a>
					<a href="contact_us.do" class="sidenv_data">Connect With Us</a>
					<a href="logout.do" class="sidenv_data">Logout</a>
				</div>
				<span style="font-size:30px;cursor:pointer" onclick="openNav()" id="icon_bar">
					&#9776;
				</span>
			</div>
			<script src="static/js/search.js"></script>