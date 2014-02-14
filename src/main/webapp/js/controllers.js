var ServiceController = function( $scope, $http ){
        $scope.services = [];
        $http.get('/rest/order/types')
            .success( function(services){
              $scope.services = services;
            })
            .error( function( errorData ){

            });
}