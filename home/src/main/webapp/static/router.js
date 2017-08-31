angular.module("libRoute", ["ng-route"]);
angular.module("libRoute").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider
	  .when("/books/createBook", {
		templateUrl: "library-management-create.html",
		controller: "bookCreateController"
	}).when("/books/getAllBooks", {
		templateUrl: "library-management.html",
		controller: "getBooksController"
	}).when("/books/updateBook", {
		//NYI
	}).when("/books/deleteBook", {
		//NYI
	}).when("/user/createUser", {
		//NYI
	}).when("/user/getAllUsers", {
		//NYI
	}).when("/user/updateUser", {
		//NYI
	}).when("/user/deleteUser",{
		//NYI
	})
})