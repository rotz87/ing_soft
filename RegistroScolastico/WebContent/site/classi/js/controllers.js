var esisto
var appelloControllers =  angular.module('appelloControllers',[]);

appelloControllers.controller('avviaAppello',['$scope','Appello','$location',function($scope,Appello,$location){
		$scope.idClasse = 0;
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(data,header){
				$scope.appelloUri = header("location");
			});
			
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

appelloControllers.controller('templateTitolo', ['$scope','$location','$rootScope', function($scope, $location,$rootScope){
	$scope.testTitle
	$rootScope.$on("$routeChangeSuccess", function(event, currentRoute, previousRoute) {
	    $rootScope.title = currentRoute.title;
	    $scope.testTitle = $rootScope.title;
	});
	//console.log($scope.testTitle);
	}]);

appelloControllers.controller('riempiElencoAppelli', ['$scope','Appello','$location','$http','$rootScope', function($scope, Appello, $location, $http, $rootScope) {
	  var newUri;
	  var nuovoUri=[];
	  $scope.appelloUri={}
	  $scope.idClasse = 0;
	  nuovoAppello = {}
	  nuovoAppello = $location.path().split("/")
	  $scope.idClasse = nuovoAppello[1];
	  
	  $scope.appello1 = { data: 'Naomi', azione: 'visualizza' };
	  $scope.appello2 = { data: 'Igor', azione: 'Avvia' };
	  $scope.mioController = "avviaAppello";
	  $scope.elencoAppelli = [{data:'naomi',azione:'visualizza',esiste:"true"},
	                          {data:'peppe',azione:'Avvia',esiste:"false"},
	                          {data:'giu',azione:'Avvia',esiste:"false"},
	                          {data:'pic',azione:'Avvia',esiste:"false"},
	                          {data:'tiz',azione:'Avvia',esiste:"false"}
	                          ];
	  $scope.mioController = {nome:"ng-controller", azione:"creaAppello("+$scope.idClasse+")"};
	  
	  var creaAppello = false;
	  for(var i=0;i<$scope.elencoAppelli.length;i++)
		  {
		  	if($scope.elencoAppelli[i].esiste == "true"){
		  		$scope.elencoAppelli[i].click = "";
		  	}
		  	else if ($scope.elencoAppelli[i].esiste == "false" && creaAppello == false)
		  	{
		  		creaAppello = true;
		  		$scope.elencoAppelli[i].click = "creaAppello";
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
	  
	  
	  var nuovoUri=[];
	  $scope.appelloCreato = {};
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(data,header){
				
				//console.log(data);
				//console.log(header("location"));
				$scope.appelloUri = header("location");
				nuovoUri = $scope.appelloUri.split("/");
				
				newUri = $scope.appelloUri;
				$scope.myUrl=newUri;
				$rootScope.mioDato = {};
				$rootScope.nuovoAppello = {};
			    $rootScope.nuovoAppello = PostsCtrlAjax($scope, $http, $scope.myUrl, $rootScope.mioDato, $location)

			    //$location.path($rootScope.nuovoAppello.url);
			});
//			Appello.myQuery3({myUrl:$scope.myUrl},function(data,header){
//				console.log("inizio")
//				console.log(data)
//				console.log("fine")
//				console.log($scope.myUrl)
//			})
			


			//$location.replace();
			
		}
	}])
	.directive('elencoAppello', function() {
	  return {
		restrict : 'E',
		transclude:true,
	    templateUrl: 'partials/elencoAppelli.html'
	  };

	});

appelloControllers.controller('faiAppello', ['$scope','Appello','$location','$http','$rootScope','$filter', function($scope, Appello, $location, $http, $rootScope, $filter){
		$scope.appelloSelezionato = {};
		var nuovoAppello;
		if ($rootScope.mioDato)
		{
			$scope.appelloSelezionato = $rootScope.mioDato;
			resourceUrl = $scope.appelloSelezionato.data.links[1].href
			nuovoAppello = resourceUrl.split("/")
			$scope.idClasse = nuovoAppello[nuovoAppello.length-3];
			$scope.idAppello = nuovoAppello[nuovoAppello.length-1];
			$scope.mioAppello = retrieveObjectFromUrl($http, resourceUrl);
			path = resourceUrl
		}
		else
		{
			nuovoAppello = $location.path().split("/")
			$scope.idClasse = nuovoAppello[1];
			$scope.idAppello = nuovoAppello[3];
			path = "/RegistroScolastico/api/classi/"+$scope.idClasse+"/appelli/"+$scope.idAppello
//			Appello.myQuery2({idClasse : $scope.idClasse, idAppello : $scope.idAppello}, function(response,header){
//				$scope.appelloSelezionato = response;
//			})
		}
		/*
		 * codice di esempio di un appello:
		 * 
		 */
		$scope.appelloTemp = {
	            'id': '0',
	            'data': '1288323623006',
	            'assenzePrese' : 'false',
	            'studenti': [
	                {
	                    'idStudente': '00000001',
	                    'nome': 'Mario',
	                    'cognome': 'Rossi',
	                    'assenza' : 'true'
	                },
	                {
	                    'idStudente': '00000002',
	                    'nome': 'Giorgio',
	                    'cognome': 'Ughi',
	                    'assenza' : 'false'
	                },
	                {
	                    'idStudente': '00000003',
	                    'nome': 'Aldo',
	                    'cognome': 'Verdi',
	                    'assenza' : 'true'
	                }
	            ],
				'assenzeSemplici' : [
					1,
					4,
					2
				]
	        }
		$scope.predicate = 'cognome'
		$scope.appello = $scope.appelloTemp;
		$scope.studenti = $scope.appelloTemp.studenti;

		Appello.myQuery2({idClasse:$scope.idClasse, idAppello:$scope.idAppello},function(response,header){
			$scope.appello.data = response.data;
			$scope.appelloTest = response;
			$scope.appello.studenti = response.studenti;
			$scope.appello.assenze = response.assenze;
			
			$scope.appello.assenzePrese = response.assenzePrese;
//			var arrayStudenti = [];
//			for (var j = 0; j < $scope.appello.studenti.length;j++)
//			{
//				//arrayStudenti[j] = $scope.appello.studenti[j].idStudente
//				arrayStudenti[j] = {idStudente : $scope.appello.studenti[j].idStudente}
//			}
			
			//$scope.appello.assenze = $scope.appello.assenzeSemplici
			//$scope.appello.assenzeSemplici = $filter('assente')($scope.appello.assenze,$scope.appello.studenti);
			Appello.recuperaAppelli({idClasse:$scope.idClasse,idAppello:$scope.idAppello},function(response,header){
				$scope.appello.assenze = response;
				$scope.appello.assenzeSemplici = $filter('assente')($scope.appello.assenze,$scope.appello.studenti);
			})
		});

		//$scope.appello.studenti = $scope.studenti;
		$scope.segnaAssenza = function (idStudente){
			if ($scope.appello.assenzeSemplici[idStudente].idStudente == null)
			{
				$scope.appello.assenzeSemplici[idStudente].idStudente = idStudente
				for( var myId in $scope.appello.assenze)
				{
					myId = idStudente;
				}
				$scope.appello.assenze.push(idStudente)
				
			}
			else
			{
				delete $scope.appello.assenzeSemplici[idStudente];
				for (var assenzaCurr in $scope.appello.assenze)
				{
					console.log($scope.appello.assenze[assenzaCurr]);
					if ($scope.appello.assenze[assenzaCurr] == idStudente)
					{
						$scope.appello.assenze.splice(assenzaCurr,1);
					}
					
				}
				
			}
			
		};
		
		$scope.registraAppello = function (){
			$scope.appello.assenzePrese = "true";
			Appello.myUpdate({idClasse : $scope.idClasse, idAppello : $scope.idClasse, Appello : $scope.appello}, function(response,header){
				console.log(response);
				console.log(header());
			});
		};
		$scope.appello.assenzePrese = Boolean($scope.appello.assenzePrese.valueOf())

}]);

function PostsCtrlAjax($scope, $http, myUri, destinazione, $location) {
    var risorsa = {}
    $http({method: 'GET', url: myUri }).success(function(data,header) {
        destinazione.data = data;
        destinazione.url = $scope.idClasse+"/appelli/"+data.idAppello
        risorsa = destinazione
        $location.path(destinazione.url);
    });
    return risorsa;
}
function retrieveObjectFromUrl($http, resourceUrl, destinazione){
	var remoteObject = {};
	$http({method:'GET', url: resourceUrl}).success(function(data){
		remoteObject = data;
		destinazione = data;
	});
	return remoteObject;
}