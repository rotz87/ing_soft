var appelloControllers =  angular.module('appelloControllers',[]);

appelloControllers.controller('avviaAppello',['$scope','Appello','$location',function($scope,Appello,$location){
		$scope.idClasse = 0;
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(data,header){
				console.log(data);
				console.log(header());
				$scope.appelloUri = header("location");
				
			});
			var myuri = "appelli";
			$location.path("0/appelli/");
			$location.replace();
			console.log($location.protocol());
			console.log($location.href);
			console.log($location.host());
			console.log($location.port());
			console.log($location.hash());
			
			console.log($location.absUrl());
			console.log($location.hash());
		}
		
	}]);

appelloControllers.controller('riempiAppelli', ['$scope', function($scope) {
  $scope.appello1 = { data: 'Naomi', azione: 'visualizza' };
  $scope.appello2 = { data: 'Igor', azione: 'Avvia' };
}])
.directive('mioAppello', function() {
  return {
	restrict : 'E',
	transclude:true,
    scope: {
      appelloInfo: '=info'
    },
    templateUrl: 'partials/appelli.html'
  };
});
appelloControllers.controller('riempiElencoAppelli', ['$scope','Appello','$location', function($scope, Appello, $location) {
	  $scope.appello1 = { data: 'Naomi', azione: 'visualizza' };
	  $scope.appello2 = { data: 'Igor', azione: 'Avvia' };
	  $scope.mioController = "avviaAppello";
	  $scope.elencoAppelli = [{data:'naomi',azione:'visualizza',esiste:"true"},
	                          {data:'peppe',azione:'Avvia',esiste:"false"},
	                          {data:'giu',azione:'Avvia',esiste:"false"},
	                          {data:'pic',azione:'Avvia',esiste:"false"},
	                          {data:'tiz',azione:'Avvia',esiste:"false"}
	                          ];
	  $scope.mioController = {nome:"ng-controller",azione:"creaAppello(0)"};
	  var creaAppello = false;
	  for(var i=0;i<$scope.elencoAppelli.length;i++)
		  {
		  	if($scope.elencoAppelli[i].esiste == "true"){
		  		$scope.elencoAppelli[i].click = "";
		  	}
		  	else if ($scope.elencoAppelli[i].esiste == "false" && creaAppello == false)
		  	{
		  		creaAppello = true;
		  		$scope.elencoAppelli[i].click = "creaAppello(0)";
		  		
		  	}
		  	else
		  	{
		  		$scope.elencoAppelli[i].click = "";
		  	}
		  }
	  /*
	   * codice per la prova dei dati json
	   * {
            'id': '0',
            'data': '1288323623006',
            'studenti': [
                {
                    'idStudente': '00000001',
                    'nome': 'Maccio',
                    'cognome': 'Capatonda'
                },
                {
                    'idStudente': '00000002',
                    'nome': 'Maccio2',
                    'cognome': 'Capatonda2'
                },
                {
                    'idStudente': '00000003',
                    'nome': 'Maccio3',
                    'cognome': 'Capatonda3'
                }
            ]
        }
	   *
	   */
	  $scope.idClasse = 0;
	  var nuovoUri=[];
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(data,header){
				console.log(data);
				console.log(header());
				$scope.appelloUri = header("location");
				nuovoUri = $scope.appelloUri.split("/");
				console.log(nuovoUri.length);
				$location.path("0/appelli/"+nuovoUri[nuovoUri.length-1]);
			});
			var myuri = "appelli";
			
			
			//$location.replace();
			
			$window.location.href
		}
		
	}])
	.directive('elencoAppello', function() {
	  return {
		restrict : 'E',
		transclude:true,
	    templateUrl: 'partials/elencoAppelli.html'
	  };
	});