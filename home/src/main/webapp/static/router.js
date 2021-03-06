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
	$urlRouterProvider.otherwise('/home.html');
	
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
		.state('checkedout', {
			url: '/checkedout.html',
			templateUrl: "pages/library-checkedout.html",
			
		})
		.state('about', {
			url: "/about.html",
			templateUrl: "pages/about.html"
		})
});

theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

theRouter.controller("getBooksController", function($http, $scope){
	$http.get("/getAllBooks").then(function(response){
		$scope.allBooks = response.data;
	})
});

theRouter.controller("getUsersController", function($http, $scope){
	$http.get("/getUsers").then(function(response){
		$scope.allUsers = response.data;
	})
});


