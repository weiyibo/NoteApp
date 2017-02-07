'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        
    	// reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(response) {
            	
            	console.log(response.data);
            	console.log(response.data[$scope.username]);
                if(response.data) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password, response.data[$scope.username]);
                    $location.path('/personalNotesPage');
                } else {
                	
                	console.log("error");
                    $scope.error = 'Username or password is incorrect';
                    $scope.dataLoading = false;
                }
            });
        };
    }]);