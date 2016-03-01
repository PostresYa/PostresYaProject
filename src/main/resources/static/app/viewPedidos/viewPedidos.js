'use strict';

angular.module('myApp.viewPedidos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewPedidos', {
    templateUrl: 'viewPedidos/viewPedidos.html',
    controller: 'ViewPedidosCtrl'
  });
}])

.controller('ViewPedidosCtrl', ['$scope','pedidos','pedidosChange' ,'$filter',function($scope, pedidos,pedidosChange ,$filter) {
        
        
        pedidos.get(function(data){
                        console.info("get pedido  ");
                        $scope.listado=data;
                        console.info("asdfsad  "+ $scope.listado[0].fecha.toString());
                    });
         
       /*$scope.listado= pedidos.getListado();

        */var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);
        };
        $scope.order('estado', true);   
        
        $scope.changeState=function($event,codigo,$index){
            alert("Legueeeee" + $index);
            if($scope.listado[$index].estado !="Enviado"){
                var seguro = confirm("desea cambiar el estado del pedido a enviado?");
                if (seguro) {
                    var newCode= {"codigo":codigo}
                    pedidosChange.save(codigo,function(){
                          console.info("Change   "+ newCode);
                          $scope.listado[$index].estado="Enviado";

                    });


                }
            }else{
                alert("el pedido ya esta enviado");
            }
        }
                
        /* $scope.postres = function(){
             alert("postres pedidos");
             $scope.pos = pedidos.query();
        };*/


}]);