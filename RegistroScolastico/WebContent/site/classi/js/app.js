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
  .when('/:idClasse/appelli/:idAppello/',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  }).when('/:idClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'Seleziona l\'appello'
  }).when('/:idClasse/registri',{
	  templateUrl: 'partials/menuClasse.html',
	  controller: '',
	  title:'Seleziona il registro'
  }).when('/:idClasse/registri/registroDocente/',{
	  templateUrl: 'partials/compito.html',
	  controller: '',
	  title:'Seleziona il registro Docente'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente',{
	  templateUrl: 'partials/compito.html',
	  controller: '',
	  title:'Seleziona l\'operazione'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente/compiti/',{
	  templateUrl: 'partials/elencoCompiti.html',
	  controller: 'riempiElencoCompiti',
	  title:'Elenco dei compiti'
  }).when('/:idClasse/registri/registroDocente/:idRegistroDocente/compiti/:idCompito',{
	  templateUrl: 'partials/compito.html',
	  controller: 'recuperaCompitoInClasse',
	  title:'Imposta il compito'
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
