'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'ngResource',
  'myApp.viewRegistroPostres',
  'myApp.viewPostres',
  'myApp.viewLogin',
  'myApp.viewPedidos',
  'services.module1',
  'myApp.version'
]).
        
config(['$routeProvider','$httpProvider', function($routeProvider, $httpProvider) {
$routeProvider.otherwise({redirectTo: '/viewLogin'});
$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}])

.controller('myApp.principal', ['$scope','$rootScope','$http','$location', function($scope, $rootScope, $http, $location) {
            
   $scope.logout = function () {
               
                $http.post('/logout', {}).success(function () {
                    $rootScope.authenticated = false;
                    $location.path("/viewLogin");
                }).error(function (data) {
                    $rootScope.authenticated = false;
                });
            };

}]);

        
        

