angular.module('RoutingApp', ['ngRoute'])
    .config( ['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/first', {
                templateUrl: 'index.html'
            })
            .when('/second', {
                templateUrl: 'logged_in.html'
            })
            .otherwise({
                redirectTo: '/first'
            });
    }]);