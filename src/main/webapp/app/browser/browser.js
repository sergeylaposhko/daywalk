'use strict';

angular.module('daywalk.browser', ['ngRoute'])

.config(function($routeProvider) {
	$routeProvider.when('/browser', {
		templateUrl: 'app/browser/browser.html',
		controller: 'BrowserController'
	});
})

.controller('BrowserController', ['$scope', function($scope) {

	$scope.testData = "Hello from angular";

}]);