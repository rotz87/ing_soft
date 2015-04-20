var registroServices = angular.module ('registroServices',["ngResource"]);

var host = ''
//var hostAddr = "10.170.50.1"
//var host = "http://"+hostAddr+":8080"
registroServices.factory('rsClasse',['$resource',
				function($resource){
					return $resource(host+'/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/', null,
							{
								'getAppello': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:true},
								'creaAppello': {method:'POST', params:{idClasse:'@idClasse'}},
								'aggiornaAppello': {method:'PUT', params:{idClasse:'@idClasse', idAppello:'@idAppello'}},
								'getAppelliClasse': {method:'GET', params:{idClasse:'@idClasse',idAppello:'@idAppello'}, isArray:false},
								'recuperaAssenti':{
									url: host+'/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti/', 
									method: 'GET', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}, 
									isArray:false},
								'registraAssenti':{
									url: host+'/RegistroScolastico/api/classi/:idClasse/appelli/:idAppello/assenti/', 
									method: 'POST', 
									params: { idClasse: '@idClasse', idAppello:'@idAppello'}
									},
								'listaStudenti':{
									url: host+'/RegistroScolastico/api/classi/:idClasse/studenti/',
									method: 'GET',
									params: { idClasse:'@idClasse',idAppello:'@idAppello'},
									isArray:true
									},
								'elencoClassi':{
									url:host+'/RegistroScolastico/api/classi/',
									method:'GET',
									isArray:true
									},
								'prendiCompitoInClasse':{
									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
									isArray:false
								},
								'prendiCompitiInClasse':{
									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/',
									method:'GET',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
									isArray:true,
								},
								'creaCompitoInClasse':{
									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/',
									method:'POST',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'}
								},
								'aggiornaCompitoInClasse':{
									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito',
									method:'PUT',
									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'}
								},
								'argomentiSvolti':{
   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/argomentiSvolti',
   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente'},
   									method:'GET',
   									isArray:true
   								},
   								'dateFestive':{
   									url:host+'/RegistroScolastico/api/classi/:idClasse/dateFestive',
   									params:{idClasse : '@idClasse'},
   									method:'GET',
   									isArray:false
   								},
   								'calendario':{
   									url:host+'/RegistroScolastico/api/calendario',
   									method:'GET',
   									isArray: false
   								},
   								'registriDocente':{
   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente',
   									params:{idClasse : '@idClasse'},
   									method:'GET',
   									isArray: true
   								}
							});
				}]);


registroServices.factory('Compito',['$resource',
                   				function($resource){
                   					return $resource(host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/', null,
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
                   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/studenti',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'GET',
                   									isArray:true
                   								},
                   								'inviaVoti':{
                   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/studenti',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'PUT',
                   									isArray:true
                   								},
                   								'getState':{
                   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'GET',
                   									isArray:false
                   								},
                   								'setState':{
                   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'PUT',
                   									isArray:false
                   								},
                   								'eliminaCompito':{
                   									url:host+'/RegistroScolastico/api/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/state',
                   									params:{idClasse : '@idClasse', idRegistroDocente:'@idRegistroDocente', idCompito:'@idCompito'},
                   									method:'DELETE',
                   									isArray:false
                   								}
                   							});
                   				}]);

