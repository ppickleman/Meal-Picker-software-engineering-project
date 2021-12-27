<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jsp"%>
<section>
	<div class="block">
		<div class="fixed-bg" style="background-image: url(img/topbg.jpg);"></div>
		<div class="page-title-wrapper text-center">
			<div class="col-md-12 col-sm-12 col-lg-12">
				<div class="page-title-inner">
					<h1 itemprop="headline">Search Your Favourite Food</h1>
					<%@ include file="common/searchBar.jsp"%>
				</div>
			</div>
		</div>
	</div>
</section>
<div class="bread-crumbs-wrapper">
	<div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index" title="" itemprop="url">Home</a></li>
			<li class="breadcrumb-item active">Contact</li>
		</ol>
	</div>
</div>
<style>
.mp-map iframe {
	width: 100%;
	min-height: 500px;
	margin-bottom: 20px;
}
</style>
<section>
	<div class="block gray-bg bottom-padd210 top-padd30">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mp-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3023.1535013278226!2d-73.82227808434412!3d40.73664774404365!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2605db418b9cd%3A0xac786f794a018877!2sQueens%20College%2C%20City%20University%20of%20New%20York!5e0!3m2!1sen!2sus!4v1639346109959!5m2!1sen!2sus"></iframe>
					<h4>65-30 Kissena Blvd</h4>
					<h4>Queens</h4>
					<h4>NY 11367</h4>
					<a href="tel:(718) 997-3566">(718) 997-3566</a>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="common/footer.jsp"%>