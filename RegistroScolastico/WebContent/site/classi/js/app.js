var appelloApp = angular.module('appelloApp',[
                                              'appelloControllers',
                                              'appelloServices'
                                              ]);
appelloApp.value('$sniffer', { history: false });
appelloApp.config(function($locationProvider) {
  $locationProvider.html5Mode(false).hashPrefix('');
})