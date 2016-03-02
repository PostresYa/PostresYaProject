'use strict';

angular.module('myApp.viewPedidos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewPedidos', {
    templateUrl: 'viewPedidos/viewPedidos.html',
    controller: 'ViewPedidosCtrl'
  });
}])

.controller('ViewPedidosCtrl', ['$scope','pedidos','pedidosChange' ,'$filter','$mdDialog',function($scope, pedidos,pedidosChange ,$filter,$mdDialog) {
        
        
        pedidos.get(function(data){
                        console.info("get pedido  ");
                        $scope.listado=data;
                       
                    });
                    
                    
        $scope.DetallesPostre = function(ev,postres,$index) {
            
             //con show message
             //Indica los detalles del postre seleccionado en la lista de los pedidos
              $mdDialog.show(
                $mdDialog.alert()
                  .parent(angular.element(document.querySelector('#popupContainer')))
                  .clickOutsideToClose(true)
                  .title('Detalles postre '+ postres[$index].postre.code)
                  .textContent("Nombre: "+ postres[$index].postre.name+" , Precio: "+postres[$index].postre.price + " , Descripcion: "+ postres[$index].postre.description + " , Cantidad: "+postres[$index].cant)
                  .ariaLabel('Alert Dialog Demo')
                  .ok('OK')
                  .targetEvent(ev,postres)
              );        
        };
         
       /*$scope.listado= pedidos.getListado();

        */var orderBy = $filter('orderBy');
       
        $scope.order = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
            $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);
        };
        $scope.order('estado', true);   
        
        $scope.changeState=function($event,codigo,$index){
            
            if($scope.listado[$index].estado !=="Enviado"){
                var seguro = confirm("desea cambiar el estado del pedido a enviado?");
                if (seguro) {
                    var newCode= {"codigo":codigo};
                    pedidosChange.save(codigo,function(){
                          console.info("Change   "+ newCode);
                          $scope.listado[$index].estado="Enviado";

                    });


                }
            }else{
                alert("El pedido ya esta enviado");
            }
        };
                
        /* $scope.postres = function(){
             alert("postres pedidos");
             $scope.pos = pedidos.query();
        };*/

}]);