var ServiceController = function( $scope, $http ){
        $scope.services = [];
        $scope.base = undefined;
        $scope.serviceId = undefined;
        $scope.additionalParams = [];
        $scope.translatedMessage = "<pre>Microphone Check</pre>";
        $scope.showError = false;
        $scope.submitOrder = function(){
            $scope.showError = false;
            $scope.translatedMessage = undefined;
             var data = {
                 orderId : $scope.orderId,
                 orderType : $scope.orderType,
                 messageBody : $scope.messageBody
             };
             $http.post( '/rest/order/translate', data )
                 .success( function( response ){
                     $scope.translatedMessage = response.body;
                 })
                 .error( function( errorData){
                    $scope.showError = true;
                 });
        };
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
                $scope.orderType = service.name;
                $scope.additionalParams = ( service.params || [] );
            }
        }
    });
}