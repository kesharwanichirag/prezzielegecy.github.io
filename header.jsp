<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<div id="header">
				<a href="index.do">
					<img src="static/images/logo2.png" id="logo">
				</a>
				<span id="welcome">
					<span id="wlc">
						Welcome:
					</span>
					<c:choose>
						<c:when test="${user!=null}">
							<span>
								${user.userName}
							</span>
						</c:when>
						<c:otherwise>
							Guest!
						</c:otherwise>
					</c:choose>
				</span>
				<c:choose>
					<c:when test="${user==null}">
						<span class="header_menu">
							<a href="login.do" class="account_controls" id="loginregister">LOGIN/REGISTER</a>
						</span>
					</c:when>
					<c:otherwise>
						<span class="header_menu">
							<a href="profile.do">
								<img src="save_profilepic.do" id="profile">
							</a>
						</span>
						
					</c:otherwise>
				</c:choose>		
			</div>