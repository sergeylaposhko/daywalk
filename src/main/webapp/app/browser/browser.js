'use strict';

angular.module('daywalk.browser', ['ngRoute'])

.config(function($routeProvider) {
	$routeProvider.when('/browser', {
		templateUrl: 'app/browser/browser.html',
		controller: 'BrowserController'
	});
})

.controller('BrowserController', ['$scope', 'Route', function($scope, route) {
	$scope.title = "Title here";
	$scope.description = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis rem suscipit sunt laboriosam inventore dolor! Inventore natus labore vero qui blanditiis voluptatem eveniet laboriosam pariatur. Eligendi culpa debitis laboriosam eum quia cupiditate!"
    initializeViews();

    var res = route.get({id:8}, function() {
    	console.log(res);
    });
}]);
