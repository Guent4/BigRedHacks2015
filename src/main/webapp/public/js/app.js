'use strict';
var app = angular.module('myApp', ['ngRoute']);

app.config( ['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'home.html'
        })
        .when('/logged_in', {
            templateUrl: 'logged_in.html'
        })
        .when('/match', {
            templateUrl: 'match.html'
        })
        .when('/profile', {
            templateUrl: 'profile.html'
        })
        .when('/singup', {
            templateUrl: 'signup.html'
        })
        .otherwise({
            redirectTo: '/home'
        });
}]);


var User = function () {
    this.session = null;
    this.email = null;
    this.password = null;
};

app.service('LoginService', ['$http', function ($http) {
    this.login = function (student) {
        console.log("test");
        return $http.post('/student/login', {email: student.email, password: student.password});
    };
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