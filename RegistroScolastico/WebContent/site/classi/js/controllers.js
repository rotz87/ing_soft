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

appelloControllers.controller('riempiElencoAppelli', ['$scope','Appello','$location','$http','$rootScope','$q', function($scope, Appello, $location, $http, $rootScope, $q) {
	  var newUri;
	  $scope.idClasse = 0;
	  var nuovoAppello = {}
	  nuovoAppello = $location.path().split("/")
	  $scope.idClasse = nuovoAppello[1];
	  
	  $scope.mioController = "avviaAppello";
	  
//	  $scope.elencoAppelli = [{idAppello:"1", data:'naomi'},
//	                          {idAppello:"2", data:'peppe'},
//	                          {idAppello:"3", data:'giu'},
//	                          {idAppello:"4", data:'pic'},
//	                          {idAppello:null, data:'tiz', appelloAvviabile:true},
//	                          {idAppello:null, data:'tiz', appelloAvviabile:false}
//	                          ];
	  $scope.predicate="-data";
	  $scope.elencoAppelli={}
	  $scope.elencoAppelli2 = Appello.myQuery2({idClasse:$scope.idClasse},function(response,header){
		  //successo
	  },function(response,header){
		  //fallimento
	  })
	  $q.when($scope.elencoAppelli2.$promise).then(function(result){
		  var aggiungiAppello = false;
		  var trovato = false;
		  $scope.elencoAppelli = result.appelli;
		  for (key in result.appelli)
		  {
			  if (result.appelli[key].data == result.dataAppelloAvviabile)
			  {
				  trovato = true;
			  }
		  }
		  if(trovato == false)
		  {
			  var newAppello = {};
			  newAppello.data = result.dataAppelloAvviabile;
			  newAppello.idAppello = null;
			  newAppello.appelloAvviabile = result.appelloAvviabile;
			  $scope.elencoAppelli.push(newAppello)
		  }

	  },function(result){
		  console.log("errore")
		  $scope.erroreSistema = 'è avvenuto un errore, probabilmente la classe selezionata non esiste'
	  })
	  
//	  var creaAppello = false;
//	  for(var i=0;i<$scope.elencoAppelli.length;i++)
//		  {
//		  	if($scope.elencoAppelli[i].esiste == "true"){
//		  		$scope.elencoAppelli[i].click = "";
//		  	}
//		  	else if ($scope.elencoAppelli[i].esiste == "false" && creaAppello == false)
//		  	{
//		  		creaAppello = true;
//		  		$scope.elencoAppelli[i].click = "creaAppello";
//		  	}
//		  	else
//		  	{
//		  		$scope.elencoAppelli[i].click = "";
//		  	}
//		  }
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
		}
		$scope.mostraAppello = function(idAppello){
			console.log(idAppello)
			$scope.idAppello = idAppello
			$location.path($location.path()+"appelli/"+idAppello)
		}
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
			console.log("ciaoo")
			console.log($rootScope.mioDato)
			console.log($location.path())
			console.log("ciaoo")
			$scope.appelloSelezionato = $rootScope.mioDato;
			console.log($scope.appelloSelezionato.data.links)
			for (var key in $scope.appelloSelezionato.data.links)
			{
				if($scope.appelloSelezionato.data.links[key].rel == "self"){
					resourceUrl = $scope.appelloSelezionato.data.links[key].href;
					console.log(resourceUrl)
					nuovoAppello = $location.path().split("/")
				}
			}
			console.log("ho interrogato il rootscope")
			console.log($location.path().split("/")[3])
			$scope.idClasse = nuovoAppello[1];
			$scope.idAppello = nuovoAppello[3];
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
//		$scope.appelloTemp = {
//	            'id': '0',
//	            'data': '1288323623006',
//	            'assenzePrese' : 'false',
//	            'studenti': [
//	                {
//	                    'idStudente': '00000001',
//	                    'nome': 'Mario',
//	                    'cognome': 'Rossi',
//	                    'assenza' : 'true'
//	                },
//	                {
//	                    'idStudente': '00000002',
//	                    'nome': 'Giorgio',
//	                    'cognome': 'Ughi',
//	                    'assenza' : 'false'
//	                },
//	                {
//	                    'idStudente': '00000003',
//	                    'nome': 'Aldo',
//	                    'cognome': 'Verdi',
//	                    'assenza' : 'true'
//	                }
//	            ],
//				'assenzeSemplici' : [
//					1,
//					4,
//					2
//				]
//	        }
		$scope.predicate = 'cognome'

		var appelloStudenti = new Appello();
		appelloStudenti.idClasse = $scope.idClasse
		$scope.studenti = Appello.listaStudenti(
				{idClasse:$scope.idClasse}, 
				function(response, header){
//					console.log("recupero riuscito mystudenti, leggi la risposta");
//					console.log(response);
					console.log($scope.idClasse)
				},
				function(response,header){
					console.log("non sono riuscito a caricare gli studenti")
					$scope.erroreSistema.studenti = "errore nel recupero degli studenti!!!!"
				});

		var appelloCorrente = new Appello();
		appelloCorrente.idClasse = $scope.idClasse;
		appelloCorrente.idAppello = $scope.idAppello;
		$scope.appello = Appello.myQuery2(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function (response,header)
				{
					
				},
				function(response, header)
				{
					console.log("idClasse o idAppello errati!")
					$scope.erroreSistema.appello = "errore nel recupero dell'appello!!!!"
				})

		
		$scope.assenti = Appello.recuperaAssenti(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function(response,header)
				{
					//$scope.appello.assenze = response.assenti
					//$scope.appello.assenze = response.assenti;
					//$scope.appello.assenzeSemplici = $filter('assente')($scope.appello.assenze,$scope.studenti);
				},
				function(response,header)
				{
					console.log("fallito il recupero degli assenti nell'appello")
					console.log(response)
					console.log(response.status)
					console.log(response.statusText)
					$scope.erroreSistema.assenti = "errore nel recupero assenti!!!!"
				})
		
//		Appello.myQuery2({idClasse:$scope.idClasse, idAppello:$scope.idAppello},function(response,header){
//			$scope.appello = response;
//			console.log("appello caricato")
////			$scope.appello.data = response.data;
////			$scope.appelloTest = response;
////			$scope.appello.studenti = response.studenti;
////			$scope.appello.assenze = response.assenze;
////			
////			$scope.appello.assenzePrese = response.assenzePrese;
////			var arrayStudenti = [];
////			for (var j = 0; j < $scope.appello.studenti.length;j++)
////			{
////				//arrayStudenti[j] = $scope.appello.studenti[j].idStudente
////				arrayStudenti[j] = {idStudente : $scope.appello.studenti[j].idStudente}
////			}
//			Appello.listaStudenti({idClasse:$scope.idClasse}, function(response, header){
//				//successo
//				console.log(response)
//				$scope.studenti = response
//				console.log("recupero riuscito, leggi il response");
//				console.log(response);
//				Appello.recuperaAssenti({idClasse:$scope.idClasse,idAppello:$scope.idAppello},
//						function(response,header){
//							$scope.appello.assenze = response.assenti;
//							$scope.appello.assenzeSemplici = $filter('assente')($scope.appello.assenze,$scope.studenti);
//						},function(response,header){console.log("aaa")})
//				console.log("fine sincrono studenti")
//			},
//			function(response,header){
//				//fallimento
//				console.log("recupero fallito all'url selezionato");
//				console.log(response)
//				console.log(response.status)
//				console.log(response.statusText)
//			})
//			//$scope.appello.assenze = $scope.appello.assenzeSemplici
//			//$scope.appello.assenzeSemplici = $filter('assente')($scope.appello.assenze,$scope.appello.studenti);
//
//		});

		//$scope.appello.studenti = $scope.studenti;
		$scope.segnaAssenza = function (idStudente){
			if ($scope.appello.assenzeSemplici[idStudente].idStudente == null)
			{
				$scope.appello.assenzeSemplici[idStudente].idStudente = idStudente
				for( var myId in $scope.assenti.assenti)
				{
					myId = idStudente;
				}
				$scope.assenti.assenti.push(idStudente)
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
				$scope.modalTitle = "Appello registrato"
				$scope.modalColor = "modal-header-success"
				$scope.modalBtn = "btn-success"
				$scope.bottoneDesc="aggiorna appello"
			},function(data){
				//fallimento
				$scope.erroreSistema.registrazione = "errore in fase di registrazione!!!!";
				$scope.myInput.messaggio = "è avvenuto un errore nella registrazione";
				$scope.myInput.status = data.status;
				$scope.myInput.statusText = data.statusText;
				$scope.modalTitle = "Errore"
				$scope.modalColor = "modal-header-danger"
				$scope.modalBtn = "btn-danger"
			})
		};
		
		//funzione richiamata quando viene azionato la registrazione e l'aggiornamento dell'appello
		$scope.inviaAppello = function (){
			if ($scope.appello.assenzePrese)
			{
				//aggiornamento dell'appello da inviare con ritardi, uscite anticipate, giustificazioni
				$scope.nonSupportato()
			}
			else
			{
				$scope.registraAppello();
			}
		}

		var deferred = $q.defer();
		$q.all({ studenti: $scope.studenti.$promise, appello: $scope.appello.$promise, assenti: $scope.assenti.$promise})
		.then(function(results){
			results.appello.assenzeSemplici = $filter('assente')(results.assenti.assenti,results.studenti);
			console.log()
			if (results.appello.assenzePrese)
			{
				$scope.bottoneDesc = "aggiorna appello"
			}
			else
			{
				$scope.bottoneDesc = "Registra appello";
			}
		})
		
		$scope.erroreSistema = {}
		
		$scope.conferma = function(){
			
			$('#myModal').on('shown.bs.modal', function () {
			    $('#myInput').focus()
			  })
		}
		$scope.gestisciRitardo = function (){
			$scope.nonSupportato()
		}
		$scope.gestisciUscita = function (){
			$scope.nonSupportato()
		}
		$scope.gestisciGiustificazione = function (){
			$scope.nonSupportato()
		}
		
		$scope.nonSupportato = function(){
			$scope.modalTitle = "Funzione non supportata"
			$scope.myInput.messaggio = "Attualmente questa azione non è supportata"
			$scope.modalColor = "modal-header-info"
			$scope.modalBtn = "btn-info"
			$scope.bottoneDesc="aggiorna appello"
		}
		$scope.disabilitaRitardo = true; 
		$scope.disabilitaUscita = true;
		$scope.disabilitaGiustificazione = true;
		$scope.controllaAppello = function(){
			if($scope.appello.assenzePrese)
			{
				$scope.disabilitaRitardo = true; 
				$scope.disabilitaUscita = false;
				$scope.disabilitaGiustificazione = false;
				
			}
			console.log("controllo")
		}
		setTimeout(
		$scope.controllaAppello(),500)
		//$scope.controllaAppello()
}]);

function PostsCtrlAjax($scope, $http, myUri, destinazione, $location) {
    var risorsa = {}
    $http({method: 'GET', url: myUri }).success(function(data,header) {
        destinazione.data = data;
        console.log(data)
        console.log($scope.idClasse)
        console.log($location.path())
        destinazione.url = $scope.idClasse+"/appelli/"+data.idAppello
        console.log(destinazione.url)
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

