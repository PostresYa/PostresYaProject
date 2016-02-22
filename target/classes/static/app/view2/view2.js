'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope','service1',function($scope,service1) {
        
        $scope.agregarFabrica = function(){
           
            if (!isNaN($scope.propiedad2)){
                if($scope.propiedad2<=10  && $scope.propiedad2>0){
                     service1.addTodo({propiedad1:$scope.propiedad1,propiedad2:$scope.propiedad2});
                 $scope.propiedad1="";
                 $scope.propiedad2="";
                 alert("Sent!!");
                }
               
            }else{
                alert("error priority");
            }
 
            
           
            
        }

}]);