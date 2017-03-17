/***
 * 
 * 
 */
indexapp.controller('ctrlDashboard', function($scope, $location, $http) {
	console.log("=================> calling ctrlDashboard ...");
});

/***
 * 
 * 
 */
indexapp.controller('dashboardctrlOne', function($scope, $location, $http, $interval, $filter) {
	console.log("=================> calling ctrl_dashboardctrlOne ...");
	
	var servicepath = './syncDashboard';
	var servicepath1 = './menuserviceforDashboard';
	syncDashboard();
	function syncDashboard() {
		$http.get(servicepath)
		.success(function(data, status, headers, config) {
			//console.log("=================> Rest response [SUCCESS] status=" + data);
			angular.forEach(data, function(item){
                //console.log(item);
				if(item.service === 'customer'){ $scope.user_registred = item.size; }
				else if(item.service === 'INIT'){ $scope.PLCD_size = item.size; $scope.PLCD_percentage = item.percentage; $scope.PLCD_all = item.all; }
				else if(item.service === 'CNFD'){ $scope.CNFD_size = item.size; $scope.CNFD_percentage = item.percentage; $scope.CNFD_all = item.all; }
				else if(item.service === 'RJKD'){ $scope.RJKD_size = item.size; $scope.RJKD_percentage = item.percentage; $scope.RJKD_all = item.all; }
				else if(item.service === 'DLRD'){ $scope.DLRD_size = item.size; $scope.DLRD_percentage = item.percentage; $scope.DLRD_all = item.all; }
            })
		}).error(function(data, status, headers, config) {
			//console.log("=================> Rest response [FAIL] DATA/status=" + status);
		});
		/*****************************/
		$http.get(servicepath1)
		.success(function(data, status, headers, config) {
			//console.log("=================> Rest response [SUCCESS] status=" + data);
			$scope.menulist = data;
		}).error(function(data, status, headers, config) {
			//console.log("=================> Rest response [FAIL] DATA/status=" + status);
		});
	}
	
	$scope.callStyle = function(percentage) {
        //console.log("$scope.callStyle - "+percentage);
        return 'width:'+percentage+'%';
    }
	
	
	$scope.callAtTimeout = function() {
        console.log("$scope.callAtTimeout - Timeout occurred");
    }

	/*********/
	$scope.checksunday = function(millisec){
		//var dateParts = date.split("/");
		//var dateObject = new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
		var dateObject = new Date(millisec);
		var day = dateObject.getDay();
		return (day === 0) ? "small-box bg-yellow" : ((day === 6) ? "small-box bg-blue" : "small-box bg-aqua");
		
	}
	/*********/
	$scope.getFormatedDate = function(millisec) {
		return $filter('date')(new Date(millisec), 'dd/MMM/yyyy');
	};

	$interval(function(){ syncDashboard(); }, 20000);
  //$timeout( function(){ $scope.callAtTimeout(); }, 3000);

});

