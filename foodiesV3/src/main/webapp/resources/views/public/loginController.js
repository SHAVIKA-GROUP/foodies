var loginapp = angular.module('loginApp', [ 'ngRoute' ]);

loginapp.config(function($routeProvider) {
	
	$routeProvider.when('/login', {
		templateUrl : './resources/views/public/login_template.html'
	}).when('/forgetpassword', {
		templateUrl : './resources/views/public/forgot_password.html'
	}).when('/registeruser', {
		templateUrl : './resources/views/public/register_user.html'
	}).otherwise({
		redirectTo : '/login'
	});
});


loginapp.factory('userloginFactory', ['$http', function($http) {

    var urlBase = './userlogin';
    var dataFactory = {};

    dataFactory.getLogins = function () {
        return $http.get(urlBase);
    };
    dataFactory.getLogin = function (id) {
        return $http.get(urlBase + '/' + id);
    };
    dataFactory.insertLogin = function (login) {
        return $http.post(urlBase, login);
    };
    dataFactory.updateLogin = function (id, login) {
        return $http.put(urlBase + '/' + id, login)
    };
    dataFactory.deleteLogin = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    return dataFactory;
}]);


loginapp.controller('loginTemplate', function($scope, $log, $location) {
	var url = "" + $location.$$absUrl;
	$scope.loginFailMsg = true;
	$scope.loginSuccessMsg = true;
	console.log("=================> calling loginTemplate...URL=>" + url);
	if (url.indexOf("error") >= 0) {
		$scope.loginFailMsg = false;
	}else if (url.indexOf("logout") >= 0) {
		$scope.loginSuccessMsg = false;
	}
});

loginapp.controller('registerController', ['$scope', '$log', '$location', 'userloginFactory', function($scope, $log, $location, userloginFactory) {
	$scope.reg_status = '';
	getUserLogin();
	function getUserLogin() {
		userloginFactory.getLogin(1)
            .then(function (response) {
                $scope.register = response.data;
            }, function (error) {
            	$scope.reg_status  = '" Unable to load Register data/ Register once. "';
            });
    }
	
	$scope.submit = function() {
		var pwd = $scope.register.password;
		var _pwd = $scope.register.retypepassword;
		var _id = $scope.register.id;
		if(pwd != _pwd){
			$scope.reg_status = '" Password & RetryPassword is not matching. "';
			return;
		}
		var userlogin = {
				id: $scope.register.id,
				username: $scope.register.username,
				email: $scope.register.email,
				password:  $scope.register.password
	        };
		$scope.reg_status  = 'Loading ...';
		
		if(_id == '0'){
			userloginFactory.insertLogin(userlogin)
	        .then(function (response) {
	        	$scope.reg_status  = '" User registered successfully, go to login page to login. "';
	        }, function(error) {
	        	$scope.reg_status  = '" Unable to Register, Try again. "';
	        });
		}else{
			userloginFactory.updateLogin(_id, userlogin)
	        .then(function (response) {
	        	$scope.reg_status  = '" User updated successfully, go to login page to login. "';
	        }, function(error) {
	        	$scope.reg_status  = '" Unable to updated , Try again. "';
	        });
	}
		
	};
}]);