'use strict';
var app = angular.module('myApp', ['ngRoute']);

app.config( ['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/home.html', {
            templateUrl: 'home.html'
        })
        .when('/logged_in.html', {
            templateUrl: 'logged_in.html'
        })
        .when('/match.html', {
            templateUrl: 'match.html'
        })
        .when('/profile.html', {
            templateUrl: 'profile.html'
        })
        .when('/signup.html', {
            templateUrl: 'signup.html'
        })
        .otherwise({
            redirectTo: '/home.html'
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

//app.controller('NavController', ['$scope', function($scope) {
//
//}]);

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