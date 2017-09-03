theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("http://localhost:8080/home/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

theRouter.controller('updateBook', function($scope, $http){
	$scope.updateBook = function(){
		$http.put("http://localhost:8080/home/updateBook", $scope.book).then(function(value){
			window.alert("Book(s) Updated")
		})
	}
});

theRouter.controller('deleteBook', function($scope, $http){
	$scope.deleteBook = function($scope){
		$http.delete("http://localhost:8080/home/deleteBook", $scope.book).then(function(value){
			window.alert("Book(s) Deleted")
		})
	}
})
