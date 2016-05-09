'use strict';

angular.module('myApp.viewLogin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewLogin', {
    templateUrl: 'viewLogin/viewLogin.html',
    controller: 'ViewLoginCtrl'
  });
}])

.controller('ViewLoginCtrl', ['$scope','$rootScope','$http','$location', function($scope, $rootScope, $http, $location) {
    $scope.credentials = {};  
        
    var authenticate = function (credentials, callback) {

    var headers = credentials ? {authorization: "Basic " 
                + btoa(credentials.username + ":" + credentials.password)
    } : {};

        $http.get('user', {headers: headers}).success(function (data) {
           
            if (data.name) {
                if(data.authorities[0].authority == "reposteria"){
                    $rootScope.authenticated = true;
                $rootScope.nit=credentials.username; 
                }else{
                     $rootScope.authenticated = false;
                $rootScope.nit="";
                }
                 
               
              
            } else {
                $rootScope.authenticated = false;
                $rootScope.nit="";
            }
            callback && callback();
        }).error(function () {
            $rootScope.authenticated = false;
            callback && callback();
        });

    };
    
    authenticate();

       
    $scope.login = function () {
        authenticate($scope.credentials, function () {                        
            if ($rootScope.authenticated) {
                $location.path("/viewLogin");
                $scope.credentials.username="";
                $scope.credentials.password="";
                $scope.error = false;
            } else {
                $location.path("/viewLogin");
                $scope.error = true;
                alert("autentication failed ");
            }
        });
    };
 
}]);