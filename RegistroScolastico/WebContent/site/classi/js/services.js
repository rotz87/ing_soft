var appelloServices = angular.module ('appelloServices',["ngResource"]);

appelloServices.factory('Appello',['$resource','$http','$log',
				function($resource,$http,$log){
					return $resource('/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/', null,
							{
								'myQuery': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:true},
								'myPost': {method:'POST', params:{idClasse:'@idClasse'}},
								'myUpdate': {method:'PUT', params:{idClasse:'@idClasse', idAppello:'@idAppello'}},
								'myQuery2': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:false},
								'recuperaAssenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti', 
									method: 'GET', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}, 
									isArray:false},
								'registraAssenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti', 
									method: 'POST', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}
									},
								'listaStudenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/studenti',
									method: 'GET',
									params: {idClasse:'@idClasse'},
									isArray:true
									},
								'elencoClassi':{
									url:'/RegistroScolastico/api/classi/',
									method:'GET',
									isArray:true
								}
							});
				}]);