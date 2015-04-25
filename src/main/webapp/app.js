angular.module('daywalk', [
	'ngRoute',
	'daywalk.browser'
]).
config(['$routeProvider', function($routeProvider) {
	$routeProvider.when("/", {
		redirectTo: '/'
	});
}]);