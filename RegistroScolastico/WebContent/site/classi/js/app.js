var appelloApp = angular.module('appelloApp',[
                                              'appelloControllers',
                                              'appelloServices',
                                              'appelloFilters',
                                              'ngRoute'
                                              ]);
appelloApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) 
{
  $routeProvider
  .when('/:idClasse/appelli/:idAppello/',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  }).when('/:idClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'seleziona l\'appello'
  }).when('/:idClasse/registri',{
	  templateUrl: 'partials/menuClasse.html',
	  controller: '',
	  title:'seleziona il registro'
  }).when('/:idClasse/registri/registroDocente/',{
	  templateUrl: 'partials/compito.html',
	  controller: '',
	  title:'seleziona il registro Docente'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente',{
	  templateUrl: 'partials/compito.html',
	  controller: '',
	  title:'seleziona l\'operazione'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente/compiti/',{
	  templateUrl: 'partials/elencoCompiti.html',
	  controller: 'riempiElencoCompiti',
	  title:'elenco dei compiti'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente/compiti/:idCompito',{
	  templateUrl: 'partials/compito.html',
	  controller: 'recuperaCompitoInClasse',
	  title:'imposta il compito'
  }).when('/:idClasse/appelli/',{
	  redirectTo:function(routeParams){
		  return "/"+routeParams.idClasse+'/';
	  }
  }).when('/',
  {
	  templateUrl:'partials/elencoClassi.html',
	  controller:'riempiElencoClassi',
	  title:'seleziona la classe'
  })
  //$locationProvider.html5Mode({enabled:true,requireBase:true});
}]);
