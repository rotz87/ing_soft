var appelloApp = angular.module('appelloApp',[
                                              'appelloControllers',
                                              'appelloServices',
                                              'appelloFilters',
                                              'ngRoute'
                                              ]);
appelloApp.value('$sniffer', { history: false });
appelloApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) {

  $routeProvider.when('/:idClasse/appelli/:idAppello',{
	  templateUrl: 'partials/appelloParziale.html',
	  controller: 'faiAppello',
	  title:'Fai l\'appello'
  })
  .when('/:idClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'seleziona l\'appello'
  }).otherwise({
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli',
	  title:'altra pagina'
  });
	  $locationProvider.html5Mode(true);

}]);
