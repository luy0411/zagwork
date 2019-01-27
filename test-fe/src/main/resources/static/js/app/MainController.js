'use strict'

var module = angular.module('test.controllers', []);
module.controller("MainController", [ "$scope", "MainService",
		function($scope, MainService) {
			$scope.data = {
				username : null,
				limit : null,
				risk : null
			};
			$scope.closeModal = function(){
                $("#userModal").hide();
            };
			$scope.closeErrorModal = function(){
                $("#errorModal").hide();
            };
			$scope.sendAll = function() {
			    if ($scope.data.username != null &&
					$scope.data.limit  != null &&
					$scope.data.risk != null ) {

			        $scope.username = $scope.data.username;

                    MainService.sendAll($scope.data).then(function (response) {
                        $scope.dataList = response.data;
                        $("#userModal").show();
                        $scope.data = {
                            username: null,
                            limit: null,
                            risk: null
                        };
                    }, function (reason) {
                        $scope.statusCode = reason.data.status;
                        $scope.errorMessage = reason.data.message;
                        $("#errorModal").show();
                        console.log(reason);
                    }, function (value) {
                        console.log("no callback " + value);
                    });
                }
            }
		} ]);