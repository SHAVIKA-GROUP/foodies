<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Foodies</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS
        ================================================ -->
<!-- Owl Carousel -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/owl.carousel.css'/>"
	type="text/css">
<!-- bootstrap.min css -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/bootstrap.min.css'/>"
	type="text/css">
<!-- Font-awesome.min css -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/font-awesome.min.css'/>"
	type="text/css">
<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/animate.min.css'/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/main.css'/>" type="text/css">
<!-- Responsive Stylesheet -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/responsive.css'/>"
	type="text/css">

<style type="text/css">
#wrapper {
	width: 100%;
}

table {
	width: 100%;
}

th, td {
	width: 700px;
}

thead>tr {
	position: relative;
	width: 97%;
	display: block;
}

tbody {
	display: block;
	height: 300px;
	overflow: auto;
}
</style>
<!-- Js -->
<script
	src="<c:url value='/resources/assets/js/vendor/modernizr-2.6.2.min.js'/>"></script>
<script
	src="<c:url value='/resources/assets/js/vendor/jquery-1.11.1.min.js'/>"></script>

<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>  
    <script>window.jQuery || document.write('<script src="asserts/js/vendor/jquery-1.10.2.min.js"><\/script>')</script> -->

<script src="<c:url value='/resources/assets/js/jquery.nav.js'/>"></script>
<script src="<c:url value='/resources/assets/js/jquery.sticky.js'/>"></script>
<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/assets/js/plugins.js'/>"></script>
<script src="<c:url value='/resources/assets/js/wow.min.js'/>"></script>
<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/assets/js/application.js'/>"></script>
</head>
<body>

	<!--
	header-img start 
	============================== -->
	<section id="hero-area">
		<img src="<c:url value='/resources/assets/images/header2.jpg'/>"
			alt="header.jpg">
	</section>

	<!--
    Header start 
	============================== -->
	<nav id="navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<nav class="navbar navbar-default">
							<div class="container-fluid">
								<!-- Brand and toggle get grouped for better mobile display -->
								<div class="navbar-header">
									<button type="button" class="navbar-toggle collapsed"
										data-toggle="collapse"
										data-target="#bs-example-navbar-collapse-1">
										<span class="sr-only">Toggle navigation</span> <span
											class="icon-bar"></span> <span class="icon-bar"></span> <span
											class="icon-bar"></span>
									</button>
									<a class="navbar-brand" href="#"> <img
										src="<c:url value='/resources/assets/images/logo.png'/>"
										alt="Logo">
									</a>
								</div>
								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse"
									id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav navbar-right" id="top-nav">
										<li><a href="#hero-area">Home</a></li>
										<li><a href="#about-us">Product</a></li>
										<li><a href="#blog">Menu</a></li>
										<li><a href="#price">delivery items</a></li>
										<li><a href="#subscribe">Login</a></li>
										<li><a href="#contact-us">contacts</a></li>
									</ul>
								</div>
								<!-- /.navbar-collapse -->
							</div>
							<!-- /.container-fluid -->
						</nav>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .container close -->
	</nav>
	<!-- header close -->

	<!--
    Slider start
    ============================== -->
	<section id="slider">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block wow fadeInUp" data-wow-duration="500ms"
						data-wow-delay="300ms">
						<div class="title">
							<h3>
								Catalog <span>Items</span>
							</h3>
						</div>
						<div id="owl-example" class="owl-carousel">
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-1.jpg'/>"
									alt="slider-img-1.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-2.jpg'/>"
									alt="slider-img-2.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-3.jpg'/>"
									alt="slider-img-3.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-4.jpg'/>"
									alt="slider-img-4.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-5.jpg'/>"
									alt="slider-img-5.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-6.jpg'/>"
									alt="slider-img-6.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-7.jpg'/>"
									alt="slider-img-7.jpg">
							</div>
							<div>
								<img class="img-responsive"
									src="<c:url value='/resources/assets/images/slider/slider-img-8.jpg'/>"
									alt="slider-img-8.jpg">
							</div>

						</div>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .container close -->
	</section>
	<!-- slider close -->


	<!--
    about-us start
    ============================== -->
	<section id="about-us">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<img class="wow fadeInUp" data-wow-duration="300ms"
							data-wow-delay="400ms"
							src="<c:url value='/resources/assets/images/cooker-img.png'/>"
							alt="cooker-img">
						<h1 class="heading wow fadeInUp" data-wow-duration="400ms"
							data-wow-delay="500ms">
							Your <span>Restaurantâs</span> </br> Website Has To Look <span>Good</span>
						</h1>
						<p class="wow fadeInUp" data-wow-duration="300ms"
							data-wow-delay="600ms">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
							eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
							enim </br> ad minim veniam, quis nostrud exercitation ullamco laboris
							nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
							reprehenderit in </br>voluptate velit esse cillum dolore eu fugiat
							nulla pariatur. Excepteur sint occaecat
						</p>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .containe close -->
	</section>
	<!-- #call-to-action close -->


	<!--
    blog start
    ============================ -->
	<section id="blog">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h1 class="heading">
							Menu <span>items</span> with<span> Price</span>
						</h1>
						<ul>
							<li class="wow fadeInLeft" data-wow-duration="300ms"
								data-wow-delay="300ms">
								<div class="blog-img">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-1.jpg'/>"
										alt="blog-img-1.jpg">
								</div>
								<div class="content-right">
									<h3>
										Puliyogare <br> Rs : <font color="green"><I>30.00</I></font>
									</h3>
									<p>Prepared in true common rice preparation in the S-Indian
										states.</p>
								</div>
							</li>
							<li class="wow fadeInLeft" data-wow-duration="300ms"
								data-wow-delay="400ms">
								<div class="blog-img">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-2.jpg'/>"
										alt="blog-img-2.jpg">
								</div>
								<div class="content-right">
									<h3>
										S-India Meals<br> Rs : <font color="green"><I>50.00</I></font>
									</h3>
									<p>Prepared in true plain rice with some sides...</p>
								</div>
							</li>
							<li class="wow fadeInLeft" data-wow-duration="300ms"
								data-wow-delay="500ms">
								<div class="content-left">
									<h3>
										Veg-fried rice<br> Rs : <font color="green"><I>38.00</I></font>
									</h3>
									<p>Made with rice with some vegetables.</p>
								</div>
								<div class="blog-img-2">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-3.jpg'/>"
										alt="blog-img-3.jpg">
								</div>
							</li>
							<li class="wow fadeInLeft" data-wow-duration="300ms"
								data-wow-delay="600ms">
								<div class="content-left">
									<h3>
										Idle<br> Rs : <font color="green"><I>25.00</I></font>
									</h3>
									<p>Prepared in rava and baking in steam water...</p>
								</div>
								<div class="blog-img-2">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-4.jpg'/>"
										alt="blog-img-4.jpg">
								</div>
							</li>
							<li class="wow fadeInLeft" data-wow-duration="300ms"
								data-wow-delay="700ms">
								<div class="blog-img">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-5.jpg'/>"
										alt="blog-img-5.jpg">
								</div>
								<div class="content-right">
									<h3>
										MasalaDosa<br> Rs : <font color="green"><I>35.00</I></font>
									</h3>
									<p>Prepared in rice and baking in oli's high steam...</p>
								</div>
							</li>
							<li class="wow fadeInUp" data-wow-duration="300ms"
								data-wow-delay="800ms">
								<div class="blog-img">
									<img
										src="<c:url value='/resources/assets/images/blog/blog-img-6.jpg'/>"
										alt="blog-img-6.jpg">
								</div>
								<div class="content-right">
									<h3>
										Poori<br> Rs : <font color="green"><I>20.00</I></font>
									</h3>
									<p>Prepared in true New England fash-ion. Tender all-white
										meat chicken simmered...</p>
								</div>
							</li>
						</ul>
						<a class="btn btn-default btn-more-info wow bounceIn"
							data-wow-duration="500ms" data-wow-delay="1200ms" href="#"
							role="button">More Info</a>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .containe close -->
	</section>
	<!-- #blog close -->


	<!--
    price start
    ============================ -->
	<section id="price">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h1 class="heading wow fadeInUp" data-wow-duration="300ms"
							data-wow-delay="300ms">
							<span>Delivery Order</span> List
						</h1>
						<div class="pricing-list">
							<div id="wrapper">
								<table class="table table-hover">
									<thead class="theader">
										<tr>
											<td class="theads">Sl No</td>
											<td class="theads">Order Id</td>
											<td class="theads">Customer Name</td>
											<td class="theads">Address</td>
											<td class="theads">Phone No</td>
											<td class="theads">Price</td>
											<td class="theads">&nbsp;</td>
											<td class="theads">Status</td>
										</tr>
									</thead>

									<tbody id="spinnerBody" class="tbody">
										<tr>
											<td colspan="2"></td>
											<td colspan="2" align="center"><i
												class="fa fa-spinner fa-spin"
												style="font-size: 50px; color: green""></i> Loading...</td>
											<td colspan="2"></td>
										</tr>
									</tbody>
									<tbody id="dataBody" class="tbody">
									</tbody>
								</table>
							</div>
							<p class="wow fadeInUp" data-wow-duration="300ms"
								data-wow-delay="600ms">&nbsp;</p>
							<a class="btn btn-default pull-right wow bounceIn"
								data-wow-duration="500ms" data-wow-delay="1200ms"
								href="#subscribe" role="button">Login for More Info</a>
						</div>

						<!-- Modal -->
						<div class="modal fade" id="modal7" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header" align="left">
										<h4 class="modal-title" id="myModalLabel">Order Status</h4>
									</div>
									<div class="modal-body">
									<input type="hidden" id="order-status-submit-id" name="order-status-submit-id" value="1" />
										<div class="form-group">
											<div class="col-md-12">
												<p>
												<h4 id='order-status-submit'>Order Items...&hellip;</h4>
												</p>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button class="btn btn-success" id="order-status-submit-btn"
											name="forgot-pwd-submit" type="submit">Submit</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>

						<!-- Modal -->
						<div class="modal fade" id="modal6" tabindex="-1" role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">

									<div class="modal-header">
										<h4 class="modal-title">&nbsp;</h4>
									</div>

									<div class="modal-body">
										<div class="row">
											<div class="col-md-9">
												<h4 class="modal-title">
													<b><p id="oitemmodal-id" align='left'></p></b>
												</h4>
											</div>
											<div class="col-md-3">
												<button type="button" class="btn btn-default pull-right"
													data-dismiss="modal">Close</button>

											</div>
										</div>
										<br />
										<p>
										<h4>Order Items...&hellip;</h4>
										</p>
										<div class="col-md-12">
											<table class="table table-hover">
												<thead>
													<tr>
														<td class="theads">Sl No</td>
														<td class="theads">Food</td>
														<td class="theads">Quantity</td>
														<td class="theads">Price</td>
														<td class="theads">Value</td>
													</tr>
												</thead>
												<tbody id="OrderItemDataBody">
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
					</div>
					<!-- .col-md-12 close -->
				</div>
				<!-- .row close -->
			</div>
			<!-- .containe close -->
	</section>
	<!-- #price close -->


	<!--
    subscribe start
    ============================ -->
	<section id="subscribe">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h1 class=" heading wow fadeInUp" data-wow-duration="300ms"
							data-wow-delay="300ms">
							<span>Login</span>&nbsp;(or)&nbsp;<span>Register</span>
						</h1>
						<div class="col-md-5 col-md-offset-4">
							<div class="alert alert-success" role="alert"
								id='login-alert-div'>
								<strong id='login-alert'>&nbsp;</strong>
							</div>
						</div>
						<form class="form-inline" id="login-form"
							action="loginformService">
							<input type="hidden" id="login-type" name="login-type" value="1" />
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="login-userid"
										name="login-userid" required
										placeholder="Enter your userId...">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="password" class="form-control" id="login-password"
										name="login-password" required
										placeholder="Enter your Password...">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<button class="btn btn-default" id="login-submit"
											name="login-submit" type="submit">Submit</button>
									</div>
								</div>
							</div>
						</form>
						<div class="col-md-4 col-md-offset-4">
							<hr />
						</div>
						<br />
						<p class="wow fadeInUp" data-wow-duration="300ms"
							data-wow-delay="400ms">
							<a class="btn btn-default" href="#" role="button"
								data-toggle="modal" data-target="#myModal">Forgot Password</a>&nbsp;/&nbsp;
							<a class="btn btn-default" href="#" role="button"
								data-toggle="modal" data-target="#myModal1">Register</a>
						</p>
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header" align="left">
										<h4 class="modal-title" id="myModalLabel">Forgot Password</h4>
									</div>
									<form class="form-inline" id="forgot-pwd-form"
										action="forgetformService">
										<input type="hidden" id="forgot-pwd-type"
											name="forgot-pwd-type" value="3" />
										<div class="modal-body">
											<div class="form-group">
												<div class="col-md-12">
													<input type="text" class="form-control"
														id="forgot-pwd-email" name="forgot-pwd-email"
														placeholder="Write your emailress here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<div class="alert alert-success" role="alert"
														id='forgot-alert-div'>
														<strong id='forgot-alert'>&nbsp;</strong>
													</div>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" id="forgot-pwd-submit"
												name="forgot-pwd-submit" type="submit">Send mail</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel1">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header" align="left">
										<h4 class="modal-title" id="myModalLabel">Registration</h4>
									</div>
									<form class="form-inline" id="register-form"
										action="registrationformService">
										<input type="hidden" id="register-type" name="register-type"
											value="2" />
										<div class="modal-body">
											<div class="form-group">
												<div class="col-md-12">
													<input type="text" class="form-control"
														id="register-username" name="register-username"
														placeholder="Write User Name here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<input type="email" class="form-control"
														id="register-email" name="register-email"
														placeholder="Write your email address here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<input type="number" class="form-control"
														id="register-phone" name="register-phone"
														placeholder="Write your phone here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<input type="password" class="form-control"
														id="register-password" name="register-password"
														placeholder="Write Password here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<input type="text" class="form-control"
														id="register-confirm-pwd" name="register-confirm-pwd"
														placeholder="Write Confirm Password here..."> <span
														class="help-block" align="left"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-12">
													<div class="alert alert-success" role="alert"
														id='reg-alert-div'>
														<strong id='reg-alert'>&nbsp;</strong>
													</div>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" id="register-submit"
												name="register-submit" type="submit">Save</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .containe close -->
	</section>
	<!-- #subscribe close -->


	<!--
    CONTACT US  start
    ============================= -->
	<section id="contact-us">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h1 class="heading wow fadeInUp" data-wow-duration="500ms"
							data-wow-delay="300ms">
							our <span>CONTACT US</span>
						</h1>
						<h3 class="title wow fadeInLeft" data-wow-duration="500ms"
							data-wow-delay="300ms">
							Sign Up for <span>Email Alerts</span>
						</h3>
						<form>
							<div class="form-group wow fadeInDown" data-wow-duration="500ms"
								data-wow-delay="600ms">
								<input type="email" class="form-control" id="exampleInputEmail1"
									placeholder="Write your full name here...">
							</div>
							<div class="form-group wow fadeInDown" data-wow-duration="500ms"
								data-wow-delay="800ms">
								<input type="text" class="form-control"
									placeholder="Write your email address here...">
							</div>
							<div class="form-group wow fadeInDown" data-wow-duration="500ms"
								data-wow-delay="1000ms">
								<textarea class="form-control" rows="3"
									placeholder="Write your message here..."></textarea>
							</div>
						</form>
						<a class="btn btn-default wow bounceIn" data-wow-duration="500ms"
							data-wow-delay="1300ms" href="#" role="button">send your
							message</a>
					</div>
				</div>
				<!-- .col-md-12 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .container close -->
	</section>
	<!-- #contact-us close -->


	<!--
    footer  start
    ============================= -->
	<section id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="block wow fadeInLeft" data-wow-delay="200ms">
						<h3>
							CONTACT <span>INFO</span>
						</h3>
						<div class="info">
							<ul>
								<li>
									<h4>
										<i class="fa fa-phone"></i>Telefone
									</h4>
									<p>(+8121) 0821 - 2466006</p>

								</li>
								<li>
									<h4>
										<i class="fa fa-map-marker"></i>Address
									</h4>
									<p>No 28/A, 1st main road, sarasvathi puram, Mysore -
										456001</p>
								</li>
								<li>
									<h4>
										<i class="fa fa-envelope"></i>E mail
									</h4>
									<p>customer-info@foodies.com</p>

								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- .col-md-4 close -->
				<div class="col-md-4">
					<div class="block wow fadeInLeft" data-wow-delay="700ms">
						&nbsp;</div>
				</div>

				<!-- .col-md-4 close -->
				<div class="col-md-4">
					<div class="block wow fadeInLeft" data-wow-delay="1100ms">
						<div class="social-media-link">
							<h3>
								Follow <span>US</span>
							</h3>
							<ul>
								<li><a href="#"> <i class="fa fa-twitter"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-facebook"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-dribbble"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-behance"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- .col-md-4 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .containe close -->
	</section>
	<!-- #footer close -->


	<!--
    footer-bottom  start
    ============================= -->
	<footer id="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="block">
						<p>
							Copyright &copy; 2016-17 - All Rights Reserved. Design and
							Developed By <a href="http://www.shavika.com">Shavika Info
								tech.</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>


</body>
</html>