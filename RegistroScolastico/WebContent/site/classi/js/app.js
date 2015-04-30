var registroApp = angular.module('registroApp',[
                                              'registroControllers',
                                              'registroServices',
                                              'registroFilters',
                                              'ngRoute',
                                              'ngAnimate',
                                              'checklist-model'
                                              ]);
registroApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) 
{
  $routeProvider
  .when('/:idClasse/registroDiClasse/appelli/:idAppello/',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  }).when('/:idClasse/registroDiClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'Seleziona l\'appello'
  }).when('/:idClasse/',{
	  templateUrl: 'partials/elencoRegistri.html',
	  controller: 'elencoRegistri',
	  title:'Seleziona il registro'
  }).when('/:idClasse/appelli/',{
	  redirectTo:function(routeParams){
		  return "/"+routeParams.idClasse+'/';
	  }
  })
//  	.when('/:idClasse/registroDocente/',{
//	  templateUrl: 'partials/compito.html',
//	  controller: 'elencoMaterie',
//	  title:'Seleziona il registro Docente'
//  })
//  	.when('/:idClasse/registriDocente/:idRegistroDocente',{
//	  templateUrl: 'partials/compito.html',
//	  controller: '',
//	  title:'Seleziona l\'operazione'
//  })
  	.when('/:idClasse/registriDocente/:idRegistroDocente/',
  {
	  templateUrl:'partials/registroDocente.html',
	  controller:'funzioniRegistroDocente',
	  title:'Registro Docente'
  }).when('/:idClasse/registriDocente/:idRegistroDocente/compiti/',{
	  templateUrl: 'partials/elencoCompiti.html',
	  controller: 'riempiElencoCompiti',
	  title:'Elenco dei compiti'
  }).when('/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/',{
	  templateUrl: 'partials/compito.html',
	  controller: 'recuperaCompitoInClasse',
	  title:'Imposta il compito'
  }).when('/:idClasse/registriDocente/:idRegistroDocente/mediaVoti/',
  {
	  templateUrl:'partials/mediaVoti.html',
	  controller:'mediaVotiController',
	  title:'Calcola la media dei voti'
  }).when('/',
  {
	  templateUrl:'partials/elencoClassi.html',
	  controller:'riempiElencoClassi',
	  title:'seleziona la classe'
  })
  //$locationProvider.html5Mode({enabled:true,requireBase:true});
}]);
