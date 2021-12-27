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
			<li class="breadcrumb-item active">About</li>
		</ol>
	</div>
</div>
<section>
	<div class="block gray-bg bottom-padd210 top-padd30">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<p>Nowadays, people are busy with their own business, so sometimes they have difficulties in choosing their daily meals. Have you ever asked yourself what/where should you eat for lunch/dinner? Have you ever wanted to break out of the loop of eating the same meal every day just because you don't know what else to eat? Are you the person that goes to the same restaurant and orders the same dishes every day? Or are you the person that has a select phobia on choosing meals? Now, we have an ultra solution for this, which is our new app: Meal Picker(MP). MP is a website that can help users to decide their meals. In traditional food delivery apps, users usually have to spend a lot of time on choosing the restaurant and food, sometimes users will struggle in several restaurants in the search result. In contradiction, MP will significantly reduce the time of choosing meals. First of all, the Meal picker will ask the user's location, food preference, and acceptable price range, then MP will give the best meal that satisfies the requirement based on Yelp Api. Finally users just need to decide to order or give it another try. After all, MP will redirect the user to the checkout page on Yelp, and order food there.</p>
				</div>
				<div class="col-md-5">
					<img src="img/topbg.jpg" />
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="common/footer.jsp"%>