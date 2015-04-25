var resources = angular.module('daywalk.resources', ['ngResource']);

resources.factory('Route', function($resource) {
  return $resource('/api/routes/:id');
});