 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-2">
					<div class="header__logo">
						<a href="./index.html"> <img
							src="<c:url value='templates/user/img/logo.png'/>" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>
								<li><a href="homeController">Homepage</a></li>
								<c:choose>
									<c:when test="${not empty sessionScope.currentUser}">
										<li><a href="#">Welcome:
												${sessionScope.currentUser.username}</a></li>
										<li><a href="favorites">My favorites</a></li>
										<li><a href="history">History</a></li>
										<li><a href="logout">Logout</a></li>
										<li><a href="admin">Admin</a></li>
										<button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#changePassword">
											<span class="icon_profile"></span>
										</button>
									</c:when>
									<c:otherwise>
										<li><a href="register">Sign Up</a></li>
										<li><a href="login">Login</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
						<a href="#" class="search-switch"><span class="icon_search"></span></a>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<div class="modal fade" id="changePassword" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Change password</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="changePassword" method="post">
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" name="password"
								id="exampleInputPassword1">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">New Password</label> <input
								type="password" class="form-control" name="newPassword"
								id="exampleInputPassword1">
						</div>
						<div class="row"><span>${message}</span></div>
						<button type="submit" class="btn btn-danger">Submit</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>