var ServiceController = function( $scope, $http ){
        $scope.services = [];
        $scope.base = undefined;
        $scope.serviceId = undefined;
        $scope.additionalParams = [];
        $http.get('/rest/order/types')
            .success( function(services){
                var svcArray = [];
              _(services).each( function(elem){
                 if( elem.name == "_"){
                   $scope.base = elem;
                 }
                 else if( elem.name ){
                     svcArray.push( elem );
                 }
              });
              $scope.services = svcArray;
            })
            .error( function( errorData ){

            });
    $scope.$watch( 'serviceId', function( newVal ){
        if( newVal != undefined ){
            var service = _($scope.services).find( function(elem){
              return elem.oid == newVal;
            });
            if( service ){
                $scope.additionalParams = ( service.params || [] );
            }
        }
    });
}