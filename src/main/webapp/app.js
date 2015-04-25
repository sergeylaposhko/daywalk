angular.module('daywalk', [
	'ngRoute',
	'daywalk.browser'
]).
config(['$routeProvider', function($routeProvider) {
	$routeProvider.otherwise({
		redirectTo: '/browser'
	});
}]);