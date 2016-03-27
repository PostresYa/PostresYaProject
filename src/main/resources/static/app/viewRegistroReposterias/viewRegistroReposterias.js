'use strict';

angular.module('myApp.viewRegistroReposterias', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroReposterias', {
    templateUrl: 'viewRegistroReposterias/viewRegistroReposterias.html',
    controller: 'ViewRegistroReposteriasCtrl'
  });
}])

.controller('ViewRegistroReposteriasCtrl', ['$scope',function($scope) {

        $scope.nit="";
        $scope.name ="";
        $scope.catalogo ="";
        $scope.cobertura ="";
        
        $scope.agregarReposterias = function(){


            
           
            
        }



}]);