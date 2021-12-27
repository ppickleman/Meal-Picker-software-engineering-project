<%@page import="com.hongxun.entity.AccountDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Meal Picker</title>
<link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

<link rel="stylesheet" href="css/icons.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/red-color.css">
<link rel="stylesheet" href="css/yellow-color.css">
<link rel="stylesheet" href="css/responsive.css">

<script src="js/jquery.min.js"></script>
</head>
<body itemscope>
	<main>
	<div class="preloader">
		<div id="cooking">
			<div class="bubble"></div>
			<div class="bubble"></div>
			<div class="bubble"></div>
			<div class="bubble"></div>
			<div class="bubble"></div>
			<div id="area">
				<div id="sides">
					<div id="pan"></div>
					<div id="handle"></div>
				</div>
				<div id="pancake">
					<div id="pastry"></div>
				</div>
			</div>
		</div>
	</div>
	<header class="stick">
		<div class="topbar">
			<div class="container">
				<!-- <div class="select-wrp">
					<select data-placeholder="Feel Like Eating">
						<option>FEEL LIKE EATING</option>
						<option>Burger</option>
						<option>Pizza</option>
						<option>Fried Rice</option>
						<option>Chicken Shots</option>
					</select>
				</div>
				<div class="select-wrp">
					<select data-placeholder="Choose Location">
						<option>CHOOSE LOCATION</option>
						<option>New york</option>
						<option>Washington</option>
						<option>Chicago</option>
						<option>Los Angeles</option>
					</select>
				</div> -->
				<div class="topbar-register">
					<%
						if (request.getSession().getAttribute("Account") == null) {
					%>
					<a class="log-popup-btn" href="#" title="Login" itemprop="url">LOGIN</a> / <a class="sign-popup-btn" href="#" title="Register" itemprop="url">REGISTER</a>
					<%
						} else {
					%>
					<a href="#"><%=((AccountDao) request.getSession().getAttribute("Account")).getUserName()%></a> / <a href="logOut">SIGN OUT</a>
					<%
						}
					%>
				</div>
				<%
					if (request.getSession().getAttribute("Account") != null) {
				%>
					<div class="topbar-register">
						<a href="viewOrderHistory">Order History</a>
					</div>
				<%} %>
				<!-- <div class="social1">
					<a href="#" title="Facebook" itemprop="url" target="_blank"> <i class="fa fa-facebook-square"></i>
					</a> <a href="#" title="Twitter" itemprop="url" target="_blank"> <i class="fa fa-twitter"></i>
					</a> <a href="#" title="Google Plus" itemprop="url" target="_blank"> <i class="fa fa-google-plus"></i>
					</a>
				</div> -->
			</div>
		</div>
		<!-- Topbar -->
		<div class="logo-menu-sec">
			<div class="container">
				<div class="logo">
					<h1 itemprop="headline">
						<a href="index" title="Home" itemprop="url"> <img src="img/logo2.png" alt="logo.png" itemprop="image">
						</a>
					</h1>
				</div>
				<nav>
					<div class="menu-sec">
						<ul>
							<li class="menu-item-has-children"><a href="#" title="RESTAURANTS" itemprop="url"> <span class="red-clr">&nbsp;</span> <a href="index">HOME</a></li>
							<li class="menu-item-has-children"><a href="#" title="RESTAURANTS" itemprop="url"> <span class="red-clr">&nbsp;</span> <a href="about">About</a></li>
							<li class="menu-item-has-children"><a href="#" title="RESTAURANTS" itemprop="url"> <span class="red-clr">&nbsp;</span> <a href="contact">Contact</a></li>
							<li class="menu-item-has-children"><a href="#" title="RESTAURANTS" itemprop="url"> <span class="red-clr">&nbsp;</span> <a href="help">Help</a></li>
						</ul>
						<!-- <a class="red-bg brd-rd4" href="#" title="Register" itemprop="url">REGISTER RESTAURANT</a> -->
					</div>
				</nav>
				<!-- Navigation -->
			</div>
		</div>
		<!-- Logo Menu Section -->
	</header> <!-- Header -->

	<div class="responsive-header">
		<div class="responsive-topbar">
			<div class="select-wrp">
				<select data-placeholder="Feel Like Eating">
					<option>FEEL LIKE EATING</option>
					<option>Burger</option>
					<option>Pizza</option>
					<option>Fried Rice</option>
					<option>Chicken Shots</option>
				</select>
			</div>
			<div class="select-wrp">
				<select data-placeholder="Choose Location">
					<option>CHOOSE LOCATION</option>
					<option>New york</option>
					<option>Washington</option>
					<option>Chicago</option>
					<option>Los Angeles</option>
				</select>
			</div>
		</div>
		<div class="responsive-logomenu">
			<div class="logo">
				<h1 itemprop="headline">
					<a href="index" title="Home" itemprop="url"> <img src="img/logo.png" alt="logo.png" itemprop="image" />
					</a>
				</h1>
			</div>
			<span class="menu-btn yellow-bg brd-rd4"><i class="fa fa-align-justify"></i></span>
		</div>
		<div class="responsive-menu">
			<span class="menu-close red-bg brd-rd3"><i class="fa fa-close"></i></span>
			<div class="menu-lst">
				<ul>
					<li class="menu-item-has-children"><a href="#" title="HOMEPAGES" itemprop="url"> <span class="yellow-clr">FOOD ORDERING</span> <a href="index">HOME</a></li>
					<li class="menu-item-has-children"><a href="#" title="HOMEPAGES" itemprop="url"> <span class="yellow-clr">FOOD ORDERING</span> <a href="about">About</a></li>
					<li class="menu-item-has-children"><a href="#" title="HOMEPAGES" itemprop="url"> <span class="yellow-clr">FOOD ORDERING</span> <a href="contact">Contact</a></li>
					<li class="menu-item-has-children"><a href="#" title="HOMEPAGES" itemprop="url"> <span class="yellow-clr">FOOD ORDERING</span> <a href="help">Help</a></li>
				</ul>
			</div>
			<div class="topbar-register">
				<a class="log-popup-btn" href="#" title="Login" itemprop="url">LOGIN</a> / <a class="sign-popup-btn" href="#" title="Register" itemprop="url">REGISTER</a>
			</div>
			<div class="social1">
				<a href="#" title="Facebook" itemprop="url" target="_blank"> <i class="fa fa-facebook-square"></i>
				</a> <a href="#" title="Twitter" itemprop="url" target="_blank"> <i class="fa fa-twitter"></i>
				</a> <a href="#" title="Google Plus" itemprop="url" target="_blank"> <i class="fa fa-google-plus"></i>
				</a>
			</div>
			<div class="register-btn">
				<a class="yellow-bg brd-rd4" href="#" title="Register" itemprop="url">REGISTER RESTAURANT</a>
			</div>
		</div>
		<!-- Responsive Menu -->
	</div>