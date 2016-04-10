'use strict';

angular.module('myApp.viewRegistroPostres', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRegistroPostres', {
    templateUrl: 'viewRegistroPostres/viewRegistroPostres.html',
    controller: 'ViewRegistroPostresCtrl'
  });
}])

.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}])

.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    }
}])


.controller('ViewRegistroPostresCtrl', ['$scope','$rootScope','postres','postresChange','postre', 'fileUpload',function($scope,$rootScope, postres,postresChange,postre,fileUpload) {

        $scope.name="";
        $scope.price ="";
        $scope.id ="";
        $scope.description ="";
        $scope.myFile="";
        
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
                                  
                                  
                                  var file = $scope.myFile;
                                    console.log('file is ' );
                                    console.dir(file);
                                    var uploadUrl = "/postres/uploadImage?codigo="+$scope.code+"&nit="+$rootScope.nit;
                                    fileUpload.uploadFileToUrl(file, uploadUrl);

                                    console.info("saved   "+ newProduct);
                                         $scope.name="";
                                       $scope.code="";
                                       $scope.price="";
                                       $scope.description="";
                                       $scope.myFile="";
                                  
                        
                            });
                        
                            
                        } 
                    }else{
                         var newProduct={id:{"code":$scope.code,"reposteriaNit":$rootScope.nit},"name":$scope.name,"price":$scope.price,"description":$scope.description};
                         console.log($rootScope.nit);
                         postres.save({nit:$rootScope.nit},newProduct,function(){
                             
                              
                            var file = $scope.myFile;
                            console.log('file is ' );
                            console.dir(file);
                            var uploadUrl = "/postres/uploadImage?codigo="+$scope.code+"&nit="+$rootScope.nit;
                            fileUpload.uploadFileToUrl(file, uploadUrl);

                            console.info("saved   "+ newProduct);
                                 $scope.name="";
                               $scope.code="";
                               $scope.price="";
                               $scope.description="";
                               $scope.myFile="";
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