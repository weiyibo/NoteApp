'use strict';

angular.module('Home',['ui.bootstrap'])

.controller(
		'HomeController',
		[
				'$scope',
				'$rootScope',
				'$cookieStore',
				'$http', '$uibModal',
				function($scope, $rootScope, $cookieStore, $http, $uibModal) {
					
					$scope.noteList = $rootScope.globals.notesList;
					$scope.currentUser = $rootScope.globals.currentUser;
					
					$scope.listAll = function(){
						$scope.noteList = $rootScope.globals.notesList;
					};
					
					$scope.getLabelList = function(){
						
						console.log('getList');
						var labelList = [];
						
						for ( var index in $scope.noteList) {

							for (var labelIndex in $scope.noteList[index].labels){
								
								if(!labelList.includes($scope.noteList[index].labels[labelIndex])){
									
									labelList.push($scope.noteList[index].labels[labelIndex]);
								}
							}
						}
						$scope.labelList = labelList;
					};
					
					$scope.createNoteSubmit = function(){
						console.log("submit");
						
			            var note = {
			              'content' : $scope.content,
			              'labels' : $scope.labels,
			              'title' : $scope.title,
			              'author' : $scope.currentUser.username
			            };
			            
			            $scope.noteList.push(note);
			            $cookieStore.put('globals', $rootScope.globals);
			            
						$http({
			              method : 'POST',
			              url : 'createNote',
			              data : angular.toJson(note),
			              headers : {
			                "Content-Type" : "application/json"
			              }
			            }).then(function(response) {
			
			              console.log(response);
			
			            }, function(error) {
			
			            });
						$scope.modalInstance.close();
					};

					$scope.createNote = function() {
						console.log("create");
						$scope.noteList = $rootScope.globals.notesList;
						$scope.getLabelList();
						
						$scope.modalInstance  = $uibModal.open({
				              templateUrl: 'view/createNotePage.jsp',
				              scope: $scope,
				              controller: 'HomeController',
				              windowClass: 'app-modal-window'
				        });
					};

					$scope.editNote = function(index) {
						console.log("edit");
						
						$scope.note = $scope.noteList[index];
						$scope.getLabelList();
						$scope.labels = $scope.note.labels;
						$scope.index = index;
						
						$scope.modalInstance  = $uibModal.open({
				              templateUrl: 'view/editNotePage.jsp',
				              scope: $scope,
				              controller: 'HomeController',
				              windowClass: 'app-modal-window'
				        });
					};
					
					$scope.editNoteSubmit = function(){
						console.log("edit submit");
						$scope.note.labels = $scope.labels;
						
						$scope.noteList[$scope.index] = $scope.note;

						$cookieStore.put('globals', $rootScope.globals);

			            $http({
			              method : 'POST',
			              url : 'editNote',
			              data : angular.toJson($scope.noteList),
			              headers : {
			                "Content-Type" : "application/json"
			              }
			            }).then(function(response) {
			
			              console.log(response);
			
			            }, function(error) {
			
			            });

						$scope.modalInstance.close();
					};
					
					$scope.deleteNote = function(index) {
						
						var note = $scope.noteList[index];
						$scope.noteList.splice(index, 1);
						$rootScope.globals.notesList = $scope.noteList;
						$cookieStore.put('globals', $rootScope.globals);

						$http({
							method : 'DELETE',
							url : 'delete',
							data : angular.toJson(note),
							headers : {
								"Content-Type" : "application/json"
							}
						}).then(function(response) {

						}, function(error) {

						});
						
					};

					$scope.searchNote = function() {
						
						var globals = $cookieStore.get('globals');
						
						$scope.noteList = globals.notesList;
						
						var leftNoteList = [];
						console.log($scope.searchInput.trim());

						if ($scope.searchFilter === "title") {

							console.log("search by title");

							for ( var index in $scope.noteList) {

								if ($scope.noteList[index].title
										.includes($scope.searchInput)) {

									leftNoteList.push($scope.noteList[index]);
								}
							}

						} else if ($scope.searchFilter === "content") {

							console.log("search by content");

							for ( var index in $scope.noteList) {

								if ($scope.noteList[index].content
										.includes($scope.searchInput)) {

									leftNoteList.push($scope.noteList[index]);
								}
							}

						} else {
							
							console.log("search by label");
							
							for ( var index in $scope.noteList) {

								for (var labelIndex in $scope.noteList[index].labels){
									
									if($scope.noteList[index].labels[labelIndex] == $scope.searchInput){
										leftNoteList.push($scope.noteList[index]);
									}
								}
							}
						}
						$scope.noteList = leftNoteList;
					};
				} ]);

