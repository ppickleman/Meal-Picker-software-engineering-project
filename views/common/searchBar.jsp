<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<style>
.myselect {
	height: 100%;
	padding: 15px 38px;
	font-size: 11.7px;
	font-family: lato;
	color: #a2a2a2;
	width: 100%;
}
</style>
<form action="search" class="restaurant-search-form brd-rd2">
	<div class="row mrg10">
		<div class="col-md-3 col-sm-3 col-lg-3 col-xs-12">
			<div class="input-field brd-rd2">
				<!-- <input class="brd-rd2" type="text" placeholder="Food type"> -->
				<select name="foodType" class="brd-rd2">
					<option value="All">Food type</option>
					<option value="Korean">Korean</option>
					<option value="Seafood">Seafood</option>
					<option value="Japanese">Japanese</option>
					<option value="Thai">Thai</option>
				</select>
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-lg-3 col-xs-12">
			<div class="input-field brd-rd2">
				<i class="fa fa-map-marker"></i>
				<input name="zip" class="brd-rd2" type="text" placeholder="Search ZIP"/>
				<i class="fa fa-location-arrow"></i>
			</div>
		</div>
		<div class="col-md-2 col-sm-2 col-lg-2 col-xs-12">
			<div class="input-field brd-rd2">
				<input name="minPrice" class="brd-rd2" type="text" placeholder="Min Price" />
			</div>
		</div>
		<div class="col-md-2 col-sm-2 col-lg-2 col-xs-12">
			<div class="input-field brd-rd2">
				<input name="maxPrice" class="brd-rd2" type="text" placeholder="Max Price" />
			</div>
		</div>
		<div class="col-md-2 col-sm-2 col-lg-2 col-xs-12">
			<button class="brd-rd2 red-bg" type="submit">SEARCH</button>
		</div>
	</div>
</form>