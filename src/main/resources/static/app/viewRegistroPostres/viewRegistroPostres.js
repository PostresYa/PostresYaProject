'use strict';

angular.module('myApp.viewRegistroPostres', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroPostres', {
    templateUrl: 'viewRegistroPostres/viewRegistroPostres.html',
    controller: 'ViewRegistroPostresCtrl'
  });
}])

.controller('ViewRegistroPostresCtrl', ['$scope','$rootScope','postres','postresChange','postre',function($scope,$rootScope, postres,postresChange,postre) {

        $scope.name="";
        $scope.price ="";
        $scope.id ="";
        $scope.description ="";
        
        $scope.agregarPostre = function(){

            if (!isNaN($scope.price)){
                if($scope.price>0){
                    
                    postre.get({nit:$rootScope.nit,code:$scope.code},function(data){
                    
                    if (data.id!=null){
                        var seguro = confirm("El codigo ya esta asociado, esta seguro de cambiar los valores?");
                        if (seguro) {
                            var newProduct={id:{"code":$scope.code,"reposteriaNit":$rootScope.nit},"name":$scope.name,"price":$scope.price,"description":$scope.description};
                    
                            postresChange.save({nit:$rootScope.nit},newProduct,function(){
                                  console.info("Change   "+ newProduct);
                                  
                                  $scope.name="";
                                  $scope.id="";
                                  $scope.price="";
                                  $scope.description="";
                            });
                        
                            
                        } 
                    }else{
                         var newProduct={id:{"code":$scope.code,"reposteriaNit":$rootScope.nit},"name":$scope.name,"price":$scope.price,"description":$scope.description};
                         console.log($rootScope.nit);
                         postres.save({nit:$rootScope.nit},newProduct,function(){
                               console.info("saved   "+ newProduct);
                                    $scope.name="";
                                  $scope.code="";
                                  $scope.price="";
                                  $scope.description="";
                         });
                    }
                    });
                    
                    
                    
                }else{
                alert("El precio debe ser mayor a 0");
            }
                    
       
            }else{
                alert("El precio debe ser numerico");
            }
 
            
           
            
        }



}]);