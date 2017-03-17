<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- ------------------- Header ------------------- -->
<header class="main-header">
	<a href="" class="logo"> 
		<span class="logo-mini">
		<b><img src="./resources/assets/ico/apple-touch-icon-144-precomposed.jpg" width="70%" height="65%"  class="img-rounded" alt="product logo" /></b></span>
		<span class="logo-lg">
		<b><img src="./resources/assets/image/logo.jpg" width="80%" height="35%"  class="img-rounded" alt="product logo" /></b></span>
	</a>
	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="" class="dropdown-toggle" data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="resources/assets/image/user2-160x160.png" class="user-image" alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-sm">${user.username}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="resources/assets/image/user2-160x160.png" class="img-circle" alt="User Image" />
							<p>
								<span class="hidden-md">${user.email}</span><small>[ Admin ]</small>
							</p>
							</li>
						<!-- Menu Footer-->
						<li class="user-footer clearfix">
							<div class="col-md-6 pull-left">
								<a href="" class="btn bth-lg btn-block bg-olive btn-flat "><span>Profile</span></a>
							</div>
							<div class="col-md-6 pull-right">
								<a href="<c:url value="j_spring_security_logout" />" class="btn bth-lg btn-block btn-danger btn-flat"><span>SignOut</span></a>
							</div>
						</li>
					</ul>
				</li>
				<li><a data-toggle="control-sidebar">&nbsp;</a></li>
			</ul>
		</div>
	</nav>
</header>