<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html ng-app="indexApp">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>FoodBox | Dashboard</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<link href="<c:url value='/resources/assets/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/assets/dist/css/AdminLTE.min.css'/>" rel="stylesheet" type="text/css" />
<!-- DataTables -->
<link href="<c:url value='/resources/assets/plugins/datatables/dataTables.bootstrap.css'/>" rel="stylesheet" type="text/css" />
<!-- Check Box -->
<link href="<c:url value='/resources/assets/plugins/iCheck/square/_all.css'/>" rel="stylesheet" type="text/css" />
<!-- Date picker -->
<link href="<c:url value='/resources/assets/plugins/datepicker/datepicker3.css'/>" rel="stylesheet" type="text/css" />


<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="<c:url value='/resources/assets/ico/favicon.jpg'/>">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/assets/ico/apple-touch-icon-144-precomposed.jpg'/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/resources/assets/ico/apple-touch-icon-114-precomposed.jpg'/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/resources/assets/ico/apple-touch-icon-72-precomposed.jpg'/>">
<link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/assets/ico/apple-touch-icon-57-precomposed.jpg'/>">
<script type="application/x-javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
<link href="<c:url value='/resources/assets/dist/css/skins/skin-purple.min.css'/>" rel="stylesheet" type="text/css" />
<style>
  div.scroll  { 
     width:100%;
     overflow-y:scroll;
     height:300px;
  }
  div.scrollPage  { 
     width:100%;
     overflow-y:scroll;
     height:250px;
  }
  
  #mydiv {  
    position:absolute;
    top:0;
    left:0;
    width:100%;
    height:100%;
    z-index:1000;
    background-color:grey;
    opacity: .8;
 }

.ajax-loader {
    position: absolute;
    left: 50%;
    top: 50%;
    margin-left: -32px; /* -1 * image width / 2 */
    margin-top: -32px;  /* -1 * image height / 2 */
    display: block;     
}
</style>
</head>
<body class="fixed skin-purple sidebar-mini" ng-cloak>
	<div class="wrapper">
		<jsp:include page="indextemplate/header.jsp"></jsp:include>
		<jsp:include page="indextemplate/aside.jsp"></jsp:include> 
		<div class="content-wrapper">
			<div ng-view></div>
		</div>
		<jsp:include page="indextemplate/footer.jsp"></jsp:include>
	</div>


	<!-- REQUIRED JS SCRIPTS -->
	<script src="<c:url value='/resources/assets/plugins/jQuery/jQuery-2.1.4.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/dist/js/app.min.js'/>" type="text/javascript"></script>

	<script src="<c:url value='/resources/assets/anjularjs/angular.min.js' />"></script>
	<script src="<c:url value='/resources/assets/anjularjs/angular-route.min.js' />"></script>
	<script src="<c:url value='/resources/assets/anjularjs/angular-resource.min.js' />"></script>


	<!-- FastClick -->
	<script src="<c:url value='/resources/assets/plugins/fastclick/fastclick.min.js'/>" type="text/javascript"></script>

	<!-- Sparkline -->
	<script src="<c:url value='/resources/assets/plugins/sparkline/jquery.sparkline.min.js'/>" type="text/javascript"></script>

	<!-- jvectormap -->
	<script src="<c:url value='/resources/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>" type="text/javascript"></script>

	<!-- SlimScroll 1.3.0 -->
	<script src="<c:url value='/resources/assets/plugins/slimScroll/jquery.slimscroll.min.js'/>" type="text/javascript"></script>

	<!-- ChartJS 1.0.1 -->
	<script src="<c:url value='/resources/assets/plugins/chartjs/Chart.min.js'/>" type="text/javascript"></script>

	<!-- Full feature DataTables -->
	<script src="<c:url value='/resources/assets/plugins/datatables/jquery.dataTables.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/datatables/angular-datatables.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/datatables/dataTables.bootstrap.min.js'/>" type="text/javascript"></script>

	<!-- InputMask -->
	<script src="<c:url value='/resources/assets/plugins/input-mask/jquery.inputmask.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/input-mask/jquery.inputmask.date.extensions.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/plugins/input-mask/jquery.inputmask.extensions.js' />" type="text/javascript"></script>

	<!-- iCheck 1.0.1 -->
	<script src="<c:url value='/resources/assets/plugins/iCheck/icheck.min.js' />" type="text/javascript"></script>

	<!-- bootstrap date picker -->
	<script src="<c:url value='/resources/assets/plugins/datepicker/bootstrap-datepicker.js' />" type="text/javascript"></script>

	<script src="<c:url value='/resources/views/protected/indexRoute.js' />"></script>
	<script src="<c:url value='/resources/views/protected/dashboard/dashboard.app.js' />"></script>
	<script src="<c:url value='/resources/views/protected/orderdetail/orders.app.js' />"></script>
	<script src="<c:url value='/resources/views/protected/menu/menu.app.js' />"></script>
	<script src="<c:url value='/resources/views/protected/customers/customers.app.js' />"></script>
</body>
</html>