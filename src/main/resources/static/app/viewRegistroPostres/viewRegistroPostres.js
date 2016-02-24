'use strict';

angular.module('myApp.viewRegistroPostres', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroPostres', {
    templateUrl: 'viewRegistroPostres/viewRegistroPostres.html',
    controller: 'ViewRegistroPostresCtrl'
  });
}])

.controller('ViewRegistroPostresCtrl', ['$scope','postres',function($scope,postres) {

        $scope.name="";
        $scope.price ="";
        $scope.code ="";
        $scope.description ="";
        
        $scope.agregarPostre = function(){
            
            console.info($scope.price);
          /*
            if (!isNaN($scope.priority)){
                if($scope.priority<=10  && $scope.priority>0){
                    
                    
                    var newitem={"description":$scope.description,"priority":$scope.priority};
                    
                    tareas.save(newitem,function(){
                        console.info("saved   "+ newitem);
                    });
                    
                    //service1.addTodo({propiedad1:$scope.propiedad1,propiedad2:$scope.propiedad2});
                 $scope.description="";
                 $scope.priority="";
                // alert("Sent!!");
                }
               
            }else{
                alert("error priority");
            }*/
 
            
           
            
        }



}]);