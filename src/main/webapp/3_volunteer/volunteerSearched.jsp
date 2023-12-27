<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteerNotice</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Kaisei+Decol:wght@400;500;700&family=Poppins:wght@100;200;300;400;800;900&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="3_volunteer/css/volunteerNotice.css" />
</head>
<body>
	<main>
		<div class="top">
			<div class="top-title">
				<img src="3_volunteer/img/SeoulIcon.png" alt="" /> <a
					href="VtSeoulC">
					<p>Seoul</p>
				</a>
			</div>
			<div class="top-btn">
				<form action="VolBtnClickC">
					<button name="searchBtn" value="Recruiting" class="Recruiting">Recruiting</button>
					<button name="searchBtn" value="Completed" class="Completed">Completed</button>
				</form>
			</div>
			<form action="VolSearchSC" method="post" name="keywords-serch"
				id="searchForm">
				<div class="search">
					<img src="3_volunteer/img/SearchIcon.png" alt="돋보기" /> <input
						name="searchTitle"
						placeholder="Is there an article you are looking for?" type="text" />
				</div>
			</form>
		</div>
		<c:forEach items="${searchedVol}" var="v">
			<a href="VolunteerDetailC?no=${v.v_no}">
				<table id="middle">
					<tr class="middle-post">
						<td class="post-left">
							<div class="td-wrapper">
								<div class="post-btn">
									<div class="Recruiting post-btn-txt">
										<p>${v.v_status }</p>
									</div>
								</div>
								<div class="post-text">
									<div class="bigTxt">title: ${v.v_title }</div>
									<div class="smallTxt">description: ${v.v_txt }</div>
								</div>
								<div class="post-info">
									<div class="post-user">
										<img src="3_volunteer/img/profileIcon.png" alt="" />id
									</div>
								</div>
							</div>
						</td>
						<td class="post-img"><img
							src="3_volunteer/newImg/${v.v_img }"></td>
					</tr>
				</table>
			</a>
		</c:forEach>
		<div class="bottom btn">
			<form action="VtWriteC">
				<button>Write</button>
			</form>
			<form action="VtModifyC">
				<button>Modify</button>
			</form>
		</div>

		<div class="bottom paging">
			<a class="pagebox" href="VtPageC?p=1"><img
				src="3_volunteer/img/firstpage.png" alt="" /></a>

			<c:forEach begin="1" end="${pageCount }" var="n">
				<a class="pagebox" href="VtPageC?p=${n }">${n}</a>
			</c:forEach>


			<a class="pagebox" href="VtPageC?p=${pageCount } }"><img
				src="3_volunteer/img/lastpage.png" alt="" /></a>
		</div>
	</main>
</body>
</html>