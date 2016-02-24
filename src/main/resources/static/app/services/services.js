'use strict';
angular.module('services.module1', ['ngRoute','ngResource'])


    .factory('postres', function($resource) {
            
        return $resource('/postres',{},{ get: { method: 'GET', isArray: true
} });
    });

