'use strict';

angular.module('daywalk.constructor', ['ngRoute'])

.config(function($routeProvider) {
	$routeProvider.when('/constructor', {
		templateUrl: 'app/browser/constructor.html',
		controller: 'ConstructorController'
	});
})

.controller('ConstructorController', ['$scope', function($scope) {
    initializeViews();
}]);