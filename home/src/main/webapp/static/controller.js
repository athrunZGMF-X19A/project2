theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("http://localhost:8080/home/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

/*angular.module("libRouter")
	.controller("getBooksController", function($http, $scope){
		$http.get("http://localhost:8080/home/getAllBooks").then(function(value){
			$scope.allBooks = response.data;
		});
	});*/
