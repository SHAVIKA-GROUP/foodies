<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html ng-app="loginApp">
<head>
<meta charset="UTF-8">
<title>FoodBox | Log in</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<link href="<c:url value='/resources/assets/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/assets/dist/css/AdminLTE.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/assets/plugins/iCheck/square/blue.css'/>" rel="stylesheet" type="text/css" />

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="<c:url value='/resources/assets/ico/favicon.jpg' />">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/assets/ico/apple-touch-icon-144-precomposed.jpg' />">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/resources/assets/ico/apple-touch-icon-114-precomposed.jpg' />">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/resources/assets/ico/apple-touch-icon-72-precomposed.jpg' />">
<link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/assets/ico/apple-touch-icon-57-precomposed.jpg' />">

<script type="application/x-javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
</head>

<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<img src="./resources/assets/image/logo.jpg" width="65%" height="55%"  class="img-rounded" alt="product logo">
		</div>
		<div ng-view></div>
	</div>

	<script src="<c:url value='/resources/assets/plugins/jQuery/jQuery-2.1.4.min.js' />">
		
	</script>
	<script src="<c:url value='/resources/assets/bootstrap/js/bootstrap.min.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/iCheck/icheck.min.js' />" type="text/javascript"></script>

	<script src="<c:url value='/resources/assets/anjularjs/angular.min.js' />"></script>
	<script src="<c:url value='/resources/assets/anjularjs/angular-route.min.js' />"></script>
	<script src="<c:url value='/resources/views/public/loginController.js' />"></script>
</body>
</html>