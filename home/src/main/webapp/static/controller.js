angular.module("libRouter")
	.controller("bookCreateController", function($http, $scope) {
		$scope.createBook = function(){
			$http.post("http://localhost:8080/home/books/createBook", $scope.book).then(function(value){
				window.alert("Book(s) Added");
			});
		}
	});
angular.module("libRouter")
	.controller("getBooksController", function($http, $scope){
		$http.get("http://localhost:8080/home/books/getAllBooks").then(function(value){
			$scope.allBooks = response.data;
		});
	});
