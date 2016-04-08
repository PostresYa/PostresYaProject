'use strict';

angular.module('myApp.viewRegistroReposterias', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroReposterias', {
    templateUrl: 'viewRegistroReposterias/viewRegistroReposterias.html',
    controller: 'ViewRegistroReposteriasCtrl'
  });
}])

.controller('ViewRegistroReposteriasCtrl', ['$scope','reposteriasINVIMA', 'reposterias','$http','reposteriasValidacion','$rootScope',function($scope,reposteriasINVIMA, reposterias,$http,reposteriasValidacion,$rootScope) {
        $rootScope.authenticated=false;

        $scope.nit="";
        $scope.name ="";
         $scope.CoverageRange="";
      
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
                   $rootScope.authenticated=false;
                $rootScope.nit="";
                
            }else{
                $rootScope.authenticated=false;
                $rootScope.nit="";
                alert("el nit no coincide");
            }
             
              
        };
        
        $scope.agregarReposteria=function(){
            console.log("entro");
            reposteriasValidacion.get({nit:$scope.nit},function(data){
                
                if(data.nit!=null){
                        $rootScope.authenticated=false;
                        $rootScope.nit="";
                    alert("el nit ya esta registrado en la pagina");
                }else{
                    var newUser={"username":$scope.nit,"password":$scope.password};
                    var newReposteria={"nit":$scope.nit,"name":$scope.name,"postres":[], "coverageRange":$scope.CoverageRange, "usuario":newUser};
                    console.log(newReposteria);    
                        
                        
                         reposterias.save(newReposteria,function(){
                               console.info("saved   "+ newReposteria);
                                  $scope.nit="";
                                  $scope.name="";
                                  $scope.CoverageRange="";
                                  $rootScope.authenticated=false;
                                  $rootScope.nit="";
                                 // $scope.description="";
                         });
                }
                        
                       /* var newReposteria={"nit":$scope.nit,"name":$scope.name, "coverageRange":$scope.cobertura, usuario:{"username":$scope.usuario,"passwword":$scope.password}};
                         alert(newReposteria.name);
                         reposterias.save(newReposteria,function(){
                               console.info("saved   "+ newReposteria);
                                  $scope.nit="";
                                  $scope.name="";
                                  $scope.cobertura="";
                                 // $scope.description="";
                         });*/
                    //}
                });
        };
        
        

}]);