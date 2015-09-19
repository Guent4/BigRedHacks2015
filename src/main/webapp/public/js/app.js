'use strict';

var app = angular.module('myApp',[]);

app.controller('LoginController', ['$scope', function($scope) {
    $scope.buttonClick = function() {
        console.log("hi");
    };
}]);
