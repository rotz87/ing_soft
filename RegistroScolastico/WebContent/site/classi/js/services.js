var registroServices = angular.module ('registroServices',["ngResource"]);

registroServices.factory('rsClasse',['$resource',
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
									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
									isArray:false
								},
								'prendiCompitiInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
									isArray:true,
								},
								'creaCompitoInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/',
									method:'POST',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'}
								},
								'aggiornaCompitoInClasse':{
									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito',
									method:'PUT',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'}
								},'argomentiSvolti':{
   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/argomentiSvolti',
   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
   									method:'GET',
   									isArray:true
   								},
   								'dateFestive':{
   									url:'/RegistroScolastico/api/classi/:idClasse/dateFestive',
   									params:{idClasse : '@idClasse'},
   									method:'GET',
   									isArray:false
   								},
   								'calendario':{
   									url:'/RegistroScolastico/api/calendario',
   									method:'GET',
   									isArray: false
   								},
   								'registriDocente':{
   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente',
   									params:{idClasse : '@idClasse'},
   									method:'GET',
   									isArray: true
   								}
							});
				}]);


registroServices.factory('Compito',['$resource',
                   				function($resource){
                   					return $resource('/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/', null,
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
                   								},
                   								'queryStudenti':{
                   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/studenti',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'GET',
                   									isArray:true
                   								},
                   								'inviaVoti':{
                   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/studenti',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'PUT',
                   									isArray:true
                   								},
                   								'getState':{
                   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'GET',
                   									isArray:false
                   								},
                   								'setState':{
                   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'PUT',
                   									isArray:false
                   								},
                   								'eliminaCompito':{
                   									url:'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'DELETE',
                   									isArray:false
                   								}
                   							});
                   				}]);

