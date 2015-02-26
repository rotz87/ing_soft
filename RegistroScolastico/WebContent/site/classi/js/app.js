var appelloApp = angular.module('appelloApp',[
                                              'appelloControllers',
                                              'appelloServices',
                                              'appelloFilters',
                                              'ngRoute'
                                              ]);
appelloApp.value('$sniffer', { history: false });
appelloApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) 
{
  $routeProvider.when('/:idClasse/appelli/:idAppello',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  })
  .when('/:idClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'seleziona l\'appello'
  }).when('/:idClasse/appelli',{
	  redirectTo:function(routeParams){
		  return "/"+routeParams.idClasse+'/';
	  }
  }).when('/',
  {
	  templateUrl:'partials/elencoClassi.html',
	  controller:'riempiElencoClassi',
	  title:'seleziona la classe'
  })
  $locationProvider.html5Mode(true);
}]);
