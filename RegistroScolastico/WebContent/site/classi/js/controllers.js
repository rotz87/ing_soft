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
	$scope.testTitle;
	$rootScope.$on("$routeChangeSuccess", function(event, currentRoute, previousRoute) {
	    $rootScope.title = currentRoute.title;
	    $scope.testTitle = $rootScope.title;
	});
}]);
/*
 * Controller utilizzato per visualizzare l'elenco degli appelli in base alla classe selezionata
 */
appelloControllers.controller('riempiElencoAppelli', ['$scope','Appello','$location','$http','$rootScope','$q', function($scope, Appello, $location, $http, $rootScope, $q) {
	  var newUri;
	  $scope.idClasse = 0;
	  var nuovoAppello = {};
	  // parsing del path dell'appello selezionato
	  nuovoAppello = $location.path().split("/");
	  $scope.idClasse = nuovoAppello[1];
	  
	  $scope.mioController = "avviaAppello";
	  $scope.predicate="-data";
	  $scope.elencoAppelli={};
	  $scope.elencoAppelli2 = Appello.myQuery2({idClasse:$scope.idClasse},function(response,header){
		  //successo
	  },function(response,header){
		  //fallimento
	  })
	  /* 
	   * funzione avviata quando viene restituita la risposta dal server
	   * gestisce l'elenco degli appelli per poter valutare l'inserimento dell'appelloAvviabile
	   * nell'elenco degli appelli
	   */
	  $q.when($scope.elencoAppelli2.$promise).then(function(result){
		  var aggiungiAppello = false;
		  var trovato = false;
		  $scope.elencoAppelli = result.appelli;
		  for (key in result.appelli)
		  {
			  if (new Date(result.appelli[key].data).toDateString() == new Date(result.dataAppelloAvviabile).toDateString())
			  {
				  trovato = true;
			  }
		  }
		  if(trovato == false)
		  {
			  /*
			   * l'appello con dataAppelloAvviabile non è presente 
			   * nell'elenco degi appelli che sono arrivati dal server
			   */
			  var newAppello = {};
			  newAppello.data = result.dataAppelloAvviabile;
			  newAppello.idAppello = null;
			  newAppello.appelloAvviabile = result.appelloAvviabile;
			  $scope.elencoAppelli.push(newAppello)
		  }

	  },function(result){
		  $scope.erroreSistema = 'è avvenuto un errore, probabilmente la classe selezionata non esiste'
	  })
	  
	  var nuovoUri=[];
	  $scope.appelloCreato = {};
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(data,header){
				$scope.appelloUri = header("location");
				nuovoUri = $scope.appelloUri.split("/");
				
				newUri = $scope.appelloUri;
				$scope.myUrl=newUri;
				$rootScope.mioDato = {};
				$rootScope.nuovoAppello = {};
			    $rootScope.nuovoAppello = PostsCtrlAjax($scope, $http, $scope.myUrl, $rootScope.mioDato, $location)
			});
		}
		$scope.mostraAppello = function(idAppello){
			$scope.idAppello = idAppello;
			$location.path($location.path()+"appelli/"+idAppello);
		}
		$rootScope.idClasse = $scope.idClasse;
		$rootScope.idAppello = null;
	}])
	.directive('elencoAppello', function() {
	  return {
		restrict : 'E',
		transclude:true,
	    templateUrl: 'partials/elencoAppelli.html'
	  };

	});

appelloControllers.controller('faiAppello', ['$scope','Appello','$location','$http','$rootScope','$filter','$q', function($scope, Appello, $location, $http, $rootScope, $filter, $q){
		$scope.appelloSelezionato = {};
		var nuovoAppello;
		if ($rootScope.mioDato)
		{
			var resourceUrl;
			$scope.appelloSelezionato = $rootScope.mioDato;
			for (var key in $scope.appelloSelezionato.data.links)
			{
				if($scope.appelloSelezionato.data.links[key].rel == "self"){
					resourceUrl = $scope.appelloSelezionato.data.links[key].href;
					nuovoAppello = $location.path().split("/")
				}
			}
			$scope.idClasse = nuovoAppello[1];
			$scope.idAppello = nuovoAppello[3];
			$scope.mioAppello = retrieveObjectFromUrl($http, resourceUrl);
			path = resourceUrl;
		}
		else
		{
			nuovoAppello = $location.path().split("/");
			$scope.idClasse = nuovoAppello[1];
			$scope.idAppello = nuovoAppello[3];
			path = "/RegistroScolastico/api/classi/"+$scope.idClasse+"/appelli/"+$scope.idAppello;
		}
		/*
		 * codice di esempio di un appello:
		 * 
		 */
		$scope.predicate = 'cognome';

		var appelloStudenti = new Appello();
		appelloStudenti.idClasse = $scope.idClasse;
		$scope.studenti = Appello.listaStudenti(
				{idClasse:$scope.idClasse}, 
				function(response, header){
					//successo
				},
				function(response,header){
					//fallimento
					$scope.erroreSistema.studenti = "non sono riuscito a caricare gli studenti"
				});

		var appelloCorrente = new Appello();
		appelloCorrente.idClasse = $scope.idClasse;
		appelloCorrente.idAppello = $scope.idAppello;
		$scope.appello = Appello.myQuery2(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function (response,header)
				{
					//successo
				},
				function(response, header)
				{
					$scope.erroreSistema.appello = "non sono riuscito a caricare l'appello!!!!"
				})

		
		$scope.assenti = Appello.recuperaAssenti(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function(response,header)
				{
					//successo
				},
				function(response,header)
				{
					$scope.erroreSistema.assenti = "fallito il recupero degli assenti nell'appello";
				});
		/*
		 * Funzione richiamata ogni volta che viene cliccata una checkbox per prendere
		 * l'assenza di uno studente
		 */
		$scope.segnaAssenza = function (idStudente){
			if ($scope.appello.assenzeSemplici[idStudente].idStudente == null)
			{
				$scope.appello.assenzeSemplici[idStudente].idStudente = idStudente
				for( var myId in $scope.assenti.assenti)
				{
					myId = idStudente;
				}
				$scope.assenti.assenti.push(idStudente);
			}
			else
			{
				delete $scope.appello.assenzeSemplici[idStudente];
				for (var assenzaCurr in $scope.assenti.assenti)
				{
					if ($scope.assenti.assenti[assenzaCurr] == idStudente)
					{
						$scope.assenti.assenti.splice(assenzaCurr,1);
					}
				}
			}
		};
		$scope.myInput = {}
		$scope.registraAppello = function (){
			
			var assenti = new Appello();
			assenti.assenti = $scope.assenti.assenti;
			assenti.$registraAssenti({idAppello: $scope.idAppello, idClasse: $scope.idClasse},
			function(data,header){
				//successo
				$scope.appello.assenzePrese = true;
				$scope.myInput.messaggio = "le assenze sono state registrate";
				$scope.modalTitle = "Appello registrato";
				$scope.modalColor = "modal-header-success";
				$scope.modalBtn = "btn-success";
				$scope.bottoneDesc="aggiorna appello";
				$scope.controllaAppello();
			},function(data){
				//fallimento
				$scope.erroreSistema.registrazione = "errore in fase di registrazione!!!!";
				$scope.myInput.messaggio = "è avvenuto un errore nella registrazione";
				$scope.myInput.status = data.status;
				$scope.myInput.statusText = data.statusText;
				$scope.modalTitle = "Errore";
				$scope.modalColor = "modal-header-danger";
				$scope.modalBtn = "btn-danger";
			})
		};
		
		//funzione richiamata quando viene azionato la registrazione e l'aggiornamento dell'appello
		$scope.inviaAppello = function (){
			if ($scope.appello.assenzePrese)
			{
				//aggiornamento dell'appello da inviare con ritardi, uscite anticipate, giustificazioni
				$scope.nonSupportato();
			}
			else
			{
				$scope.registraAppello();
			}
		}

		var deferred = $q.defer();
		$q.all({ studenti: $scope.studenti.$promise, appello: $scope.appello.$promise, assenti: $scope.assenti.$promise})
		.then(function(results){
			results.appello.assenzeSemplici = 
				$filter('assente')(results.assenti.assenti,results.studenti);
			if (results.appello.assenzePrese)
			{
				$scope.bottoneDesc = "aggiorna appello";
			}
			else
			{
				$scope.bottoneDesc = "Registra appello";
			}
			$scope.controllaAppello();
			$rootScope.idClasse = $scope.idClasse;
			$rootScope.idAppello = $scope.idAppello;
		})
		
		$scope.erroreSistema = {};
		
		$scope.conferma = function()
		{
			$('#myModal').on('shown.bs.modal', function () {
			    $('#myInput').focus();
			  })
		}
		$scope.gestisciRitardo = function (){
			$scope.nonSupportato();
		}
		$scope.gestisciUscita = function (){
			$scope.nonSupportato();
		}
		$scope.gestisciGiustificazione = function (){
			$scope.nonSupportato();
		}
		
		$scope.nonSupportato = function(){
			$scope.modalTitle = "Funzione non supportata";
			$scope.myInput.messaggio = "Attualmente questa azione non è supportata";
			$scope.modalColor = "modal-header-info";
			$scope.modalBtn = "btn-info";
			$scope.bottoneDesc="aggiorna appello";
		}
		$scope.disabilitaRitardo = true; 
		$scope.disabilitaUscita = true;
		$scope.disabilitaGiustificazione = true;
		
		$scope.controllaAppello = function()
		{

			for (var key in $scope.studenti)
			{
				var assente = ($scope.appello.assenzePrese == false);
				if($scope.appello.assenzePrese == true)
				{
					if ($scope.appello.assenzeSemplici[$scope.studenti[key].idStudente])
					{
						if($scope.appello.assenzeSemplici[$scope.studenti[key].idStudente].assenza == true)
						{
							assente = true;
						}
					}
				}
				$scope.studenti[key].disabilitaGiustificazione = assente;
				$scope.studenti[key].disabilitaUscita = assente;
				$scope.studenti[key].disabilitaRitardo = !assente || $scope.appello.assenzePrese == false;
			}
		}
}]);

function PostsCtrlAjax($scope, $http, myUri, destinazione, $location) {
    var risorsa = {};
    $http({method: 'GET', url: myUri }).success(function(data,header) {
        destinazione.data = data;
        destinazione.url = $scope.idClasse+"/appelli/"+data.idAppello;
        risorsa = destinazione;
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

appelloControllers.controller('popolamentoNavigazione', ['$scope','Appello','$q','$rootScope','$filter', function($scope, Appello, $q, $rootScope,$filter){

	$scope.$watch("idClasse",function(newValue,oldValue){
		
		if(newValue != null)
			{
			$scope.elencoClassi = Appello.elencoClassi({},function(response,header)
					{
						//successo
						for(classe in response)
							{
								if (response[classe].idClasse == $scope.selezioneAttuale.idClasse)
									{
										$scope.selezioneAttuale.classe = response[classe];
									}
								}
							},
					function(response,header){
						//fallimento
					});
			}
		else if (newValue != oldValue)
		{
			
			$scope.elencoClassi = Appello.elencoClassi({},function(response,header)
					{
						//successo
					
					},
					function(response,header){
						//fallimento
					})
			$scope.elencoAppelli = Appello.myQuery2({idClasse:newValue},function(response,header){
				  //successo
			  },function(response,header){
				  //fallimento
			  })
		}
		$scope.selezioneAttuale = {};
		$scope.selezioneAttuale.idClasse = $scope.idClasse;
		$scope.selezioneAttuale.idAppello = $scope.idAppello;
		
		$scope.$watch("idAppello",function(newAppello,oldAppello){
			if(newAppello != null)
			{
				$scope.selezioneAttuale.idAppello = newAppello;
				$scope.elencoAppelli = Appello.myQuery2({idClasse:$scope.idClasse},
					function(response,header)
						{
						  //successo
						for(appello in response.appelli)
						{
							if (response.appelli[appello].idAppello == $scope.selezioneAttuale.idAppello)
								{
									$scope.selezioneAttuale.appello = response.appelli[appello];
								}
							}
						},function(response,header){
							//fallimento
						});
			}
		})
	})
}]);