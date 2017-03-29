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
        return $http.put(urlBase + '/' + id, data);
    };
    dataFactory.deleteMenu = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    dataFactory.imageMenu = function (file, filename) {
        var fd = new FormData();
        fd.append('file', file);
        fd.append('filename', ""+filename);
        return $http.post(urlBase + '/image', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    };
    return dataFactory;
}]);

indexapp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            console.log("=================> calling directive.");
            element.bind('change', function(){
                scope.$apply(function(){
                	modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
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
indexapp.controller('menuCtrl', [ '$scope', '$location', '$routeParams', '$filter', '$window', 'menuFactory', function($scope, $location, $routeParams, $filter, $window,  menuFactory) {
	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide(); $("#bfst-alert").hide(); $("#luch-alert").hide(); $("#dinr-alert").hide();
	$scope.menu = {};
	$scope.formatDate = '';
	$scope.menudate = '';
	var imagepath = './resources/assets/menuimage/';
	//$scope.bfst_File='./resources/assets/menuimage/image_icon.png';
	//$scope.luch_File='./resources/assets/menuimage/org_deflt_logo.png';
	//$scope.dinr_File='./resources/assets/menuimage/user_female.png';
	$scope.bfst_image = '';
	$scope.luch_image = '';
	$scope.dinr_image = ''; 
	
	var _uniqueId = $routeParams.id;
	var  uniqueId = (_uniqueId === '0') ? getCurrentUniqueId($filter)  : _uniqueId;
	
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
		//console.log("=================> calling go_submit...");
		uniqueId = $filter('date')($scope.menudate, 'yyyyMMdd');
		//console.log("=================> calling go_submit/uniqueId="+uniqueId);
		getMenuDetail();
	}
	
	getMenuDetail();
	function getMenuDetail() {
		$("#bfst-alert").hide(); $('#mydiv').show();
		menuFactory.getMenu(uniqueId)
            .then(function (response) {
            	$('#mydiv').hide();	$('#mydiv1').hide(); $('#mydiv2').hide(); $("#bfst_alert_message").empty();
            	//console.log("=================> calling menuCtrl /response.data.date="+response.data.date);
            	//console.log("=================> calling menuCtrl /$scope.menudate="+$scope.menudate);
            	$scope.menudate = (typeof(response.data.date)  === "undefined") ? ((typeof($scope.menudate) === "undefined" || $scope.menudate === '') ? new Date() : $scope.menudate) : new Date(response.data.date);
            	//console.log("=================> calling menuCtrl /After//$scope.menudate="+$scope.menudate);
            	$scope.formatDate = setDatelable($filter, $scope.menudate); //function(){ return $scope.menudate; };
            	//$scope.menu.unique_id = function(){ return (typeof(response.data.unique_id)  === "undefined") ? getCurrentUniqueId($filter) : new Date(response.data.unique_id); };
            	//$scope.menu.date = function(){ return (typeof(response.data.date)  === "undefined") ? new Date().getTime() : new Date(response.data.date); };
                $scope.menu = response.data;
                
                console.log("=================> calling $scope.menu.bfst_image==="+$scope.menu.bfst_image);
                console.log("=================> calling $scope.menu.luch_image==="+$scope.menu.luch_image);
                console.log("=================> calling $scope.menu.dinr_image==="+$scope.menu.dinr_image);
            	if(null != $scope.menu.bfst_image || !$scope.menu.bfst_image === 'N/A') { $scope.bfst_image = imagepath+$scope.menu.bfst_image };
            	if(null != $scope.menu.luch_image || !$scope.menu.luch_image === 'N/A') { $scope.luch_image = imagepath+$scope.menu.luch_image };
            	if(null != $scope.menu.dinr_image || !$scope.menu.dinr_image === 'N/A') { $scope.dinr_image = imagepath+$scope.menu.dinr_image };
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
        	if(null != $scope.menu.bfst_image || !$scope.menu.bfst_image === 'N/A') { $scope.bfst_image = imagepath+$scope.menu.bfst_image };
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
        	if(null != $scope.menu.luch_image || !$scope.menu.luch_image === 'N/A') { $scope.luch_image = imagepath+$scope.menu.luch_image };
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
        	if(null != $scope.menu.dinr_image || !$scope.menu.dinr_image === 'N/A') { $scope.dinr_image = imagepath+$scope.menu.dinr_image };
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
	
	
	$scope.validateUploadForm = function(type){
		if(type == 1 && !$scope.menuBForm.$valid) { $window.alert("Warning \n Please Fill the form before upload image..."); }
		else if(type == 2 && !$scope.menuLForm.$valid) { $window.alert("Warning \n Please Fill the form before upload image..."); }
		else if(type == 3 && !$scope.menuDForm.$valid) { $window.alert("Warning \n Please Fill the form before upload image..."); }
	}
	
	/********************* image process ******************************/
	$scope.uploadFile = function(type){
        var file = (type === 'bfst') ? $scope.bfst_File : ((type === 'luch') ? $scope.luch_File : $scope.dinr_File);
        var uniqueid = $filter('date')($scope.menudate, 'yyyyMMdd');
        var sufix = (type === 'bfst') ? 'bfst' : ((type === 'luch') ? 'luch' : 'dinr');
        var filename = uniqueid+'_'+ sufix;
        //console.log('---------------> file is : ');console.dir(file);
        menuFactory.imageMenu(file, filename)
        .then(function (response) {
        	var _data = response.data.filename;
        	$scope.$apply(function() {
	        	if(type === 'bfst') $scope.bfst_image = imagepath+_data; 
	        	else if(type === 'luch') $scope.luch_image = imagepath+_data;
	        	else if(type === 'dinr') $scope.dinr_image = imagepath+_data;
        	});
        }, function(error) {
        	console.log("=================> Image uploaded error."+error);
        });
    };
    
    $scope.imageUploadB = function (event) {
    	var file = event.target.files[0]; var reader = new FileReader(); reader.onload = $scope.imageIsLoadedB; reader.readAsDataURL(file);
    }
    $scope.imageUploadL = function (event) {
    	var file = event.target.files[0]; var reader = new FileReader(); reader.onload = $scope.imageIsLoadedL; reader.readAsDataURL(file);
    }
    $scope.imageUploadD = function (event) {
    	var file = event.target.files[0]; var reader = new FileReader(); reader.onload = $scope.imageIsLoadedD; reader.readAsDataURL(file);
    }
    $scope.imageIsLoadedB = function (e) { $scope.$apply(function () { $scope.bfst_image = e.target.result; }); }
    $scope.imageIsLoadedL = function (e) { $scope.$apply(function () { $scope.luch_image = e.target.result; }); }
    $scope.imageIsLoadedD = function (e) { $scope.$apply(function () { $scope.dinr_image = e.target.result; }); }
    
    $scope.changeImage = function(img){
    	console.log("=================> Image uploaded imgname=================>"+img);
    }
    
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