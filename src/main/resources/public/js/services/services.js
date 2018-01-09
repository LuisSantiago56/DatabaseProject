app.service("HttpService", function($http, $q) {
    
    this.post = function(query) {
        var deferred = $q.defer();
        
        $http({
            url: "/AddQuery",
            method: "POST",
            data: JSON.stringify({
                userInput: query
            })
        }).then(function(resp) {
            deferred.resolve(resp.data);
        }, function(err) {
            deferred.reject(err);
        });
        return deferred.promise;
    }
    
    this.get = function(query) {
        var deferred = $q.defer();
        $http ({
            url: "/GetQueries",
            method: "GET"
        }).then(function(resp) {
            deferred.resolve(resp.data);
        }, function(err) {
            deferred.reject(err);
        });
        return deferred.promise;
    }
    
})