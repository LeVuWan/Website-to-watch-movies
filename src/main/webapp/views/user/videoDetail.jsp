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
	<section class="anime-details spad">
		<div class="container">
			<div class="anime__details__content">
				<div class="row">
					<div class="col-lg-6">
						<div class="anime__video__player">
							<div class="embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item"
									src="https://www.youtube.com/embed/${video.href}"
									allowfullscreen></iframe>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="anime__details__text">
							<div class="anime__details__title">
								<h3>${video.title}</h3>
							</div>
							<p>${video.description}</p>
							<div class="anime__details__widget">
								<div class="row">
									<div class="col-lg col-md">
										<ul>
											<li><span>View:</span>${video.views}</li>
											<li><span>Share:</span>${video.share}</li>
										</ul>
									</div>
								</div>
							</div>
							<c:if test="${not empty sessionScope.currentUser}">
								<div class="anime__details__btn">
									<button id="likeOrUnlikeBtn" class="follow-btn"><i class="fa fa-heart-o"></i>
                        	<c:choose>
                        		<c:when test="${flagLikedBtn == true}">
                        			Unlike
                        		</c:when>
                        		<c:otherwise>Like</c:otherwise>
                        	</c:choose>
                        	</button> <button href="#" class="follow-btn"><span>Share</span> <i
										class="fa fa-angle-right"></i></button>
								</div>
							</c:if>
						</div>
					</div>
					<input id="videoIdHdn" type="hidden" value = "${video.href}"/>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	<!-- Product Section End -->

	<!-- Footer Section Begin -->
	<%@include file="/common/footer.jsp"%>
 <script>
	    $('#likeOrUnlikeBtn').click(function(){
			var videoId = $('#videoIdHdn').val();
			$.ajax({
				url: 'video?action=like&id=' + videoId
			}).then(function(data){
				var text = $('#likeOrUnlikeBtn').text();
				if(text.indexOf('Like')!= -1){
					$('#likeOrUnlikeBtn').text('Unlike');
				}else{
					$('#likeOrUnlikeBtn').text('Like');
				}
			}).fail(function(error){
				alert('loi!')
			});
		});
    </script>

</body>

</html>