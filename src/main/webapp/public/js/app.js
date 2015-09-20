'use strict';
var app = angular.module('myApp', ['ui.bootstrap']);

var User = function() {
    this.session = null;
    this.email = null;
    this.password = null;
};

app.service('LoginService', ['$http', function($http){
    this.login = function(student) {
        console.log("test");
        return $http.post('/student/login', {email:student.email, password: student.password});
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

function CarouselDemoCtrl($scope){
  $scope.myInterval = 3000;
  $scope.slides = [
    {
      image: 'http://lorempixel.com/400/200/'
    },
    {
      image: 'http://lorempixel.com/400/200/food'
    },
    {
      image: 'http://lorempixel.com/400/200/sports'
    },
    {
      image: 'http://lorempixel.com/400/200/people'
    }
  ];
}