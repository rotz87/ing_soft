var appelloServices = angular.module ('appelloServices',["ngResource"]);

appelloServices.factory('Appello',['$resource',
				function($resource){
					return $resource('/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello', null,
							{
								'myQuery': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:true},
								'myPost': {method:'POST', params:{idClasse:'@idClasse'}},
								'myUpdate': {method:'PUT', params:{idClasse:'@idClasse', idAppello:'@idAppello'}},
								'myQuery2': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:false},
							});
				}]);