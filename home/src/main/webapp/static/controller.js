theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

theRouter.controller('updateBook', function($scope, $http){
	$scope.updateBook = function(){
		$http.put("/updateBook", $scope.book).then(function(value){	
			window.alert("Book(s) Updated")
		})
	}
});

theRouter.controller('deleteBook', function($scope, $http){
	$scope.deleteBook = function(){
		$http.delete("/deleteBook").then(function(value){
			window.alert("Book(s) Deleted")
		})
	}
})
