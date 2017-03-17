var indexapp = angular.module('indexApp', [ 'datatables', 'ngRoute', 'ngResource' ]);

/***
 * 
 * 
 */
indexapp.config(function($routeProvider) {
	$routeProvider
	  .when('/dashboard', {
		controller : 'ctrlDashboard',
		templateUrl : './resources/views/protected/dashboard/dashboard.html'
	}).when('/orders', {
		controller : 'ctrlOrders',
		templateUrl : './resources/views/protected/orderdetail/orderslist.html'
	}).when('/menu', {
		controller : 'ctrlMenu',
		templateUrl : './resources/views/protected/menu/menulist.html'
	}).when('/menu/:id', {
		controller : 'ctrlMenudetail',
		templateUrl : './resources/views/protected/menu/menudetail.html'
	}).when('/customers', {
		controller : 'ctrlCustomers',
		templateUrl : './resources/views/protected/customers/customersList.html'
	}).when('/reports', {
		controller : 'ctrlReports',
		templateUrl : './resources/views/protected/reports/reports.html'
	}).when('/aboutus', {
		controller : 'ctrlAboutus',
		templateUrl : './resources/views/protected/aboutus.html'
	}).otherwise({
		redirectTo : '/dashboard'
	});
});

/***
 * 
 * 
 */
indexapp.controller('NavbarController', function($scope, $location) {
	$scope.isActive = function(viewLocation) {
		//console.log('---> $location.path()================>>>>>>' + $location.path() + ' path===============>' + viewLocation);
		var active = (viewLocation === $location.path());
	     return active;
	}
});