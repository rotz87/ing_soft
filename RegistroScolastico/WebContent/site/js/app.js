var registroApp = angular.module('registroApp',[
                                              'registroControllers',
                                              'registroServices',
                                              'registroFilters',
                                              'ngRoute',
                                              'ngAnimate',
                                              'hateoas'
                                              ]);
registroApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) 
{
  $routeProvider
  .when('/impostazioni/',
  {
	  templateUrl:'partials/impostazioni.html',
	  controller:'impostazioniController',
	  title:'impostazioni'
  }).when('/classi/:idClasse/registroDiClasse/appelli/:idAppello/',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  }).when('/classi/:idClasse/registroDiClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'elencoAppelli',
	  title:'Seleziona l\'appello'
  }).when('/classi/:idClasse/',{
	  templateUrl: 'partials/elencoRegistri.html',
	  controller: 'elencoRegistri',
	  title:'Seleziona il registro'
  }).when('/classi/:idClasse/appelli/',{
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
  	.when('/classi/:idClasse/registriDocente/:idRegistroDocente/',
  {
	  templateUrl:'partials/registroDocente.html',
	  controller:'funzioniRegistroDocente',
	  title:'Registro Docente'
  }).when('/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/',{
	  templateUrl: 'partials/elencoCompiti.html',
	  controller: 'elencoCompiti',
	  title:'Elenco dei compiti'
  }).when('/classi/:idClasse/registriDocente/:idRegistroDocente/compiti/:idCompito/',{
	  templateUrl: 'partials/compito.html',
	  controller: 'compitoInClasse',
	  title:'Imposta il compito'
  }).when('/classi/:idClasse/registriDocente/:idRegistroDocente/mediaVoti/',
  {
	  templateUrl:'partials/mediaVoti.html',
	  controller:'mediaVoti',
	  title:'Calcola la media dei voti'
  }).when('/classi',
  {
	  templateUrl:'partials/elencoClassi.html',
	  controller:'elencoClassi',
	  title:'seleziona la classe'
  }).when('/',{
	  /*
	   * la pagina iniziale riporta automaticamente 
	   * all'elenco delle classi
	   * */
	  redirectTo:function(routeParams){
		  return "/classi/";
	  }
  })
  //$locationProvider.html5Mode({enabled:true,requireBase:true});
}]);
registroApp.config(function (HateoasInterceptorProvider) {
    HateoasInterceptorProvider.transformAllResponses();
});