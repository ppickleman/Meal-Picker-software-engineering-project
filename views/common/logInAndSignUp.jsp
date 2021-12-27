<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<div class="sign-popup text-center">
	<div class="sign-popup-wrapper brd-rd5">
		<div class="sign-popup-inner brd-rd5">
			<a class="sign-close-btn" href="#" title="" itemprop="url"><i class="fa fa-close"></i></a>
			<div class="sign-popup-title text-center">
				<h4 itemprop="headline">SIGN UP</h4>
				<!-- <span>with your social network</span> -->
			</div>
			<!-- <div class="popup-social text-center">
				<a class="facebook brd-rd3" href="#" title="Facebook" itemprop="url" target="_blank"><i class="fa fa-facebook"></i> Facebook</a> <a class="google brd-rd3" href="#" title="Google Plus" itemprop="url" target="_blank"><i class="fa fa-google-plus"></i> Google</a> <a class="twitter brd-rd3" href="#" title="Twitter" itemprop="url" target="_blank"><i class="fa fa-twitter"></i> Twitter</a>
			</div> -->
			<span class="popup-seprator text-center"><i class="brd-rd50">or</i></span>
			<form class="sign-form" id="signUpForm" method="post">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-lg-12">
						<input class="brd-rd3" type="text" placeholder="Username" name="username">
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<input class="brd-rd3" type="email" placeholder="Email" name="email">
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<input class="brd-rd3" type="password" placeholder="Password" name="password">
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<button class="red-bg brd-rd3" type="button" id="signUpBtn">REGISTER NOW</button>
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<a class="sign-btn" href="#" title="" itemprop="url">Already Registered? Sign in</a> <a class="recover-btn" href="#" title="" itemprop="url">Recover my password</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="log-popup text-center">
	<div class="sign-popup-wrapper brd-rd5">
		<div class="sign-popup-inner brd-rd5">
			<a class="log-close-btn" href="#" title="" itemprop="url"><i class="fa fa-close"></i></a>
			<div class="sign-popup-title text-center">
				<h4 itemprop="headline">SIGN IN</h4>
				<!-- <span>with your social network</span> -->
			</div>
			<!-- <div class="popup-social text-center">
				<a class="facebook brd-rd3" href="#" title="Facebook" itemprop="url" target="_blank"><i class="fa fa-facebook"></i> Facebook</a> <a class="google brd-rd3" href="#" title="Google Plus" itemprop="url" target="_blank"><i class="fa fa-google-plus"></i> Google</a> <a class="twitter brd-rd3" href="#" title="Twitter" itemprop="url" target="_blank"><i class="fa fa-twitter"></i> Twitter</a>
			</div> -->
			<span class="popup-seprator text-center"><i class="brd-rd50">or</i></span>
			<form class="sign-form" id="logInForm" method="post">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-lg-12">
						<input class="brd-rd3" type="text" placeholder="Username or Email" name="username">
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<input class="brd-rd3" type="password" placeholder="Password" name="password">
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<button class="red-bg brd-rd3" type="button" id="signInBtn">SIGN IN</button>
					</div>
					<div class="col-md-12 col-sm-12 col-lg-12">
						<a class="sign-btn" href="#" title="" itemprop="url">Not a member? Sign up</a> <a class="recover-btn" href="#" title="" itemprop="url">Recover my password</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('#signInBtn').click(function() {
			let form = $('#logInForm');
			$.post('logIn', {
				username : form.find('input[name="username"]').val(),
				email : form.find('input[name="username"]').val(),
				password : form.find('input[name="password"]').val()
			}, function(data) {
				if (data.status == 'SUCCESSED') {
					//alert('log in successed');
					location.reload();
				} else {
					alert('log in failed: ' + data.msg);
				}
			}, 'json');
		});

		$('#signUpBtn').click(function() {
			let form = $('#signUpForm');
			$.post('signUp', {
				username : form.find('input[name="username"]').val(),
				email : form.find('input[name="email"]').val(),
				password : form.find('input[name="password"]').val()
			}, function(data) {
				if (data.status == 'SUCCESSED') {
					//alert('sign up successed');
					location.reload();
				} else {
					alert('sign up failed: ' + data.msg);
				}
			}, 'json');
		});
	});
</script>