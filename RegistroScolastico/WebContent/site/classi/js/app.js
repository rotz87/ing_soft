var appelloApp = angular.module('appelloApp',[
                                              'appelloControllers',
                                              'appelloServices',
                                              'ngRoute'
                                              ]);
appelloApp.value('$sniffer', { history: false });
appelloApp.config(["$locationProvider","$routeProvider",function($locationProvider,$routeProvider) {
  $locationProvider.html5Mode(false).hashPrefix('');
  $routeProvider.when('/:idClasse/appelli/:idAppello',{
	  templateUrl: 'partials/appelloParziale.html'
  })
  .when('/:idClasse/',{
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli'
  }).otherwise({
	  templateUrl: 'partials/elencoAppelli.html',
	  controller: 'riempiElencoAppelli'
  });
}])