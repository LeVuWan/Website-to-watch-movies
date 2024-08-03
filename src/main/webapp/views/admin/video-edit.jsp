<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		</nav>
		<section>
		<center><h5>"${message}"</h5></center>
			<div class="row">
				<h3 class="card-title">Add/Edit Video</h3>

				<div class="card-tools">
					<button type="button" class="btn btn-tool"
						data-card-widget="collapse" title="Collapse">
						<i class="fas fa-minus"></i>
					</button>
				</div>
			</div>
			<form action="admin/video" method="post">
				<div class="mb-3 mt-3">
					<label for="uname" class="form-label">Title:</label> <input
						type="text" class="form-control" id="id"
						placeholder="Enter username"
						value="${video != null ? video.title : ''}" name="title" required>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="mb-3 mt-3">
					<label for="uname" class="form-label">Href:</label> <input
						type="text" class="form-control" id="id"
						placeholder="Enter username"
						value="${video != null ? video.href : ''}" name="href" required>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="mb-3 mt-3">
					<label for="uname" class="form-label">Description:</label> <input
						type="text" class="form-control" id="id"
						placeholder="Enter username"
						value="${video != null ? video.description : ''}"
						name="description" required>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="mb-3 mt-3">
					<label for="uname" class="form-label">Poster:</label> <input
						type="text" class="form-control" id="id"
						placeholder="Enter username"
						value="${video != null ? video.poster : ''}" name="poster"
						required>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<button formaction="/Asm_Java4/admin/video?action=create"
					class="btn btn-primary">Create</button>
				<button formaction="/Asm_Java4/admin/video?action=update"
					class="btn btn-secondary">Update</button>
				<button class="btn btn-info" type="reset">Reset</button>
			</form>
		</section>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>