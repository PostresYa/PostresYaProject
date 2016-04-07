'use strict';

angular.module('myApp.viewRegistroReposterias', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroReposterias', {
    templateUrl: 'viewRegistroReposterias/viewRegistroReposterias.html',
    controller: 'ViewRegistroReposteriasCtrl'
  });
}])

.controller('ViewRegistroReposteriasCtrl', ['$scope','reposteriasINVIMA', 'reposterias',function($scope,reposteriasINVIMA, reposterias) {

        $scope.nit="";
        $scope.name ="";
        $scope.catalogo ="";
        $scope.cobertura ="";
        $scope.usuario="";
        $scope.password="";
        $scope.validada=false;
        
       
   
      
        $scope.validarINVIMA=function(){
           
            console.log("VALIDNADO INFORMACION CON EL INVIMA");
      
            console.log($scope.nit);
           
             reposteriasINVIMA.get({nit:$scope.nit},function(data){
                 console.info("consulta INVIMA registrada  ");
                
                 console.log(data);
                 $scope.validada=data.registrado;
                                 

                  });
              
        };
        
        $scope.agregarReposteria=function(){
            alert("SE AGREGARA UNA NUEVA REPOSTERIA");
            reposterias.get(function(data){
                    /*var listadotemp=data;
                     var codeExist=false;
                    for(var pos=0; pos<listadotemp.length ;pos++){
                         
                         if(listadotemp[pos].nit == $scope.nit){
                            codeExist=true;
                        }
                    }
                    if (codeExist){
                        alert("La reposteria con nit" + data + "ya esta creada");
                       
                    }else*/
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