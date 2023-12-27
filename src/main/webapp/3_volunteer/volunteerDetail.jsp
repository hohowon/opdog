<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="3_volunteer/css/volunteerDetail.css" />
</head>
<body>
	<form class="container" action="VolunteerDetailC" method="post"
		enctype="multipart/form-data">
		<main>
			<div id="DetailTbl">
				<div class="statusWrap">
					<div class="post-status">
						<p>${vol.v_status }</p>
					</div>
				</div>
				<div>
					<div class="post-title">${vol.v_title }</div>
				</div>

				<div class="imgWrapper">
					<img src="3_volunteer/newImg/${vol.v_img }" />
				</div>

				<div class="post-txt">
					<p>${vol.v_txt }</p>
				</div>
					<div class="btnWrap">
						<button type="button" onclick="location.href='VSeoulC'">Go list</button>

						<button type="button"
							onclick="location.href='VolunteerModiC?no=${volunteer.v_no}'">
							Modify</button>

						<button type="button"
							onclick="location.href='VolunteerDelC?no=${volunteer.v_no}'">
							Delete</button>
					</div>
			</div>
		</main>
	</form>

</body>
</html>
