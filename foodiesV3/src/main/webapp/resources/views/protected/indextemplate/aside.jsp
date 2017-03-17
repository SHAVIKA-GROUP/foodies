<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- ------------------- aside (Left side column. contains the logo and sidebar) ------------------- -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="./resources/assets/ico/ic_launcher.jpg" class="img-circle" alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>FOOD BOX</p>
				<!-- Status -->
				<small><i class="fa fa-circle text-success"></i>&nbsp;<a href="http://www.okuli.in/foodboox">www.okuli.in/foodboox</a></small>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<div>
			<ul class="sidebar-menu" ng-controller="NavbarController">
				<li class="header">NAVIGATION</li>
				<!-- Optionally, you can add icons to the links -->
				<li ng-class="{ active: isActive('/dashboard') }"><a href="#/dashboard"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
				<li ng-class="{ active: isActive('/menu') }"><a href="#/menu"><i class="fa fa-ship"></i> <span>Menu</span></a></li>
				<li ng-class="{ active: isActive('/orders') }"><a href="#/orders"><i class="fa fa-laptop"></i> <span>Order Detail</span></a></li>
				<li ng-class="{ active: isActive('/customers') }"><a href="#/customers"><i class="fa fa-user"></i> <span>Customers</span></a></li>
				<li ng-class="{ active: isActive('/reports') }"><a href="#/reports"><i class="fa fa-pie-chart"></i> <span>Report</span></a></li>
				<li ng-class="header"></li>
				<li ng-class="{ active: isActive('/aboutus') }"><a href="#/aboutus"><i class='fa fa-circle-o text-red'></i> <span>About US</span></a></li>
			</ul>
		</div>
	</section>
</aside>