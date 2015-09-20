'use strict';

angular.module('myApp', [
  'ngRoute'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/home'});
}]);

app.controller('LoginController', ['$scope', 'LoginService', function ($scope, LoginService) {
    $scope.greeting = 'Hola!';
    $scope.user = new User();
    $scope.login = function () {
        var promise = LoginService.login($scope.user);
        promise.then(function (response) {
            $scope.user.session = response.data.session;

        }, function (response) {
            console.log(response);
        });
    }
}]);