'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$scope', 'service1','$filter', function($scope,service1,$filter) {
            
        $scope.listado= service1.getListado();

        var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);
        };
        $scope.order('age', true);

}]);