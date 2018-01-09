app.directive("search", function() {
	return {
		restrict: "E", 
		templateUrl: "../../views/templates/search.tmp.html"
	}
}).directive("info", function() {
	return {
		restrict: "E",
		templateUrl: "../../views/templates/info.tmp.html"
	}
}).directive("resources", function() {
    return {
        restrict: "E", 
        templateUrl: "../../views/templates/resources.tmp.html"
    }
}).directive("requests", function() {
    return {
        restrict: "E",
        templateUrl: "../../views/templates/requests.tmp.html"
    }
}).directive("customers", function() {
    return {
        restrict: "E", 
        templateUrl: "../../views/templates/customers.tmp.html"
    }
}).directive("suppliers", function() {
    return {
        restrict: "E",
        templateUrl: "../../views/templates/suppliers.tmp.html"
    }
});