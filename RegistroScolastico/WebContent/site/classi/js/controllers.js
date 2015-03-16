var registroControllers =  angular.module('registroControllers',[]);

registroControllers.controller('avviaAppello',['$scope','Appello','$location','$rootScope',function($scope,Appello,$location,$rootScope){
		$scope.idClasse = 0;
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},
					function(data,header){
				$scope.appelloUri = header("location");
			},function(response,headers){
				erroreSistema($rootScope, response.data, true)
			});
		}
	}]);

registroControllers.controller('templateTitolo', ['$scope','$location','$rootScope', function($scope, $location,$rootScope){
	$scope.titolo;
	$rootScope.$on("$routeChangeSuccess", function(event, currentRoute, previousRoute) {
	    $rootScope.title = currentRoute.title;
	    $scope.titolo = $rootScope.title;
	});
}]);
/*
 * Controller utilizzato per visualizzare l'elenco degli appelli in base alla classe selezionata
 */
registroControllers.controller('riempiElencoAppelli', ['$scope','Appello','$location','$http','$rootScope','$q','$routeParams', function($scope, Appello, $location, $http, $rootScope, $q, $routeParams) {
	  var newUri;
	  $scope.idClasse = 0;
	  var nuovoAppello = {};
	  // parsing del path dell'appello selezionato
	  nuovoAppello = $location.path().split("/");
	  
	  $scope.idClasse = $routeParams.idClasse;
	  
	  $scope.mioController = "avviaAppello";
	  $scope.predicate="data";
	  $scope.reverse = true;
	  $scope.elencoAppelli={};
	  $scope.elencoAppelli2 = Appello.myQuery2({idClasse:$scope.idClasse},
		function(response,headers){
		  //successo
	  },function(response,headers){
		  //fallimento
		  erroreSistema($rootScope, response.data, true)
	  })
	  /* 
	   * funzione avviata quando viene restituita la risposta dal server
	   * gestisce l'elenco degli appelli per poter valutare l'inserimento dell'appelloAvviabile
	   * nell'elenco degli appelli
	   */
	  $q.when($scope.elencoAppelli2.$promise).then(
		function(response){
		  //successo
		  var aggiungiAppello = false;
		  var trovato = false;
		  $scope.elencoAppelli = response.appelli;
		  for (key in response.appelli)
		  {
			  if (new Date(response.appelli[key].data).toDateString() == new Date(response.dataAppelloAvviabile).toDateString())
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
			  newAppello.data = response.dataAppelloAvviabile;
			  newAppello.idAppello = null;
			  newAppello.appelloAvviabile = response.appelloAvviabile;
			  $scope.elencoAppelli.push(newAppello)
		  }

	  },function(response,headers){
		  //fallimento
		  $scope.erroreSistema = 'è avvenuto un errore, probabilmente la classe selezionata non esiste'
			  erroreSistema($rootScope, response.data, true)
	  })
	  
	  var nuovoUri=[];
	  $scope.appelloCreato = {};
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			Appello.myPost({idClasse:$scope.idClasse},function(response,header){
				//successo
				$scope.appelloUri = header("location");
				nuovoUri = $scope.appelloUri.split("/");
				
				newUri = $scope.appelloUri;
				$scope.myUrl=newUri;
				$rootScope.mioDato = {};
				$rootScope.nuovoAppello = {};
			    $rootScope.nuovoAppello = PostsCtrlAjax($scope, $http, $scope.myUrl, $rootScope.mioDato, $location)
			},function (response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
			});
		}
		$scope.mostraAppello = function(idAppello){
			$scope.idAppello = idAppello;
			$location.path($location.path()+"appelli/"+idAppello);
		}
		$rootScope.idClasse = $scope.idClasse;
		$rootScope.idAppello = null;
		$scope.elencoClassi = Appello.elencoClassi({},
		function(response,headers){
			//successo
			for(i in response)
				{
				if(response[i].idClasse == $scope.idClasse)
					$scope.nomeClasse = response[i].nome 
				}
		},function(response,headers){
			//fallimento
			erroreSistema($rootScope, response.data, true)
		})
	}])
	.directive('elencoAppello', function() {
	  return {
		restrict : 'E',
		transclude:true,
	    templateUrl: 'partials/elencoAppelli.html'
	  };

	});

registroControllers.controller('faiAppello', ['$scope','Appello','$location','$http','$rootScope','$filter','$q','$routeParams', function($scope, Appello, $location, $http, $rootScope, $filter, $q,$routeParams){
		$scope.appelloSelezionato = {};
		var nuovoAppello;
		console.log("$routeParams");
		console.log($routeParams)
//		if ($rootScope.mioDato)
//		{
//			var resourceUrl;
//			$scope.appelloSelezionato = $rootScope.mioDato;
//			for (var key in $scope.appelloSelezionato.data.links)
//			{
//				if($scope.appelloSelezionato.data.links[key].rel == "self"){
//					resourceUrl = $scope.appelloSelezionato.data.links[key].href;
//					nuovoAppello = $location.path().split("/")
//				}
//			}
//			$scope.idClasse = nuovoAppello[1];
//			$scope.idAppello = nuovoAppello[3];
//			$scope.mioAppello = retrieveObjectFromUrl($http, resourceUrl);
//			path = resourceUrl;
//		}
//		else
//		{
//			nuovoAppello = $location.path().split("/");
//			$scope.idClasse = nuovoAppello[1];
//			$scope.idAppello = nuovoAppello[3];
//			path = "/RegistroScolastico/api/classi/"+$scope.idClasse+"/appelli/"+$scope.idAppello;
//		}
		$scope.idClasse = $routeParams.idClasse;
		$scope.idAppello = $routeParams.idAppello;
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
					erroreSistema($rootScope, response.data, true)
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
					//fallimento
					$scope.erroreSistema.appello = "non sono riuscito a caricare l'appello!!!!"
					erroreSistema($rootScope, response.data, true)
				})

		
		$scope.assenti = Appello.recuperaAssenti(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function(response,header)
				{
					//successo
				},
				function(response,header)
				{
					//fallimento
					$scope.erroreSistema.assenti = "fallito il recupero degli assenti nell'appello";
					erroreSistema($rootScope, response.data, true)
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
		$scope.modal = {};
		$scope.registraAppello = function (){
			
			var assenti = new Appello();
			assenti.assenti = $scope.assenti.assenti;
			assenti.$registraAssenti({idAppello: $scope.idAppello, idClasse: $scope.idClasse},
			function(response,header){
				//successo
				$scope.appello.assenzePrese = true;
				
				$scope.modal.messaggio = "le assenze sono state registrate";
				$scope.modal.titolo = "Appello registrato";
				$scope.modal.colore = "modal-header-success";
				$scope.modal.bottone = "btn-success";
				$scope.bottoneDesc="aggiorna appello";
				$scope.controllaAppello();
				$rootScope.modal = $scope.modal;
			},function(response,header){
				//fallimento
				erroreSistema($rootScope,response.data,true);
			})
		};
		
		//funzione richiamata quando viene azionato la registrazione e l'aggiornamento dell'appello
		$scope.inviaAppello = function (){
			if ($scope.appello.assenzePrese)
			{
				//aggiornamento dell'appello da inviare con ritardi, uscite anticipate, giustificazioni
				nonSupportato($rootScope)
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
			
		}
		$scope.gestisciRitardo = function (){
			nonSupportato($rootScope,null)
		}
		$scope.gestisciUscita = function (){
			nonSupportato($rootScope,null)
		}
		$scope.gestisciGiustificazione = function (){
			nonSupportato($rootScope,null)
		}
		
		$scope.nonSupportato = function(){
			nonSupportato($rootScope,null)
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

registroControllers.controller('popolamentoNavigazione', ['$scope','Appello','$q','$rootScope','$filter','$location', function($scope, Appello, $q, $rootScope,$filter,$location){

	$scope.$watch("idClasse",
			function(newValue,oldValue){
		//successo
		
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
						erroreSistema($rootScope, response.data, true)
					});
			}
		else if (newValue != oldValue && newValue != null)
		{
			
			$scope.elencoClassi = Appello.elencoClassi({},
					function(response,header)
					{
						//successo
					
					},
					function(response,header){
						//fallimento
						erroreSistema($rootScope, response.data, true)
					})
			$scope.elencoAppelli = Appello.myQuery2({idClasse:newValue},function(response,header){
				  //successo
			  },function(response,header){
				  //fallimento
				  erroreSistema($rootScope, response.data, true)
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
							erroreSistema($rootScope, response.data, true)
						});
			}
		})
	})
	$scope.home = function(){
		$location.path("/");
		if ($rootScope.idClasse)
			delete $rootScope.idClasse;
		if ($rootScope.idAppello)
			delete $rootScope.idAppello;
	};
}]).directive('registroScolasticoModal', function() {
	  return {
			transclude:true,
		    templateUrl: 'partials/registroScolasticoModal.html'
		  };
		});;

registroControllers.controller('riempiElencoClassi', ['$scope','Appello','$q','$location','$rootScope', function($scope,Appello,$q,$location,$rootScope) {

	$scope.elencoClassi = Appello.elencoClassi({},function(response,header)
			{
				//successo
			},
			function(response,header){
				//fallimento
				erroreSistema($rootScope, response.data, true)
			})
	$scope.scegliClasse = function(idClasse){
		$location.path(idClasse)
	}
	}])

registroControllers.controller('recuperaCompitoInClasse', ['$scope','Appello','Compito','$q','$location','$rootScope','$routeParams',
    function($scope,Appello,Compito,$q,$location,$rootScope,$routeParams) {
	
	$scope.idClasse = $rootScope.idClasse;
	var compito = {
			data : 1418770800000,
			oraInizio : 79199000,
			oraFine : 79199000,
			argomentiRS : ['asd','bsd','...']
		};
	var dati = {
			'exMsg':'Pippooo',
			'url' : 'Plutooo'
	};
	console.log($routeParams);
	$scope.compitoInClasse = new Appello();
	$scope.compitoInClasse.idClasse = $routeParams.idClasse
	$scope.compitoInClasse.idRegistroDocente = $routeParams.idRegistroDocente;
	$scope.compitoInClasse.idCompito = $routeParams.idCompito;
	$scope.compitoInClasse.$prendiCompitoInClasse({},
		function(response,headers){
		$scope.compitoInClasse.data = new Date(response.data);
		miaOraInizio = new Date (response.oraInizio)
		$scope.compitoInClasse.oraInizio = miaOraInizio
		miaOraFine = new Date (response.oraFine)
		$scope.compitoInClasse.oraFine = miaOraFine
		$scope.compitoInClasse.oraFine.setSeconds(00,00)
		//$scope.compitoInClasse.argomentiRS = JSON.stringify($scope.compitoInClasse.argomentiRS)
		console.log($scope.compitoInClasse)
		console.log("fine recupero")
	},function(response,headers){
		erroreSistema($rootScope, response.data, true)
	});
	$scope.aggiungiArgomento = function(){
		var auxArgomento = {idArgomento : null};
		console.log($scope.compitoInClasse.argomentiRS.length)
		$scope.compitoInClasse.argomentiRS.push(auxArgomento);
		$scope.argsChecked = true;
		console.log($scope.compitoInClasse.argomentiRS)
	}
	$scope.aggiornaCompito = function(){
		var CompitoInClasse = Compito.get({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito});
		var tmpCompito = {};
		for (key in $scope.compitoInClasse.toJSON())
			{
			tmpCompito[key] = $scope.compitoInClasse.toJSON()[key];
			}
		tmpCompito.data = new Date(tmpCompito.data).getTime();
		tmpCompito.oraInizio = new Date(tmpCompito.oraInizio).getTime();
		tmpCompito.oraFine = new Date(tmpCompito.oraFine).getTime();
		console.log(tmpCompito.argomentiRS)
		if (tmpCompito.argomentiRS.class = String.class)
			{
			tmpCompito.argomentiRS = angular.toJSON(temp.argomentiRS);
			}

		Compito.save({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpCompito);
	}
	var studenti = [{"id":1,"cognome":"a","nome":"b","voto":8,"assente":false},
	                {"id":2,"cognome":"c","nome":"d","voto":null,"assente":true},
	                {"id":3,"cognome":"e","nome":"f","voto":8,"assente":false},
	                {"id":4,"cognome":"g","nome":"h","voto":null,"assente":true}]
	$scope.studentiCompito = studenti;
	$scope.intervalloVoti = [0,1,2,3,4,5,6,7,8,9,10]
	$scope.inserisciVoto = function(studente,voto){
		studente.voto = voto;
	}
	$scope.salvaVoti = function(){
		var tmpStudenti = [];
		console.log("studenti prima del ciclo");
		console.log(tmpStudenti);
		for (index in $scope.studentiCompito)
		{
			if($scope.studentiCompito[index].assente == false)
			{
				stud = {};
				stud.idStudente = $scope.studentiCompito[index].idStudente
				stud.voto = $scope.studentiCompito[index].voto
				tmpStudenti.push(stud);
			}
		}
		console.log("studenti dopo il ciclo");
		console.log(tmpStudenti);
		Compito.inviaVoti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpStudenti);
	}
	$scope.absChecked=true;
	
	var studentiCompito = Compito.queryStudenti(
			{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito},
			function(response,headers){
		//successo
		$scope.studentiCompito = response;
		},
		function(response,headers){
			erroreSistema($rootScope, response.data, true);
			$scope.erroreStudenti = response.data.exMsg;
		});
	$scope.selezionaArgomenti = function(){
		//query per il recupero di tutti gli argomenti del compito
		var argomentiSvolti = Appello.argomentiSvolti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente},
			function(response,headers){
			//successo
		},function(response,headers){
			//fallimento
			erroreSistema($rootScope, response.data, true)
		});
		var tmpArgomenti = $scope.compitoInClasse.argomentiRS;
		
	};
}])

registroControllers.controller('riempiElencoCompiti', 
		['$scope','Appello','$q','$location','$rootScope','$resource','$routeParams',
		 function($scope,Appello,$q,$location,$rootScope,$resource,$routeParams) 
		 {
			$scope.elencoCompiti = Appello.prendiCompitiInClasse(
					{idClasse : 1,idRegistroDocente : 1})
			for (compito in $scope.elencoCompiti){
				
			}
			
			$scope.creaCompito = function(){
				
				Appello.creaCompitoInClasse(
						{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente, compito : $scope.compitoInClasse},
						function(response,headers)
						{
							idCompito = headers().location.split("/");
							idCompito = idCompito[idCompito.length-1];
							$location.path($location.path()+idCompito+"/");
						},
						function(response,headers){
							erroreSistema($rootScope, response.data, true);
						})
			}
	
}])
registroControllers.controller('colonnaSinistra',
		['$scope','Appello','$rootScope','$routeParams',
		 function($scope,Appello,$rootScope,$routeParams)
		 {
			
}])


function gestisciMessaggio(mioScope,tipo,attivaModal)
{
	mioScope.modal.colore = "modal-header-"+tipo;
	mioScope.modal.bottone = "btn-"+tipo;
	if(attivaModal)
	{
		$("#myModal").modal("show")
	}
}

function erroreSistema(mioScope,dati,attivaModal)
{
	mioScope.modal = {};
	mioScope.modal.titolo = "Errore nel recupero della risorsa";
	mioScope.modal.messaggio = dati.exMsg + " per la risorsa: "+dati.url;
	console.log("============= Eccezione: =========================")
	console.log(dati)
	console.log("==================================================");
	gestisciMessaggio(mioScope,"danger",attivaModal)
}

function nonSupportato(mioScope,dati,attivaModal)
{
	mioScope.modal = {};
	mioScope.modal.titolo = "Funzione non supportata";
	mioScope.modal.messaggio = "Attualmente questa azione non è supportata";
	gestisciMessaggio(mioScope,"info",attivaModal)
}
