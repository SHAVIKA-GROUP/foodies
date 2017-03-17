/***
 * 
 * 
 */
indexapp.controller('ctrlCustomers', function($scope, $location, $http) {
	console.log("=================> calling ctrlCustomers ...");
});

indexapp.controller('customersListCtrl', function($scope, $window, $location, $http, DTOptionsBuilder) {
	console.log("=================> calling customersListCtrl ...");
	var customersList = './customersService';

	loadAllCustomers();

	function loadAllCustomers() {
		$scope.dtOptions = DTOptionsBuilder.newOptions().withDisplayLength(10).withOption('autoWidth', true).withOption('info', true)
				.withOption('paging', true).withOption('processing', true).withOption('bLengthChange', true);
		$scope.loading = true;
		$http.get(customersList).success(function(data, status, headers, config) {
			console.log("=================> Rest response [SUCCESS] status=" + status);
			console.log("=================> Rest response [SUCCESS] DATA=" + data);
			$scope.loading = false;
			$scope.customers = data;
		}).error(function(data, status, headers, config) {
			console.log("=================> Rest response [FAIL] DATA/status=" + status);
			$scope.loading = false;
		});
	}
});

