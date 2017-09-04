/*angular.module("libRouter", ["ngRoute"]);
angular.module("libRouter").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("/management", {
		templateUrl: "library-management.html",
		controller: "bookCreateController"
	}).when("/manage-create", {
		templateUrl: "library-management.html",
		controller: "getBooksController"
	}).when("/checkout", {
		templateUrl: null,
		controller: null
	});
});
Failure of an ng-route
*/
var theRouter = angular.module('theRouter',['ui.router']);

theRouter.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('');
	
	$stateProvider
		.state('home', {
			url: '/home.html',
			templateUrl: "pages/landing.html"
		})
		.state('management', {
			url: '/management.html',
			templateUrl: "pages/library-management.html",
			controller: 'getBooksController'
		})
		.state('users',{
			url: '/users.html',
			templateUrl: "pages/users.html",
			controller: 'getUsersController'
			
		})
});

theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("http://localhost:8080/home/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

theRouter.controller("getBooksController", function($http, $scope){
	$http.get("http://localhost:8080/home/getAllBooks").then(function(response){
		$scope.allBooks = response.data;
	})
});

theRouter.controller("getUsersController", function($http, $scope){
	$http.get("http://localhost:9999/home/getUsers").then(function(response){
		$scope.allUsers = response.data;
	})
});


