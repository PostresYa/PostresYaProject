'use strict';

angular.module('myApp.viewRegistroReposterias', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroReposterias', {
    templateUrl: 'viewRegistroReposterias/viewRegistroReposterias.html',
    controller: 'ViewRegistroReposteriasCtrl'
  });
}])

.controller('ViewRegistroReposteriasCtrl', ['$scope','reposteriasINVIMA', 'reposterias','$http',function($scope,reposteriasINVIMA, reposterias,$http) {

        $scope.nit="";
        $scope.name ="";
        $scope.cobertura ="";
        $scope.password="";
        $scope.validarNit="";
        $scope.validada=false;
        
  
        
        $scope.validarINVIMA=function(){
           
            console.log("VALIDNADO INFORMACION CON EL INVIMA");
      
            console.log($scope.nit);
            if ($scope.nit==$scope.Validarnit){
                reposteriasINVIMA.get({nit:$scope.nit},function(data){
                 console.info("consulta INVIMA registrada  ");
                
                 console.log(data);
                 $scope.validada=data.registrado;
                

                 if(data.registrado==false){
                     alert("no tiene registro de sanidad vigente");
                 }else{
                      document.getElementById("nitReposteria").disabled = true;
                       document.getElementById("nitReposteriaV").disabled = true;
                 }       

                  });
                
            }else{
                alert("el nit no coincide");
            }
             
              
        };
        
        $scope.agregarReposteria=function(){
            alert("SE AGREGARA UNA NUEVA REPOSTERIA");
            reposterias.get(function(data){
                  
                        var newReposteria={"nit":$scope.nit,"name":$scope.name, "coverageRange":$scope.cobertura, usuario:{"username":$scope.usuario,"passwword":$scope.password}};
                         alert(newReposteria.name);
                         reposterias.save(newReposteria,function(){
                               console.info("saved   "+ newReposteria);
                                  $scope.nit="";
                                  $scope.name="";
                                  $scope.cobertura="";
                                 // $scope.description="";
                         });
                    //}
                });
        };
        
        

}]);