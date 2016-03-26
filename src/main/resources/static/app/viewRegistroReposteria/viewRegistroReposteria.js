'use strict';

angular.module('myApp.viewRegistroReposteria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroReposteria', {
    templateUrl: 'viewRegistroReposteria/viewRegistroReposteria.html',
    controller: 'ViewRegistroReposteriaCtrl'
  });
}])

.controller('ViewRegistroReposteriaCtrl', ['$scope',function($scope) {

        $scope.nit="";
        $scope.name ="";
        $scope.catalogo ="";
        $scope.cobertura ="";
        
        $scope.agregarReposteria = function(){


            
           
            
        }



}]);