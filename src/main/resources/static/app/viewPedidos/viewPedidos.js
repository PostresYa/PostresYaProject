'use strict';

angular.module('myApp.viewPedidos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewPedidos', {
    templateUrl: 'viewPedidos/viewPedidos.html',
    controller: 'ViewPedidosCtrl'
  });
}])

.controller('ViewPedidosCtrl', ['$scope','pedidos' /*,'$filter'*/,function($scope, pedidos /*,$filter*/) {
        
        
         $scope.listado = pedidos.query();
         
       /* $scope.listado= pedidos.getListado();

        var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);
        };
        $scope.order('age', true); */    
                
         $scope.postres = function(){
             alert("postres pedidos");
             $scope.pos = pedidos.query();
        };


}]);