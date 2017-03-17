indexapp.controller('employeeListCtrl', function($scope, $window, $location, $http, DTOptionsBuilder, API_URL) {
	console.log("=================> calling employeeListCtrl ...");
	var employeeList = API_URL + '/employee/';

	$scope.editItem = function(employee) {
		$location.url('/employeedetails/' + employee.id);
	}

	$scope.addItem = function() {
		$location.url('/employeedetails/0');
	}

	loadAllEmployee();

	function loadAllEmployee() {

		// DataTables configurable options
		$scope.dtOptions = DTOptionsBuilder.newOptions().withDisplayLength(10).withOption('autoWidth', true).withOption('info', true)
				.withOption('paging', true).withOption('processing', true).withOption('bLengthChange', true);

		$scope.loading = true;
		// calling http service.
		$http.get(employeeList).success(function(data, status, headers, config) {
			console.log("=================> Rest response [SUCCESS] status=" + status);
			console.log("=================> Rest response [SUCCESS] DATA=" + data);
			$scope.loading = false;
			$scope.employees = data;
		}).error(function(data, status, headers, config) {
			console.log("=================> Rest response [FAIL] DATA/status=" + status);
			$scope.loading = false;
		});
	}

});

indexapp.controller('employeeDetailsCtrl', function($scope, $location, $http, $routeParams, API_URL) {
	console.log("=================> calling employeeDetailsCtrl ...");
	var id = $routeParams.id;
	var employeeDetails = API_URL + '/employee/' + id;
	$scope.deleteButton = false;

	console.log("=================> calling employeeDetailsCtrl .../employeeDetails=" + employeeDetails);
	console.log("=================> calling employeeDetailsCtrl .../id=" + id);

	$scope.designations = [{id : 0, name : '--- select ---'},
	                       {id : 1, name : 'Manager'},
	                       {id : 2, name : 'CEO'},
	                       {id : 3, name : 'Developer'},
	                       {id : 4, name : 'Manager'},
	                       {id : 5, name : 'Tester'},
	                       {id : 6, name : 'Markering'},
	                       {id : 7, name : 'Human Resource'},
	                       {id : 8, name : 'Administrator'}];

	$scope.categorys = [{id : 0, name : '--- select ---'},
	                    {id : 1, name : 'Parmanent'},
	                    {id : 2, name : 'Contractor'},
	                    {id : 3, name : 'InternShip'},
	                    {id : 4, name : 'Daily Bases'}];

	$scope.genders = [{id : 'm', name : 'Male'},
	                  {id : 'f', name : 'Female'}];
	
	$scope.orgainzationsTree = [{id : 0, name : '--- select ---'},
	                            {id : 1, name : 'Company-1'},
	                            {id : 2, name : ' Department-1'},
	                            {id : 3, name : ' Department-2'},
	                            {id : 4, name : 'Company-2'},
	                            {id : 4, name : ' Department-3'},
	                            {id : 4, name : 'Company-3'},
	                            {id : 4, name : ' Department-2'},
	                            {id : 4, name : '  SubDepartment-1'},
	                            {id : 4, name : '  SubDepartment-1'},
	                            {id : 4, name : 'Company-4'}];

	
	if (id == 0) {
		$scope.detailButton = " Save ";
		$scope.deleteButton = false;
		$scope.selectedDesignation = $scope.designations[0].id;
		$scope.selectedCategory = $scope.categorys[0].id;
		$scope.selectedOrgainzation = $scope.orgainzationsTree[0].id;
	} else {
		$scope.detailButton = " Edit ";
		$scope.deleteButton = true;
		$scope.selectedDesignation = $scope.designations[4].id;
		$scope.selectedCategory = $scope.categorys[2].id;
		$scope.selectedOrgainzation = $scope.orgainzationsTree[5].id;
		
		$http.get(employeeDetails).success(function(data, status, headers, config) {
			console.log("=================> Rest response DATA/data=" + data);
			$scope.employee = data;
		}).error(function(data, status, headers, config) {
			console.log("=================> Rest response DATA/status=" + status);
		});

	}

});
