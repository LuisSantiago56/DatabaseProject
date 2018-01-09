app.controller("ctrl", function($scope, HttpService) {
	$scope.info = false;
	$scope.home = true;
	$scope.customer = false;
	$scope.supplier = false;
	$scope.resource = false;
	$scope.purchase = false;
    $scope.request = false;

	$scope.hideShowHome = function () {
	    $scope.home = true;
		$scope.info = false;
		$scope.customer = false;
	    $scope.supplier = false;
	    $scope.resource = false;
	    $scope.purchase = false;
        $scope.request = false;
	}

	$scope.hideShowInfo = function () {
	    $scope.info = true;
        $scope.home = false;
        $scope.customer = false;
        $scope.supplier = false;
        $scope.resource = false;
        $scope.purchase = false;
        $scope.request = false;
	}
	
	$scope.hideShowCustomers = function () {
	    $scope.info = false;
        $scope.home = false;
        $scope.customer = true;
        $scope.supplier = false;
        $scope.resource = false;
        $scope.purchase = false;
        $scope.request = false;
	}
	
	$scope.hideShowSuppliers = function () {
	    $scope.info = false;
        $scope.home = false;
        $scope.customer = false;
        $scope.supplier = true;
        $scope.resource = false;
        $scope.purchase = false;
        $scope.request = false;
    }
	
	$scope.hideShowResources = function () {
	    $scope.info = false;
        $scope.home = false;
        $scope.customer = false;
        $scope.supplier = false;
        $scope.resource = true;
        $scope.purchase = false;
        $scope.request = false;
    }
	
	$scope.hideShowPurchases = function () {
	    $scope.info = false;
        $scope.home = false;
        $scope.customer = false;
        $scope.supplier = false;
        $scope.resource = false;
        $scope.purchase = true;
        $scope.request = false;
    }
	
	$scope.hideShowRequests = function () {
	    $scope.info = false;
        $scope.home = false;
        $scope.customer = false;
        $scope.supplier = false;
        $scope.resource = false;
        $scope.purchase = false;
        $scope.request = true;
    }
	
	
	$scope.submitIt = function () {
	    var query = $scope.userInput;
        //var queryRegex = /(select)\s*(?:\*|[\w+\s+,.?])+\s*(from)\s*(?:|\w+([\w+\s+,.?]+))\s*\w+/i;
       
        //if (queryRegex.test(query)) {
            HttpService.post(query).then(
                function(queue) {
                    $scope.queries = queue;
                }, function(err) {
                    $scope.error = true;
                });
            $scope.userInput = '';
            $scope.hideShowResult();
       // }else {
       //   alert("Syntax Error");
       // }        
	}
	
});