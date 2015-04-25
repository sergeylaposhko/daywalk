'use strict';

angular.module('daywalk.browser', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/browser', {
    templateUrl: 'browser/browser.html',
    controller: 'BrowserController'
  });
}])

.controller('BrowserController', ['$scope', function($scope) {

	$scope.testData = testData;

}]);