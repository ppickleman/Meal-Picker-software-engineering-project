<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.hongxun.entity.OrderItemDao"%>
<%@page import="com.hongxun.entity.OrderDao"%>
<%@page import="java.util.List"%>
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
			<li class="breadcrumb-item"><a href="index" title="" itemprop="url">Account</a></li>
			<li class="breadcrumb-item active">Order History</li>
		</ol>
	</div>
</div>
<style>
.mp-item {
	background-color: white;
	margin: 20px 0;
	/*display: none;*/
}

.mp-item.active {
	/*display: block;*/
}

.mp-container ul {
	list-style: none;
}

.mp-container ul li p {
	margin-left: 5px;
}

.mp-container hr {
	margin-top: 0;
}

.mp-btn {
	cursor: pointer;
	background-color: #CCC;
	padding: 5px 30px;
	display: inline-block;
	margin-bottom: 20px;
	margin-right: 10px;
}
</style>
<script>
$(function(){
	$('.mp-container').on('click', '.orderBtn', function() {
		let _this = $(this).parent().parent().parent();
		let rId = _this.find('input[name="rId"]').val();
		let ul = _this.find('.mp-foodList li');
		let foods = [];
		let prices = [];
		for (let i = 0; i < ul.length; i++) {
			foods.push($(ul[i]).attr('dataId'));
			prices.push($(ul[i]).attr('dataPrice'));
		}
		$.post('orderMeal', {
			rId: rId,
			foods: foods,
			prices: prices
		}, function(data){
			if(data.status == 'SUCCESSED')
				location.reload();
		});
	});
});
</script>
<section>
	<div class="block gray-bg bottom-padd210 top-padd30">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-lg-12 mp-container">
					<%
						List<OrderDao> orders = (List<OrderDao>) request.getAttribute("OrderList");
						for (int i = 0; i < orders.size(); i++) {
					%>
					<div class="mp-item">
						<input type="hidden" name="rId" value="<%=orders.get(i).getRestaurant().getId() %>"/>
						<div class="row">
							<div class="col-md-4">
								<img src="img/restaurantPic/<%=orders.get(i).getRestaurant().getImgSrc() == null || orders.get(i).getRestaurant().getImgSrc().length() == 0 ? "most-popular-img1-1.png" : orders.get(i).getRestaurant().getImgSrc()%>" />
							</div>
							<div class="col-md-8">
								<h3><a target="_blank" href="<%=orders.get(i).getRestaurant().getUrl()%>"><%=orders.get(i).getRestaurant().getName()%></a></h3>
								<ul class="mp-foodList">
									<%
										double total = 0;
										for (OrderItemDao item : orders.get(i).getOrderItemSet()) {
											total += item.getPrice();
									%>
										<li dataPrice="<%=item.getPrice()%>" dataId="<%=item.getFood().getId()%>"><%=item.getFood().getName()%>
										<p>$<%=item.getPrice()%></p></li>
									<%
										}
									%>
								</ul>
								<hr />
								<ul>
									<li>Total<p>$<%=total%></p></li>
								</ul>
								<hr />
								<ul>
									<li>Order Time<p><%=DateFormat.getInstance().format(orders.get(i).getOrderTime())%></p></li>
								</ul>
								<div class="clearfix"></div>
								<a class="orderBtn mp-btn" target="_blank" href="<%=orders.get(i).getRestaurant().getOrderUrl()%>">Order Again</a>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- <section>
	<div class="block no-padding red-bg">
		<img class="bottom-clouds-mockup" src="img/resource/clouds2.png" alt="clouds2.png" itemprop="image">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-lg-12">
					<div class="app-sec">
						<div class="row">
							<div class="col-md-4 hidden-sm col-md-offset-1 col-sm-4 col-sm-offset-0 col-lg-4 col-lg-offset-1">
								<div class="app-mockup text-right overlape-110 wow fadeInUp" data-wow-delay="0.2s">
									<img src="img/resource/app-mockup.png" alt="app-mockup.png" itemprop="image">
								</div>
							</div>
							<div class="col-md-6 col-md-offset-1 col-sm-12 col-sm-offset-0 col-lg-6 col-lg-offset-1">
								<div class="app-info">
									<h4 itemprop="headline">The Best Food Delivery App</h4>
									<p itemprop="description">We have a launch team that focuses on one city at a time. At the end of the day, we're a marketplace. In order to make an effective marketplace, you need critical mass. We need enough restaurants that quality and variety</p>
									<div class="app-download-btns">
										<a href="#" title="Google Play Store" itemprop="url" target="_blank"><img src="img/resource/app-download-btn1.png" alt="app-download-btn1.png" itemprop="image"></a> <a href="#" title="Apple App Store" itemprop="url" target="_blank"><img src="img/resource/app-download-btn2.png" alt="app-download-btn2.png" itemprop="image"></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section> -->
<%@ include file="common/footer.jsp"%>