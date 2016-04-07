'use strict';
angular.module('services.module1', ['ngRoute','ngResource'])


    .factory('postres', function($resource) {
            
        return $resource('/postres',{},{ get: { method: 'GET', isArray: true
} });
    })
    
    
     .factory('pedidos', function($resource) {
            
        return $resource('/pedidos',{},{ get: { method: 'GET', isArray: true
        } });
    })
    
    
    /*.factory('pedidosPostres', function($resource) {
            
        return $resource('/pedidos/postres',{},{ get: { method: 'GET', isArray: true
        } });
    })*/
    
    .factory('postresChange', function($resource) {
            
        return $resource('/postres/change');
    })
    .factory('reposterias', function($resource) {
            
         return $resource('/reposterias',{},{ get: { method: 'GET', isArray: true
} });
       
    })
    
    .factory('reposteriasINVIMA', function($resource) {
            
        return $resource('/reposterias/registroinvima/:nit');
    })
    
    .factory('pedidosChange', function($resource) {
            
        return $resource('/pedidos/change');
    });
    