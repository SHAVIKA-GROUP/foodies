/***
 * 
 * 
 */
indexapp.controller('ctrlMenu', function($scope, $location, $http) {
	console.log("=================> calling ctrlMenu ...");
});

/***
 * 
 * 
 */
indexapp.controller('ctrlMenudetail', function($scope, $location, $http) {
	console.log("=================> calling ctrlMenudetail ...");
});


indexapp.factory('menuFactory', ['$http', function($http) {

    var urlBase = './menuservice';
    var dataFactory = {};

    dataFactory.getMenus = function () {
        return $http.get(urlBase);
    };
    dataFactory.getMenu = function (id) {
        return $http.get(urlBase + '/' + id);
    };
    dataFactory.insertMenu = function (data) {
        return $http.post(urlBase, data);
    };
    dataFactory.updateMenu = function (id, data) {
        return $http.put(urlBase + '/' + id, data)
    };
    dataFactory.deleteMenu = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    return dataFactory;
}]);


/***
 * 
 * 
 */
indexapp.controller('ctrlMenulist', ['$scope', '$location', '$filter', 'DTOptionsBuilder', 'menuFactory', function($scope, $location, $filter, DTOptionsBuilder, menuFactory) {
	/*********/
	$scope.navigate2menudetail = function(uniqueId) {
		var id = (uniqueId != null) ? uniqueId : '0';
		console.log("=================> calling navigate2menudetail=" + id);
		$location.url('/menu/' + id);
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
	/*********/
	getAllMenus();
	
	function getAllMenus() {
		menuFactory.getMenus()
            .then(function (response) {
            	console.log("=================> calling /getALL/success.");
                $scope.menulist = response.data;
            }, function(error) {
            	console.log("=================> calling /getALL/error.");
            });
    }
}]);

/***
 * 
 * 
 */
indexapp.controller('menuCtrl', [ '$scope', '$location', '$routeParams', '$filter', 'menuFactory', function($scope, $location, $routeParams, $filter, menuFactory) {
	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide(); $("#bfst-alert").hide(); $("#luch-alert").hide(); $("#dinr-alert").hide();
	$scope.menu = {};
	$scope.formatDate = '';
	$scope.menudate = '';
	var _uniqueId = $routeParams.id;
	var  uniqueId = (_uniqueId === '0') ? getCurrentUniqueId($filter)  : _uniqueId;
	//console.log("=================> calling menuCtrl /uniqueId="+uniqueId);
	
	/*
	if(!uniqueId === 0) {
		$("#bfst-alert").hide(); $('#mydiv').show();
		getMenuDetail();
	}else{
		$scope.menu.dinr_id = 0, luch_id = 0, bfst_id = 0;
		$scope.menu.unique_id = getCurrentUniqueId($filter);
		$scope.menu.date = new Date().getTime();
		$scope.formatDate = function(){ return new Date(); };
	}
	*/
	
	//$scope.menu.dinr_id = 0, luch_id = 0, bfst_id = 0;
	//$scope.menu.unique_id = getCurrentUniqueId($filter);
	//$scope.menu.date = new Date().getTime();
	//$scope.formatDate = function(){ return addDays(new Date(), 3); /*new Date().addDays(2);*/ };
	
	$scope.go_submit = function() {
		console.log("=================> calling go_submit...");
		uniqueId = $filter('date')($scope.menudate, 'yyyyMMdd');
		console.log("=================> calling go_submit/uniqueId="+uniqueId);
		getMenuDetail();
	}
	
	getMenuDetail();
	function getMenuDetail() {
		$("#bfst-alert").hide(); $('#mydiv').show();
		menuFactory.getMenu(uniqueId)
            .then(function (response) {
            	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide(); $("#bfst_alert_message").empty();
            	$scope.menudate = (typeof(response.data.date)  === "undefined") ? ((typeof($scope.menudate) === "undefined") ? new Date() : $scope.menudate) : new Date(response.data.date);
            	console.log("=================> calling menuCtrl /$scope.menudate="+response.data);
            	$scope.formatDate = setDatelable($filter, $scope.menudate); //function(){ return $scope.menudate; };
            	//$scope.menu.unique_id = function(){ return (typeof(response.data.unique_id)  === "undefined") ? getCurrentUniqueId($filter) : new Date(response.data.unique_id); };
            	//$scope.menu.date = function(){ return (typeof(response.data.date)  === "undefined") ? new Date().getTime() : new Date(response.data.date); };
                $scope.menu = response.data;
                if(typeof(response.data.date)  === "undefined"){
                	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide(); $("#bfst_alert_message").empty();
                	$("#bfst-alert").show();
                	$("#bfst-alert").addClass('col-md-5 alert alert-warning').removeClass('col-md-5 alert alert-success'); 
                	$("#bfst_alert_message").append('<strong>Warning! </strong> No menu found, try another date.');
                	$("#bfst-alert").fadeTo(2000, 500).slideUp(1000, function(){
                	    $("#bfst-alert").slideUp(1000);
                	});
                }
            }, function(error) {
            	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide();
            	$("#bfst-alert").show();
            	$("#bfst-alert").addClass('col-md-5 alert alert-warning').removeClass('col-md-5 alert alert-success'); 
            	$("#bfst_alert_message").append('<strong>Warning! </strong> unable to update data, try again.');
            	$("#bfst-alert").fadeTo(2000, 500).slideUp(1000, function(){
            	    $("#bfst-alert").slideUp(1000);
            	});
            });
    };
	
	
	/*********/
	$scope.bfst_reset = function () {$scope.menu.bfst_title = undefined;$scope.menu.bfst_subtitle = undefined;$scope.menu.bfst_description = undefined;$scope.menu.bfst_price = undefined;$scope.menuBForm.$setPristine();};
	$scope.luch_reset = function () {$scope.menu.luch_title = undefined;$scope.menu.luch_subtitle = undefined;$scope.menu.luch_description = undefined;$scope.menu.luch_price = undefined;$scope.menuLForm.$setPristine();};
	$scope.dinr_reset = function () {$scope.menu.dinr_title = undefined;$scope.menu.dinr_subtitle = undefined;$scope.menu.dinr_description = undefined;$scope.menu.dinr_price = undefined;$scope.menuDForm.$setPristine();};
	
	
	$scope.bfst_submit = function() {
		$('#mydiv').show(); $("#bfst-alert").hide(); $("#bfst_alert_message").empty();
		$scope.menu.menutypeid = 1;
		$scope.menu.unique_id = $filter('date')($scope.menudate, 'yyyyMMdd');
		$scope.menu.date= $scope.menudate.getTime();
		menuFactory.insertMenu($scope.menu)
        .then(function (response, headers) {
        	console.log("=================> calling submit/get/success.");
        	$('#mydiv').hide(); 
        	$scope.menu = response.data;
            $("#bfst-alert").show();
            $("#bfst-alert").addClass('col-md-5 alert alert-success').removeClass('col-md-5 alert alert-warning');
            $("#bfst_alert_message").append('<strong>Success! </strong> Record inserted/updated succesfully.');
        	$("#bfst-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#bfst-alert").slideUp(1000); });
        }, function(error) {
        	console.log("=================> calling submit/get/error.");
        	$('#mydiv').hide();
        	$("#bfst-alert").show();
        	$("#bfst-alert").addClass('col-md-5 alert alert-warning').removeClass('col-md-5 alert alert-success'); 
        	$("#bfst_alert_message").append('<strong>Warning! </strong> Update unsuccess, try again.');
        	$("#bfst-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#bfst-alert").slideUp(1000); });
        });
	}
	
	$scope.luch_submit = function() {
		$('#mydiv1').show(); $("#luch-alert").hide(); $("#luch_alert_message").empty();
		$scope.menu.menutypeid = 2;
		$scope.menu.unique_id = $filter('date')($scope.menudate, 'yyyyMMdd');
		$scope.menu.date= $scope.menudate.getTime();
		menuFactory.insertMenu($scope.menu)
        .then(function (response, headers) {
        	console.log("=================> calling submit-2/get/success.");
        	$('#mydiv1').hide(); 
        	$scope.menu = response.data;
            $("#luch-alert").show();
            $("#luch-alert").addClass('col-md-5 alert alert-success').removeClass('col-md-5 alert alert-warning');
            $("#luch_alert_message").append('<strong>Success! </strong> Record inserted/updated succesfully.');
        	$("#luch-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#luch-alert").slideUp(1000); });
        }, function(error) {
        	console.log("=================> calling submit-2/get/error.");
        	$('#mydiv1').hide();
        	$("#luch-alert").show();
        	$("#luch-alert").addClass('col-md-5 alert alert-warning').removeClass('col-md-5 alert alert-success'); 
        	$("#luch_alert_message").append('<strong>Warning! </strong> Update unsuccess, try again.');
        	$("#luch-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#luch-alert").slideUp(1000); });
        });
	}
	
	$scope.dinr_submit = function() {
		$('#mydiv2').show(); $("#dinr-alert").hide(); $("#dinr_alert_message").empty();
		$scope.menu.menutypeid = 3;
		$scope.menu.unique_id = $filter('date')($scope.menudate, 'yyyyMMdd');
		$scope.menu.date= $scope.menudate.getTime();
		menuFactory.insertMenu($scope.menu)
        .then(function (response, headers) {
        	console.log("=================> calling submit-3/get/success.");
        	$('#mydiv2').hide(); 
        	$scope.menu = response.data;
            $("#dinr-alert").show();
            $("#dinr-alert").addClass('col-md-5 alert alert-success').removeClass('col-md-5 alert alert-warning');
            $("#dinr_alert_message").append('<strong>Success! </strong> Record inserted/updated succesfully.');
        	$("#dinr-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#dinr-alert").slideUp(1000); });
        }, function(error) {
        	console.log("=================> calling submit-3/get/error.");
        	$('#mydiv2').hide();
        	$("#dinr-alert").show();
        	$("#dinr-alert").addClass('col-md-5 alert alert-warning').removeClass('col-md-5 alert alert-success'); 
        	$("#dinr_alert_message").append('<strong>Warning! </strong> Update unsuccess, try again.');
        	$("#dinr-alert").fadeTo(2000, 500).slideUp(1000, function(){ $("#dinr-alert").slideUp(1000); });
        });
	}
	
	
	$('#datepicker').datepicker({ format : 'dd/M/yyyy', startDate: '-6d', autoclose: true, todayBtn: true, todayHighlight: true, endDate: '+5d' });
	$('#datepicker').on('changeDate', function() {
		  var st = $('#datepicker').datepicker('getFormattedDate');
		  var pattern = /(\d{2})(\/)(\d{2})(\/)(\d{4})/;
		  var date = new Date(st.replace(pattern, '$1-$2-$3'));
		  console.log("=================> calling date===>"+date);
		 $scope.menudate = date; 
	});
	
}]);


function getCurrentUniqueId($filter) {
	var date = new Date();
	return $filter('date')(new Date(), 'yyyyMMdd');
}

function setDatelable($filter, date) {
	return $filter('date')(date, 'dd/MMM/yyyy');
}


function addDays(currentDate, days) {
    return new Date(currentDate.getTime() + days*24*60*60*1000);
}