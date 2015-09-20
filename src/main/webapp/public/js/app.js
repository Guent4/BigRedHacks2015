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
        .when('/matched.html', {
            templateUrl: 'matched.html'
        })
        .when('/profile.html', {
            templateUrl: 'profile.html'
        })
        .when('/signUp.html', {
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

app.service('RegisterService', ['$http', function ($http) {
    this.register = function (student) {
        console.log("test");
        return $http.post('/student/register', student);
    };
}]);

app.service('MatchService', ['$http', function ($http) {
    this.register = function (student) {
        console.log("test");
        return $http.post('/match', {course: student.course, session: localStorage.getItem('session')});
    };
}]);

app.service('StudentService', ['$http', function ($http) {
    this.getProfile = function (student) {
        console.log("test");
        return $http.post('/student/profile', {session: student.session});
    };
}]);
//app.controller('NavController', ['$scope', function($scope) {
//
//}]);

app.controller('LoginController', ['$scope', '$rootScope', 'LoginService', function ($scope, $rootScope, LoginService) {
    $scope.user = new User();
    $scope.login = function () {
        var promise = LoginService.login($scope.user);
        promise.then(function (response) {
            console.log(response);
            $rootScope.session = response.data.session;
            localStorage.setItem('session', $rootScope.session);
            window.location.href = "#/logged_in.html";
        }, function (response) {
            console.log(response);
        });
    }
}]);

app.controller('RegisterController', ['$scope', '$rootScope', 'RegisterService', function ($scope, $rootScope, RegisterService) {

    $scope.register = function () {
        console.log($scope.user);
        var promise = RegisterService.register($scope.user);
        promise.then(function (response) {
            console.log(response);
            window.location.href = "#/home.html";
        }, function (response) {
            console.log(response);
        });
    }
}]);

app.controller('MatchedController', ['$scope', '$rootScope', function ($scope, $rootScope) {
    console.log('hi');
    $scope.matched = JSON.parse(localStorage.getItem('match'));
    console.log($scope.matched);
}]);

app.controller('MatchController', ['$scope', '$rootScope', 'MatchService', function ($scope, $rootScope, MatchService) {

    $scope.match = function () {
        var promise = MatchService.register($scope.user);
        promise.then(function (response) {
            console.log(response);
            $rootScope.matched = response.data.match;
            localStorage.setItem("match", JSON.stringify($rootScope.matched));
            console.log($rootScope.matched);
            window.location.href = "#/matched.html";
        }, function (response) {
            console.log(response);
        });
    }
}]);

app.controller('StudentController', ['$scope', '$rootScope', 'StudentService', function ($scope, $rootScope, StudentService) {
    $rootScope.user = {session:""};
    $scope.getProfile = function () {
        var promise = StudentService.getProfile($rootScope.session);
        promise.then(function (response) {
            console.log(response);
            $rootScope.user = response.data.student;
        }, function (response) {
            console.log(response);
        });
    };
    if ($rootScope.user.session.length > 0)
    {
        $scope.getProfile();
    }
}]);