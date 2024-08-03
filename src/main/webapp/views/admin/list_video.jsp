<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav>
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand" href="<c:url value='/admin'/>">Home</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page"
								href="<c:url value='/admin/video?action=view'/>">Video
									overview</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/admin/video?action=add'/>">Editvideo</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</nav>
		<section>
			<table class="table">
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
							<td><img src="${item.poster}" width="150px" height="150px" /></td>
							<td><a
								href="<c:url value='/admin/video?action=edit&href=${item.href}'/>"
								type="button" class="btn btn-block btn-success btn-sm">Edit</a>
								<a type="button"
								href="http://localhost:8080/Asm_Java4/admin/video?action=delete&href=${item.href}"
								class="btn btn-block btn-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>