'use strict';

angular.module('myApp.pedido', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/pedido', {
    templateUrl: 'pedido/pedido.html',
    controller: 'pedidoCtrl'
  });
}])

.controller('pedidoCtrl', ['$scope', 'service1','$filter', function($scope,service1,$filter) {
            
        $scope.listado= service1.getListado();

        var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);
        };
        $scope.order('age', true);

}]);


       $scope.listado = listarTareas.query();