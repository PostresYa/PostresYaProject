'use strict';
angular.module('services.module1', ['ngRoute'])

    .factory('service1', function () {
        var data = {
            listado: []
        };
        return {
            getListado: function () {
                return data.listado;
            },
            addTodo: function (todo) {
                data.listado.push(todo);
            }};
    });

