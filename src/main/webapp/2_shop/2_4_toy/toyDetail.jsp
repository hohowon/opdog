<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Detail</title>
<script type="text/javascript" src="2_shop/js/checkOut2.js"></script>
<script type="text/javascript" src="2_shop/js/shop.js"></script>
<link rel="stylesheet" href="2_shop/css/shopDetail2.css" />
</head>
<body>

	<div class="main">
		<div class="item">
			<div class="item-img-cover">
				<img class="item-img" src="${toy.t_img }">
			</div>
			<div class="item-info">
				<div class="item-brand" id="itemBrand" align="left">${toy.t_brand}</div>
				<div class="item-title" id="itemTitle" align="left">${toy.t_title}</div>
				<div class="item-price-cover">
					<div>Price</div>
					<div class="item-price">${toy.t_price}&nbsp;&#8361;</div>
				</div>
				<input type="hidden" id="itemPrice" value="${toy.t_price}">
				<input type="hidden" id="itemSPrice" value="${toy.t_price/10}">
				<!-- <div>
					<div class="size-txt" align="left">Size</div>
					<div class="size-box-cover">
						<div class="box" onclick="changeColor(this)">
							<div>S</div>
						</div>
						<div class="box" onclick="changeColor(this)">
							<div>M</div>
						</div>
						<div class="box" onclick="changeColor(this)">
							<div>L</div>
						</div>
					</div>
				</div> -->
				<div class="sponsor-btn-cover">
					<div>
						<button class="sponsor-btn" id="goCheckOut"
							value="${sessionScope.account}" onclick="goCheckOut()">sponsor</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>