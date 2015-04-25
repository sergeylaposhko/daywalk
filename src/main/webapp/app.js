angular.module('daywalk', [
	'ngRoute',
	'daywalk.resources',
	'daywalk.browser'
]).
config(['$routeProvider','$compileProvider', function($routeProvider,$compileProvider) {
	$routeProvider.when("/", {
		redirectTo: '/browser'
	});
    $compileProvider.debugInfoEnabled(false);
}]);