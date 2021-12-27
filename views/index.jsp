<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jsp"%>
<!-- Responsive Header -->
<section>
	<div class="block">
		<div style="background-image: url(img/topbg.jpg);" class="fixed-bg"></div>
		<div class="restaurant-searching text-center">
			<div class="restaurant-searching-inner">
				<h2 itemprop="headline">
					Give you <span>better and faster</span> choice
				</h2>
				<%@ include file="common/searchBar.jsp"%>
				<div class="funfacts">
					<div class="col-md-3 col-sm-6 col-lg-3">
						<div class="fact-box">
							<i class="brd-rd50"><img src="img/resource/fact-icon1.png" alt="fact-icon1" itemprop="image"></i>
							<div class="fact-inner">
								<strong><span class="counter">7</span></strong>
								<h5>Restaurant</h5>
							</div>
						</div>
						<!-- Fact Box -->
					</div>
					<div class="col-md-3 col-sm-6 col-lg-3">
						<div class="fact-box">
							<i class="brd-rd50"><img src="img/resource/fact-icon2.png" alt="fact-icon2" itemprop="image"></i>
							<div class="fact-inner">
								<strong><span class="counter">37</span></strong>
								<h5>Food</h5>
							</div>
						</div>
						<!-- Fact Box -->
					</div>
					<div class="col-md-3 col-sm-6 col-lg-3">
						<div class="fact-box">
							<i class="brd-rd50"><img src="img/resource/fact-icon3.png" alt="fact-icon3" itemprop="image"></i>
							<div class="fact-inner">
								<strong><span class="counter">20</span></strong>
								<h5>Happy Service</h5>
							</div>
						</div>
						<!-- Fact Box -->
					</div>
					<div class="col-md-3 col-sm-6 col-lg-3">
						<div class="fact-box">
							<i class="brd-rd50"><img src="img/resource/fact-icon4.png" alt="fact-icon4" itemprop="image"></i>
							<div class="fact-inner">
								<strong><span class="counter">3</span></strong>
								<h5>Regular users</h5>
							</div>
						</div>
						<!-- Fact Box -->
					</div>
				</div>
				<!-- Fun Facts -->
			</div>
			<img class="left-scooty-mockup" src="img/resource/restaurant-mockup1.png" alt="restaurant-mockup1.png" itemprop="image"> <img class="bottom-clouds-mockup" src="img/resource/clouds.png" alt="clouds.png" itemprop="image">
		</div>
		<!-- Restaurant Searching -->
	</div>
</section>
<%@ include file="common/footer.jsp"%>