'use strict';
angular.module('services.module1', ['ngRoute','ngResource'])


    .factory('postres', function($resource) {
            
        return $resource('/postres/:nit',{},{ get: { method: 'GET', isArray: true
} });
    })
    
    
     .factory('pedidos', function($resource) {
            
        return $resource('/pedidos',{},{ get: { method: 'GET', isArray: true
        } });
    })
    
     .factory('postre', function($resource) {
            
        return $resource('/postres/:nit/:code');
    })
    
    /*.factory('pedidosPostres', function($resource) {
            
        return $resource('/pedidos/postres',{},{ get: { method: 'GET', isArray: true
        } });
    })*/
    
    .factory('postresChange', function($resource) {
            
        return $resource('/postres/:nit/change');
    })
    
    .factory('pedidosChange', function($resource) {
            
        return $resource('/pedidos/change');
    });
    

    
    

