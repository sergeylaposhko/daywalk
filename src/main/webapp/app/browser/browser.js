'use strict';

angular.module('daywalk.browser', ['ngRoute'])

.config(function($routeProvider) {
	$routeProvider.when('/browser', {
		templateUrl: 'app/browser/browser.html',
		controller: 'BrowserController'
	});
})

.controller('BrowserController', ['$scope', 'Route', function($scope, route) {

    var res = route.get({id:8}, function() {
    	console.log(res);
    });

    initializeViews(res);
}]);
