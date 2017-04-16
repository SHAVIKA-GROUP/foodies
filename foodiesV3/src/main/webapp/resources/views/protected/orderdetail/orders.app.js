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
indexapp.controller('ordersListCtrl', function($scope, $window, $location, $http, $filter, DTOptionsBuilder) {
	var ordersList = './ordersService';
	$scope.orderitems = {};
	$scope.bfst_qnty = '';
	$scope.luch_qnty = '';
	$scope.dinr_qnty = '';
	$scope._orderid = '';
	var orderFilterSelectId = 0;
	var checkboxes = [];
	$scope.bulkisDisabled=true;
	
	/*********/
	$scope.getFormatedDate = function(millisec) {
		return $filter('date')(new Date(millisec), 'dd/MMM/yyyy');
	};

	/*********/
	$scope.decodeMinitus = function(_minits) {
		if(_minits >= 60){
			return ''+convertMinsToHrsMins(_minits);
		}else{
			return ''+(_minits%60)+' Mins';
		}
	};

	
	convertMinsToHrsMins= function (minutes) {
		  var h = Math.floor(minutes / 60);
		  var m = minutes % 60;
		  h = h < 10 ? '0' + h : h;
		  m = m < 10 ? '0' + m : m;
		  return h + ':' + m +' Hours';
		}
	
	$scope.alert = function(index, event){
		if(checkboxes.indexOf(index) < 0){
			checkboxes.push(index);
		}else if(checkboxes.indexOf(index) >= 0){
			for (var i=0; i<checkboxes.length;i++) {
			  if (checkboxes[i] === index) {
				  checkboxes.splice(i,1); // removes the matched element
				  i = checkboxes.length;  // break out of the loop. Not strictly necessary
			  }
			}
		}
		$scope.bulkisDisabled = (checkboxes.length > 0) ? false : true; 
		//console.log("["+checkboxes.length+"]checkbox====>" + checkboxes.toString());
	}
	
	/*********/
	$scope.viewItem = function(order) {
		$scope._orderid = order.orders.order_item_id;
		$scope.orderitems = order.orderitems;
		$scope.menus = order.menus;
		//console.log(foodid + ": " + value.food_id + ": " + value.quantity);
		angular.forEach($scope.orderitems, function (value, key) {
			var foodid = value.food_id;
			var _quantity = value.quantity;
			//if(foodid === value.food_id){ return value.quantity; }
			angular.forEach(order.menus, function (value1, key1) {
				if(foodid === value1.id){ 
					//return value.quantity;
					if(value1.menutypeid == 1) { $scope.bfst_qnty = _quantity; }
					else if(value1.menutypeid == 2) { $scope.luch_qnty = _quantity; }
					else if(value1.menutypeid == 3) { $scope.dinr_qnty = _quantity; }
				}
			});
			
		});
	}

	/*********/
	$scope.getQuantity = function(menutypeid) {
		//console.log("menutypeid in getQuantity==>"+menutypeid);
		if(menutypeid == 1) { return $scope.bfst_qnty; }
		else if(menutypeid == 2) { return $scope.luch_qnty; }
		else if(menutypeid == 3) { return $scope.dinr_qnty; }
		else return '-';
	}

	
	/*********/
	$scope.goFilterOrdre = function() {
		console.log("=================> calling search ...");
		
	}

	/*********/
	$scope.viewBulkConfig = function() {
		console.log("=================> calling viewBulkConfig ...");
		$('#mybulkdivloader').show();
		$scope.isDisabled1 = false;
		$scope.model_bulk_order_id=checkboxes.toString();
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
		else if(status === 'RCVD'){ return "Received" }
		else if(status === 'CNLD'){ return "Canceled" }
		else if(status === 'RJKD'){ return "Rejected" }
		else return '---'
	};
	
	$scope.order_bulk_status_submit = function() {
		var _orderid = $scope.model_bulk_order_id;
		console.log("=================> calling order bulk submt status===>"+_orderid);
		$('#mybulkdivloader').show();
		$scope.isDisabled1 = true;
		$scope.bulkisDisabled=true;
		var confirm_reqst = $.get('./ordersBulkConfService/'+_orderid);
		confirm_reqst.done(function(data){
			$('#mybulkdivloader').hide();
			 $('#bulkconfigModal').modal('hide');
			 loadAllOrders();
		});
		confirm_reqst.fail(function(status, error){
        	console.log('fail return ....');
			$('#mybulkdivloader').hide();
			 $('#bulkconfigModal').modal('hide');
			 loadAllOrders();
		});
	};

	$scope.order_status_submit = function() {
		var _orderid = $scope.model_order_id;
		var _status = $scope.model_order_status;
		console.log("=================> calling order submt status===>"+_orderid+":"+_status);
		$('#mydivloader').show();
		$scope.isDisabled = true;
		$scope.bulkisDisabled=true;
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
		$http.get(ordersList+'/'+orderFilterSelectId).success(function(data, status, headers, config) {
			console.log("=================> Rest response [SUCCESS] status=" + status);
			console.log("=================> Rest response [SUCCESS] DATA=" + data);
			$scope.loading = false;
			$scope.orders = data;
		}).error(function(data, status, headers, config) {
			console.log("=================> Rest response [FAIL] DATA/status=" + status);
			$scope.loading = false;
		});
	}
	
	$scope.goFilterOrder = function() {
		orderFilterSelectId = ($scope.orderstatusfilter === undefined || $scope.orderstatusfilter === '') ? 0 : $scope.orderstatusfilter;
		console.log("SELECT BOX/A==>"+orderFilterSelectId);
		$scope.bulkisDisabled=true;
		loadAllOrders();
	}
	
});
