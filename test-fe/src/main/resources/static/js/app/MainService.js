'use strict'

angular.module('test.services', []).factory('MainService',
	[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.sendAll = function(data) {
				return $http.post(CONSTANTS.sendAll, data);
			}
			return service;
		}
	]
);