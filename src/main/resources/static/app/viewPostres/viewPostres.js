'use strict';

angular.module('myApp.viewPostres', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewPostres', {
    templateUrl: 'viewPostres/viewPostres.html',
    controller: 'ViewPostresCtrl'
  });
}])

.controller('ViewPostresCtrl', ['$scope','postres','$filter','$rootScope',function($scope,postres,$filter,$rootScope) {
        
       
                
                  console.log($rootScope.nit);  
                  postres.get({nit:$rootScope.nit},function(data){
                        console.info("get postre  ");
                        $scope.listadoPostres=data;
                    });
        
        var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listadoPostres = orderBy($scope.listadoPostres, predicate, $scope.reverse);
        };
        $scope.order('id.code', true);
                
                
                
         

}]);