<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
<meta name="description"
	content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
<meta name="robots" content="noindex,nofollow">
<title>Ample Admin Lite Template by WrapPixel</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="<c:url value='templates/admin/plugins/images/favicon.png'/>">
<!-- Custom CSS -->
<link href="<c:url value='templates/admin/css/style.min.css'/>"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin6">
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand" href="dashboard.html"> <!-- Logo icon -->
						<b class="logo-icon"> <!-- Dark Logo icon --> <img
							src="<c:url value='templates/admin/plugins/images/logo-icon.png'/>"
							alt="homepage" />
					</b> <!--End Logo icon --> <!-- Logo text --> <span class="logo-text">
							<!-- dark Logo text --> <img
							src="<c:url value='templates/admin/plugins/images/logo-text.png'/>"
							alt="homepage" />
					</span>
					</a>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<a
						class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					data-navbarbg="skin5">
					<ul class="navbar-nav d-none d-md-block d-lg-none">
						<li class="nav-item"><a
							class="nav-toggler nav-link waves-effect waves-light text-white"
							href="javascript:void(0)"><i class="ti-menu ti-close"></i></a></li>
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav ms-auto d-flex align-items-center">

						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
						<li class=" in">
							<form role="search" class="app-search d-none d-md-block me-3">
								<input type="text" placeholder="Search..."
									class="form-control mt-0"> <a href="" class="active">
									<i class="fa fa-search"></i>
								</a>
							</form>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<aside class="left-sidebar" data-sidebarbg="skin6">
			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<!-- User Profile-->
						<li class="sidebar-item pt-2"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="<c:url value='/admin/video?action=add'/>"
							aria-expanded="false"> <span class="hide-menu">Edit or
									Create Video</span>
						</a></li>
						<li class="sidebar-item pt-2"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="<c:url value='/admin/video?action=view'/>"
							aria-expanded="false"> <span class="hide-menu">Video
									Overview</span>
						</a></li>
						<li class="sidebar-item"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="<c:url value='/admin'/>" aria-expanded="false"> <span
								class="hide-menu">Home</span>
						</a></li>
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb bg-white">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Basic Table</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<div class="d-md-flex">
							<ol class="breadcrumb ms-auto">
								<li><a href="#" class="fw-normal">Dashboard</a></li>
							</ol>
							<a href="https://www.wrappixel.com/templates/ampleadmin/"
								target="_blank"
								class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Upgrade
								to Pro</a>
						</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">List video</h3>
							<div class="table-responsive">
								<table class="table text-nowrap">
									<thead>
										<tr>
											<th>Title</th>
											<th>Description</th>
											<th>Link</th>
											<th>Poster</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${videos}" var="item">
											<tr>
												<td>${item.title}</td>
												<td>${item.description}</td>
												<td><a
													href="<c:url value='/video?action=watch&id=${item.href}'/>">${item.href}</a></td>
												<td><img src="${item.poster}" width="150px"
													height="150px" /></td>
												<td><a
													href="<c:url value='/admin/video?action=edit&href=${item.href}'/>"
													type="button" class="btn btn-block btn-success btn-sm">Edit</a>
													<a type="button" href="http://localhost:8080/Asm_Java4/admin/video?action=delete&href=${item.href}" 
														class="btn btn-block btn-danger btn-sm">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center">
				2024 © Ample Admin brought to you by <a
					href="https://www.wrappixel.com/"></a>
			</footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src="<c:url value='templates/admin/plugins/bower_components/jquery/dist/jquery.min.js'/>"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="<c:url value='templates/admin/bootstrap/dist/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='templates/admin/js/app-style-switcher.js'/>"></script>
	<!--Wave Effects -->
	<script src="<c:url value='templates/admin/js/waves.js'/>"></script>
	<!--Menu sidebar -->
	<script src="<c:url value='templates/admin/js/sidebarmenu.js'/>"></script>
	<!--Custom JavaScript -->
	<script src="<c:url value='templates/admin/js/custom.js'/>"></script>
	<script>
	function deleteVideo(href){
		$.ajax({
			url: '/Asm_Java4/admin/video?action=delete&href=' + href
		}).then(function(data){
			window.location.href = "http://localhost:8080/Asm_Java4/admin/video?action=view";
		}).fail(function(error){
			alert("loi!");
		});
	};			
	</script>
</body>
</html>