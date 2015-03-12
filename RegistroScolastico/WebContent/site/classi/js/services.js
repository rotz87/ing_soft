var appelloServices = angular.module ('appelloServices',["ngResource"]);

appelloServices.factory('Appello',['$resource',
				function($resource){
					return $resource('/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/', null,
							{
								'myQuery': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:true},
								'myPost': {method:'POST', params:{idClasse:'@idClasse'}},
								'myUpdate': {method:'PUT', params:{idClasse:'@idClasse', idAppello:'@idAppello'}},
								'myQuery2': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:false},
								'recuperaAssenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti/', 
									method: 'GET', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}, 
									isArray:false},
								'registraAssenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti/', 
									method: 'POST', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}
									},
								'listaStudenti':{
									url: '/RegistroScolastico/api/classi/:idClasse/studenti/',
									method: 'GET',
									params: { idClasse:'@idClasse',idAppello:'@idAppello'},
									isArray:true
									},
								'elencoClassi':{
									url:'/RegistroScolastico/api/classi/',
									method:'GET',
									isArray:true
									},
								'prendiCompitoInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registroDocente/:idRegistroDocente/compiti/:idCompito',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
									isArray:false
								},
								'prendiCompitiInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registroDocente/:idRegistroDocente/compiti/',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
									isArray:true,
								},
								'creaCompitoInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registroDocente/:idRegistroDocente/compiti/',
									method:'POST',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'}
								},
								'aggiornaCompitoInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registroDocente/:idRegistroDocente/compiti/:idCompito',
									method:'PUT',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'}
								}
							});
				}]);


appelloServices.factory('Compito',['$resource',
                   				function($resource){
                   					return $resource('/RegistroScolastico/api/classi/:idClasse/registroDocente/:idRegistroDocente/compiti/:idCompito', null,
                   							{
                   								'get':{
                   									method:'GET',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									isArray:false
                   								},
                   								'query':{
                   									method:'GET',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
                   									isArray:true,
                   								},
                   								'creaCompitoInClasse':{
                   									method:'POST',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'}
                   								},
                   								'save':{
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'PUT'
                   								}
                   							});
                   				}]);

