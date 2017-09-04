theRouter.controller('createBooks', function($scope, $http){
	$scope.createBook = function(){
		$http.post("/createBook", $scope.book).then(function(value){
			window.alert("Book(s) Added");
		})
	}
});

theRouter.controller('updateBook', function($scope, $http){
	$scope.updateBook = function(){
		$http.put("/updateBookById/{id}", $scope.book.d3Id ,$scope.book).then(function(value){	
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


theRouter.controller('createUsers', function($scope, $http){
	$scope.createUsers = function(){
		$http.post("/createUser", $scope.user).then(function(value){
			window.alert("User Added");
		})
	}
});

theRouter.controller('updateUser', function($scope, $http){
	$scope.updateUser = function(){
		$http.put("/updateUser", $scope.user).then(function(value){	
			window.alert("User Updated")
		})
	}
});

