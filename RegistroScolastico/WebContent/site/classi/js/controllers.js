var registroControllers =  angular.module('registroControllers',[]);

registroControllers.controller('avviaAppello',['$scope','rsClasse','$location','$rootScope',function($scope,rsClasse,$location,$rootScope){
		$scope.idClasse = 0;
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			rsClasse.myPost({idClasse:$scope.idClasse},
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
registroControllers.controller('riempiElencoAppelli', ['$scope','rsClasse','$location','$http','$rootScope','$q','$routeParams', function($scope, rsClasse, $location, $http, $rootScope, $q, $routeParams) {
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
	  $scope.elencoAppelli2 = rsClasse.myQuery2({idClasse:$scope.idClasse},
		function(response,headers){
		  //successo
	  },function(response,headers){
		  //fallimento
		  erroreSistema($rootScope, response.data, true)
	  })
	  /**
	   * funzione avviata quando viene restituita la risposta dal server
	   * gestisce l'elenco degli appelli per poter valutare l'inserimento dell'appelloAvviabile
	   * nell'elenco degli appelli
	   **/
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
			
			rsClasse.myPost({idClasse:$scope.idClasse},function(response,header){
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
		$scope.elencoClassi = rsClasse.elencoClassi({},
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

registroControllers.controller('faiAppello', ['$scope','rsClasse','$location','$http','$rootScope','$filter','$q','$routeParams', function($scope, rsClasse, $location, $http, $rootScope, $filter, $q,$routeParams){
		$scope.appelloSelezionato = {};
		var nuovoAppello;
		console.log("$routeParams");
		console.log($routeParams)
		
		$scope.idClasse = $routeParams.idClasse;
		$scope.idAppello = $routeParams.idAppello;
		/*
		 * codice di esempio di un appello:
		 * 
		 */
		$scope.predicate = 'cognome';

		var appelloStudenti = new rsClasse();
		appelloStudenti.idClasse = $scope.idClasse;
		$scope.studenti = rsClasse.listaStudenti(
				{idClasse:$scope.idClasse}, 
				function(response, header){
					//successo
				},
				function(response,header){
					//fallimento
					$scope.erroreSistema.studenti = "non sono riuscito a caricare gli studenti"
					erroreSistema($rootScope, response.data, true)
				});

		var appelloCorrente = new rsClasse();
		appelloCorrente.idClasse = $scope.idClasse;
		appelloCorrente.idAppello = $scope.idAppello;
		$scope.appello = rsClasse.myQuery2(
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

		
		$scope.assenti = rsClasse.recuperaAssenti(
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
		/**
		 * Funzione richiamata ogni volta che viene cliccata una checkbox per prendere
		 * l'assenza di uno studente
		 **/
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
			
			var assenti = new rsClasse();
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

registroControllers.controller('popolamentoNavigazione', ['$scope','rsClasse','$q','$rootScope','$filter','$location', function($scope, rsClasse, $q, $rootScope,$filter,$location){

	$scope.$watch("idClasse",
			function(newValue,oldValue){
		//successo
		
		if(newValue != null)
			{
			$scope.elencoClassi = rsClasse.elencoClassi({},function(response,header)
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
			
			$scope.elencoClassi = rsClasse.elencoClassi({},
					function(response,header)
					{
						//successo
					
					},
					function(response,header){
						//fallimento
						erroreSistema($rootScope, response.data, true)
					})
			$scope.elencoAppelli = rsClasse.myQuery2({idClasse:newValue},function(response,header){
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
				$scope.elencoAppelli = rsClasse.myQuery2({idClasse:$scope.idClasse},
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
		    templateUrl: 'partials/directives/registroScolasticoModal.html'
		  };
		});

registroControllers.controller('riempiElencoClassi', ['$scope','rsClasse','$q','$location','$rootScope', function($scope,rsClasse,$q,$location,$rootScope) {
	
	$scope.elencoClassi = rsClasse.elencoClassi({},function(response,header)
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

registroControllers.controller('recuperaCompitoInClasse', ['$scope','rsClasse','Compito','$q','$location','$rootScope','$routeParams','$route',
    function($scope,rsClasse,Compito,$q,$location,$rootScope,$routeParams,$route) {
	
	$scope.idClasse = $routeParams.idClasse;
	$rootScope.idClasse = $routeParams.idClasse;
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
	$scope.compitoInClasse = new rsClasse();
	$scope.compitoInClasse.idClasse = $routeParams.idClasse
	$scope.compitoInClasse.idRegistroDocente = $routeParams.idRegistroDocente;
	$scope.compitoInClasse.idCompito = $routeParams.idCompito;
	$scope.compitoInClasse.$prendiCompitoInClasse({},
		function(response,headers){
		$scope.compitoInClasse.data = new Date(response.data).toLocaleDateString();
		miaOraInizio = new Date (response.oraInizio)
		$scope.compitoInClasse.oraInizio = miaOraInizio
		miaOraFine = new Date (response.oraFine)
		$scope.compitoInClasse.oraFine = miaOraFine
		$scope.compitoInClasse.oraFine.setSeconds(00,00)
		//$scope.compitoInClasse.argomentiRS = JSON.stringify($scope.compitoInClasse.argomentiRS)
	},function(response,headers){
		erroreSistema($rootScope, response.data, true)
	});
	$scope.stud_predicate = "cognome"
	$scope.args_predicate = "idArgomento"
	$scope.aggiungiArgomento = function(){
		var auxArgomento = {idArgomento : null};
		$scope.compitoInClasse.argomentiRS.push(auxArgomento);
		$scope.argsChecked = true;
	}
	$scope.aggiornaCompito = function(){
		var CompitoInClasse = Compito.get({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito});
		var tmpCompito = {};
		for (key in $scope.compitoInClasse.toJSON())
			{
			tmpCompito[key] = $scope.compitoInClasse.toJSON()[key];
			}
		console.log("aggiornamento compito...")
		console.log($scope.compitoInClasse.data)
		tmpCompito.data = new Date(tmpCompito.data).getTime();
		console.log(tmpCompito.data)
		tmpCompito.oraInizio = new Date(tmpCompito.oraInizio).getTime();
		tmpCompito.oraFine = new Date(tmpCompito.oraFine).getTime();
		if (tmpCompito.argomentiRS.class = String.class)
			{
			tmpCompito.argomentiRS = angular.toJSON(temp.argomentiRS);
			}
		Compito.save({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpCompito,
				function(response,headers){
			//successo
			if ( typeof $scope.studentiCompito != "undefined")
			{
				$scope.salvaVoti();
			}
		},
				function(response,headers){
					
				});
		

		$scope.modal = {};
		$scope.modal.messaggio = "Il compito è stato registrato correttamente";
		$scope.modal.titolo = "Compito registrato";
		$scope.modal.colore = "modal-header-success";
		$scope.modal.bottone = "btn-success";
		$rootScope.modal = $scope.modal;
		$("#myModal").modal("show");
	}
	$scope.intervalloVoti = [0,1,2,3,4,5,6,7,8,9,10]
	$scope.inserisciVoto = function(studente,voto){
		studente.voto = voto;
	}
	$scope.salvaVoti = function(){
		var tmpStudenti = [];
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
		console.log(tmpStudenti)
		Compito.inviaVoti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpStudenti,
				function (response,headers)
				{
			//successo
		},
				function (response,headers)
				{
			//fallimento
			erroreSistema($rootScope, response.data, true)
		});
		
	}
	$scope.absChecked=true;
	
//	var studentiCompito = Compito.queryStudenti(
//			{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito},
//			function(response,headers){
//		//successo
//			$scope.studentiCompito = response
//			if (response.length == 0)
//			{
//				$scope.erroreStudenti = "Il compito è previsto per un appello futuro"
//			}
//		},
//		function(response,headers){
//			erroreSistema($rootScope, response.data, true);
//			$scope.erroreStudenti = response.data.exMsg;
//		});
	
	$scope.selezionaArgomenti = function(){
		//query per il recupero di tutti gli argomenti del compito
		
		$scope.argomentiSvolti = rsClasse.argomentiSvolti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente},
			function(response,headers)
			{
			//successo
			//idArgomento e nome
			$scope.modal={}
			$scope.modal.titolo = "Seleziona gli argomenti";
			$scope.modal.coloreOk = "modal-header-primary";
			$scope.modal.bottoneOk = "btn-primary";
			$scope.modal.coloreAnnulla = "modal-header-default";
			$scope.modal.bottoneAnnulla = "btn-default";
			//copia gli attributi dell'oggetto senza usare lo stesso oggetto
			$scope.modal.argomenti = angular.copy($scope.compitoInClasse.argomentiRS);
			$("#myModal2").modal("show")
		},function(response,headers){
			//fallimento
			erroreSistema($rootScope, response.data, true)
		});
	};
	$scope.confermaArgomenti = function(){
		$scope.compitoInClasse.argomentiRS = $scope.modal.argomenti;
	}
	//array di date in millisecondi
	$scope.dateCalendario = [];
	rsClasse.dateFestive ({idClasse : $scope.idClasse},function(response,headers){
		for (index in response)
		{
			var data = new Date(response[index]);
			data.setTime( data.getTime() + (-1)*data.getTimezoneOffset()*60*1000 );
			//console.log(data.toLocaleDateString());
			$scope.dateCalendario[index] = data.toLocaleDateString();
		}
		/**
		 * 
		 * inizializzare il calendario dopo che le date sono state caricate!!!
		 * $scope.dateCalendario
		 * 
		 **/
		$("#bootstrapCalendario").datepicker({
		    todayBtn: true,
		    format: "dd/mm/yyyy",
//		    dateFormat: "dd/mm/yyyy",
		    language:"it",
		    //daysOfWeekDisabled: "0",
		    todayHighlight: true,
		    datesDisabled: $scope.dateCalendario
		})
		console.log($scope.dateCalendario)
		console.log(response)
	},function(){
		console.log("errore")
	})
	
	$scope.$watch("compitoInClasse.data",
		function(newValue,oldValue){
		if ( typeof newValue != "undefined")
		{
			console.log("newValue: "+ newValue)
			//converte la data dal formato dd/mm/yyyy a yyyy-mm-dd
			newValue = newValue.split('/').reverse().join("-")
			console.log("newValue: "+ newValue)
			var nuovaData = new Date(newValue).getTime();
			console.log(nuovaData)
			$scope.studentiCompito = Compito.queryStudenti(
					{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito, data : nuovaData},
					function(response,headers)
					{	//successo
						console.log(new Date(newValue).getTime());
						if (response.length == 0)
						{
							$scope.erroreStudenti = "L'appello per la data inserita non esiste"
						}
						else if (response.length > 0){
							$scope.erroreStudenti = "";
						}
					},
					function(response,headers)
					{	//fallimento
						erroreSistema($rootScope, response.data, true)
					});

		}
	})

	
}]).directive('compitoArgomentiModal', function() {
	  return {
			transclude:true,
		    templateUrl: 'partials/directives/compitoArgomentiModal.html'
		  };
		});

registroControllers.controller('riempiElencoCompiti', 
		['$scope','rsClasse','$q','$location','$rootScope','$resource','$routeParams',
		 function($scope,rsClasse,$q,$location,$rootScope,$resource,$routeParams) 
		 {
			console.log($routeParams)
			$scope.elencoCompiti = rsClasse.prendiCompitiInClasse(
					{idClasse : $routeParams.idClasse,idRegistroDocente : $routeParams.idRegistroDocente})
			
			$scope.creaCompito = function(){
				
				rsClasse.creaCompitoInClasse(
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
		['$scope','rsClasse','$rootScope','$routeParams',
		 function($scope,rsClasse,$rootScope,$routeParams)
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

function argomentiModal(mioScope){
	mioScope.modal = {};
	mioScope.modal.titolo = "Seleziona gli argomenti";
	tipo = "primary";
	mioScope.modal.colore = "modal-header-"+tipo;
	mioScope.modal.bottone = "btn-"+tipo;

		$("#myModal2").modal("show")
}
