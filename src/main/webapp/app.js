angular.module('daywalk', [
	'ngRoute',
	'daywalk.browser'
]).
config(['$routeProvider','$compileProvider', function($routeProvider,$compileProvider) {
	$routeProvider.when("/", {
		redirectTo: '/browser'
	});
    $compileProvider.debugInfoEnabled(false);
}]);