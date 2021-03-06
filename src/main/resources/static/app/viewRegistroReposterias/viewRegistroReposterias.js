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

        $scope.nitR="";
        $scope.name ="";
         $scope.CoverageRange="";
      
        $scope.password="";
        $scope.validarNit="";
        $scope.direccion="";
        $scope.validada=false;
        
  
        
        $scope.validarINVIMA=function(){           
            console.log("VALIDNADO INFORMACION CON EL INVIMA");            
            console.log($scope.nitR);           
            if ($scope.nitR==$scope.Validarnit){
                var valid = true;
                if($scope.nitR.length==11){
                    console.log($scope.nitR.charAt(9));
                    for (var i = 0; i <9;i++){
                    if(isNaN($scope.nitR.charAt(i))){
                       valid = false; 
                    }
                }
                valid = valid && ($scope.nitR.charAt(9)=="-") && !isNaN($scope.nitR.charAt(10))  ;
                }else{
                    alert("Ingrese un NIT con formato valido");
                }
                if(valid){
                reposteriasINVIMA.get({nit:$scope.nitR},function(data){
                console.info("consulta INVIMA registrada  ");                
                console.log(data);
               
                console.log(data.estadoRegistro);
                 if(data.estadoRegistro==null){
                         alert("Nit no encontrado");
                 }else{                      
                     if(data.estadoRegistro == "Vigentes" ){
                        
                         $scope.validada = true;
                        document.getElementById("nitReposteria").disabled = true;
                        document.getElementById("nitReposteriaV").disabled = true;
                     }else{
                         $scope.validada = false;
                        alert("El registro de sanidad no es válido");
                     }                                           
                 }       

                  });
                   $rootScope.authenticated=false;
                $rootScope.nit="";
             }else{
                alert("nit invalido");
             }
            }else{
                $rootScope.authenticated=false;
                $rootScope.nit="";
                alert("el nit no coincide");
            }
             
              
        };
        
        $scope.agregarReposteria=function(){
            console.log("entro");
            reposteriasValidacion.get({nit:$scope.nitR},function(data){
                
                if(data.nit!=null){
                        $rootScope.authenticated=false;
                        $rootScope.nit="";
                    alert("el nit ya esta registrado en la pagina");
                }else{
                    
                    var latitud;
                    var longitud;

                    var geocoder = new google.maps.Geocoder();

                    var address = $scope.direccion+",Bogota";
                    geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {

                       latitud = results[0].geometry.location.lat();

                        longitud = results[0].geometry.location.lng();
                          
                        console.log('La longitud es: ' + longitud + ', la latitud es: ' + latitud);


                          
                    var newUser={"username":$scope.nitR,"password":$scope.password,"rol":"reposteria"};
                    var newReposteria={"nit":$scope.nitR,"name":$scope.name,"postres":[], "coverageRange":$scope.CoverageRange, "usuario":newUser,"direccion":$scope.direccion,"latitud":latitud,"longitud":longitud};
                    console.log(newReposteria);    
                        
                        
                         reposterias.save(newReposteria,function(){
                               console.info("saved   "+ newReposteria);
                                  $scope.nitR="";
                                    $scope.Validarnit="";
                                    $scope.password="";
                                  $scope.name="";
                                  $scope.CoverageRange="";
                                  $rootScope.authenticated=false;
                                  $rootScope.nit="";
                                  $scope.direccion="";
                                  document.getElementById("nitReposteria").disabled = false;
                                  document.getElementById("nitReposteriaV").disabled = false;
                                  alert("reposteria guardada");
                                  
                                 // $scope.description="";
                         });



                        } 
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