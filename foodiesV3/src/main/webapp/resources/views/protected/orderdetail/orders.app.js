/***
 * 
 * 
 */
indexapp.controller('ctrlOrders', function($scope, $location, $http) {
	console.log("=================> calling ctrlOrders ...");
});

/***
 * 
 * 
 */
indexapp.factory('ordersFactory', ['$http', function($http) {

    var urlBase = './ordersService';
    var dataFactory = {};

    dataFactory.getOrders = function () {
        return $http.get(urlBase);
    };
    dataFactory.getOrders = function (id) {
        return $http.get(urlBase + '/' + id);
    };
    dataFactory.insertOrders = function (data) {
        return $http.post(urlBase, data);
    };
    dataFactory.updateOrders = function (id, data) {
        return $http.put(urlBase + '/' + id, data)
    };
    dataFactory.deleteOrders = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    return dataFactory;
}]);

/***
 * 
 * 
 */
//indexapp.controller('ordersListCtrl', ['$scope', '$window', '$location', '$http', 'DTOptionsBuilder', 'ordersFactory', function($scope, $window, $location, $http, DTOptionsBuilder, ordersFactory) {
indexapp.controller('ordersListCtrl', function($scope, $window, $location, $http, DTOptionsBuilder) {
	var ordersList = './ordersService';
	$scope.orderitems = {};
	
	/*********/
	$scope.viewItem = function(order) {
		$scope.orderitems = order.orderitems;
		$scope.menus = order.menus;
	}

	
	/*********/
	$scope.goFilterOrdre = function() {
		console.log("=================> calling search ...");
		
	}

	/*********/
	$scope.viewConfig = function(order) {
		console.log("=================> calling viewConfig ...");
		$('#mydivloader').show();
		$scope.isDisabled = false;
		$scope.model_order_id=order.orders.order_item_id;
		$scope.model_order_status=order.orders.order_status;
	}
	/*********/
	$scope.getModuleConfigStatus = function() {
		//console.log("=================> calling viewConfig/111 ...");
		var _status = $scope.model_order_status;
		//console.log("=================> calling viewConfig/222 ..."+_status);
		_status = (_status === 'PLCD' || _status === 'INIT') ? 'Confirm' : ((_status === 'CNFD') ? 'Deviveried' : ((_status === 'DLRD') ? 'Received' : 'Reject')) ;
		return _status;
	}
	
	/*********/
	$scope.getQuantity = function(foodid) {
		angular.forEach($scope.orderitems, function (value, key) {
			//console.log(foodid + ": " + value.food_id + ": " + value.quantity);
			if(foodid === value.food_id){
				//console.log('----------- ID selected ---------------'+value.quantity+":"+value.order_item_id);
				return value.quantity;
			}
			//console.log(key + ": " + value.order_item_id + ": " + value.food_id + ": " + value.quantity);
		}); 
		//console.log('----------- ID END ---------------');
		return '-';
	}
	/*********/
	$scope.getMenyType = function(menutype) {
		if(menutype === 1){ return "BreakFast" }
		else if(menutype === 2){ return "Lunch" }
		else if(menutype === 3){ return "Dinner" }
		else return 'N/A'
	}
	/*********/
	$scope.getMenyTypeIcon = function(menutype) {
		if(menutype === 1){ return "fa fa-circle-thin" }
		else if(menutype === 2){ return "fa fa-adjust" }
		else if(menutype === 3){ return "fa fa-circle" }
		else return 'fa fa-stop'
	}

	/*********/
	$scope.getStatusColor = function(status) {
		if(status === 'PLCD'){ return "btn btn-sm btn-primary btn-flat pull-center" }
		else if(status === 'INIT'){ return "btn btn-sm btn-info btn-flat pull-center" }
		else if(status === 'CNFD'){ return "btn btn-sm btn-info btn-warning pull-center" }
		else if(status === 'DLRD' || status === 'RCVD'){ return "btn btn-sm btn-success btn-flat pull-center" }
		else if(status === 'CNLD' || status === 'RJKD'){ return "btn btn-sm btn-danger btn-flat pull-center" }
		else return 'btn btn-sm btn-info btn-flat pull-center'
	};

	$scope.getStatusText = function(status) {
		if(status === 'PLCD'){ return "Placed" }
		else if(status === 'INIT'){ return "Initiated" }
		else if(status === 'CNFD'){ return "Confirmed" }
		else if(status === 'DLRD'){ return "Delivered" }
		else if(status === 'RCVD'){ return "Rejected" }
		else if(status === 'CNLD'){ return "Canceled" }
		else if(status === 'RJKD'){ return "Rejected" }
		else return '---'
	};
	
	$scope.order_status_submit = function() {
		var _orderid = $scope.model_order_id;
		var _status = $scope.model_order_status;
		console.log("=================> calling order submt status===>"+_orderid+":"+_status);
		$('#mydivloader').show();
		$scope.isDisabled = true;
		var confirm_reqst = $.get('./ordersConfService/'+_orderid);
		confirm_reqst.done(function(data){
			$('#mydivloader').hide();
			 $('#configModal').modal('hide');
			 loadAllOrders();
		});
		confirm_reqst.fail(function(status, error){
        	console.log('fail return ....');
			$('#mydivloader').hide();
			 $('#configModal').modal('hide');
			 loadAllOrders();
		});
	};
	
	loadAllOrders();
	function loadAllOrders() {
		// DataTables configurable options
		$scope.dtOptions = DTOptionsBuilder.newOptions().withDisplayLength(10).withOption('autoWidth', true).withOption('info', true)
				.withOption('paging', true).withOption('processing', true).withOption('bLengthChange', true);
		$scope.loading = true;
		$http.get(ordersList).success(function(data, status, headers, config) {
			console.log("=================> Rest response [SUCCESS] status=" + status);
			console.log("=================> Rest response [SUCCESS] DATA=" + data);
			$scope.loading = false;
			$scope.orders = data;
		}).error(function(data, status, headers, config) {
			console.log("=================> Rest response [FAIL] DATA/status=" + status);
			$scope.loading = false;
		});
	}
});
