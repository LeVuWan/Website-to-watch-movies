<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Anime | Template</title>
<%@ include file="/common/head.jsp"%>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<%@include file="/common/header.jsp"%>
	<!-- Header End -->

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<div class="hero__items set-bg"
					data-setbg="templates/user/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg"
					data-setbg="templates/user/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg"
					data-setbg="templates/user/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg">
					<div class="product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>Favorite video</h4>
								</div>
							</div>
						</div>
						<div class="row">
						<c:forEach items="${listVideo}" var="video">
							<div class="card mr-2 bg-light" style="width: 18rem;">
									<img class="card-img-top" src="${video.poster}"
										alt="Card image cap">
									<div class="card-body">
										<p class="card-text text-danger">${video.description}</p>
										<a class="text-danger"
											href="<c:url value='/video?action=watch&id=${video.href}' />">
											${video.title}</a>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>

			</div>
	</section>
	<!-- Product Section End -->

	<!-- Footer Section Begin -->
	<%@include file="/common/footer.jsp"%>


</body>

</html>