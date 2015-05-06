var tmpCompito = {};

var registroControllers =  angular.module('registroControllers',[]);

registroControllers.controller('avviaAppello',['$scope','rsClasse','$location','$rootScope',function($scope,rsClasse,$location,$rootScope){
		$scope.idClasse = 0;
		$scope.creaAppello = function(miaClasse){
			if (miaClasse)
			{
				$scope.idClasse = miaClasse;
			}
			
			rsClasse.creaAppello({idClasse:$scope.idClasse},
					function(response,headers){
				//successo
				$scope.appelloUri = header("location");
			},function(response,headers){
				//fallimento
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
	  if(isNaN($routeParams.idClasse))
	  {
		  erroreSistema($rootScope, {exMsg:"la classe deve essere un numero",url:"http://..."}, true)
	  }else{
		  $scope.elencoAppelli2 = rsClasse.getAppelliClasse({idClasse:$scope.idClasse},
			function(response,headers){
			  //successo
		  },function(response,headers){
			  //fallimento
			  erroreSistema($rootScope, response.data, true)
	
				  
			 
		  })
	  }
	  /**
	   * funzione avviata quando viene restituita la risposta dal server;
	   * gestisce l'elenco degli appelli per poter valutare l'inserimento dell'appelloAvviabile
	   * nell'elenco degli appelli
	   **/
	  $q.when($scope.elencoAppelli2.$promise).then(
		function(response,headers){
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
			   * nell'elenco degli appelli che sono arrivati dal server
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
			
			rsClasse.creaAppello({idClasse:$scope.idClasse},function(response,header){
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
			for(var i in response)
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
		$scope.appello = rsClasse.getAppelliClasse(
				{idClasse:$scope.idClasse,idAppello:$scope.idAppello},
				function (response,header)
				{
					//successo
				},
				function(response, header)
				{
					//fallimento
					$scope.erroreSistema.appello = "non sono riuscito a caricare l'appello"
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
        
        destinazione.url = $scope.idClasse+"/registroDiClasse/appelli/"+data.idAppello;
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

registroControllers.controller('popolamentoNavigazione', ['$scope', 'rsClasse', '$q', '$rootScope', '$filter', '$location','$routeParams', '$route', function($scope, rsClasse, $q, $rootScope, $filter, $location, $routeParams, $route){
	$scope.$watch("idClasse",
			function(newValue,oldValue){
		//c'è un nuovo valore di idClasse
		
		if(newValue != null)
			{
			$scope.elencoClassi = rsClasse.elencoClassi({},function(response,header)
					{
						//successo
						for(var classe in response)
							{
								if (response[classe].idClasse == $scope.selezioneAttuale.idClasse)
									{
										$scope.selezioneAttuale.classe = response[classe];
										$rootScope.nomeClasse = $scope.selezioneAttuale.classe.nome
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
					function(response,headers)
					{
						//successo
					
					},
					function(response,headers){
						//fallimento
						erroreSistema($rootScope, response.data, true)
					})
			$scope.elencoAppelli = rsClasse.getAppelliClasse({idClasse:newValue},
				function(response,headers){
				  //successo
			  },function(response,headers){
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
				$scope.elencoAppelli = rsClasse.getAppelliClasse({idClasse:$scope.idClasse},
					function(response,headers)
						{
						  //successo
						for(var appello in response.appelli)
						{
							if (response.appelli[appello].idAppello == $scope.selezioneAttuale.idAppello)
								{
									$scope.selezioneAttuale.appello = response.appelli[appello];
								}
							}
						},function(response,headers){
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
	
	$scope.vaiAImpostazioni = function(){
		$location.path("/impostazioni")
	}
	$scope.vaiAllAppello = function(idAppello){
		// funziona manipolando direttamente i parametri 
		// della rotta "$route"
		$routeParams.idAppello = idAppello
		$route.updateParams($routeParams)
		$route.reload()
		
	}
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
			function(response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
			})
	$scope.scegliClasse = function(idClasse){
		$location.path(idClasse)
	}
	}])

registroControllers.controller('recuperaCompitoInClasse', ['$scope','rsClasse','Compito','$q','$location','$rootScope','$routeParams','$route',
    function($scope,rsClasse,Compito,$q,$location,$rootScope,$routeParams,$route) {
	
	var mioCompito = {};
	var stateFactory = new CompitoInClasseFactory();
	$scope.statiAmmissibili = stateFactory.getStatiAmmissibili();
	$scope.statiPossibili = enumStatesCompito;
	
	$scope.modal = {};
	$scope.eliminaCompitoModal = function(funzioneDaEseguire){
		$scope.modal.titolo = "Eliminazione del Compito in corso";
		var tipo = "warning";
		$scope.modal.messaggio = "confermi di voler eliminare il corrente compito? eliminando il compito tornerai al tuo registro docente"
		$scope.modal.colore = "modal-header-"+tipo;
		$scope.modal.bottone = "btn-"+tipo;
		$scope.modal.okButtonModal = function(){
			funzioneDaEseguire()
		}//funzioneDaEseguire();
		$("#myModal2").modal("show")
	}
	$scope.cambioStatoCompito = function (funzioneDaEseguire,daSalvare){
		
		$scope.modal.titolo = "Cambio dello stato del compito in corso";
		var tipo = "info";
		$scope.modal.messaggio = "confermi di voler cambiare lo stato del compito?"
		if(daSalvare)
			{
			$scope.modal.messaggio = $scope.modal.messaggio + " Premendo ok tutte le modifiche apportate saranno salvate"
			}
		$scope.modal.colore = "modal-header-"+tipo;
		$scope.modal.bottone = "btn-"+tipo;
		$scope.modal.bottoneOk = "btn-"+tipo;
		$scope.modal.coloreAnnulla = "modal-header-default";
		$scope.modal.bottoneAnnulla = "btn-default";
		$scope.modal.okButtonModal = function(){
			funzioneDaEseguire()
		}//funzioneDaEseguire();
		$("#myModal2").modal("show")
	}
	$scope.compitoModal = function (){
		
	}
	
	$scope.mioCompito = {};
	$scope.currState = {};
	$scope.idClasse = $routeParams.idClasse;
	$rootScope.idClasse = $routeParams.idClasse;
	
	$scope.vecchioCompitoInClasse = {};
	$scope.compitoInClasse = new rsClasse();
	$scope.compitoInClasse.idClasse = $routeParams.idClasse
	$scope.compitoInClasse.idRegistroDocente = $routeParams.idRegistroDocente;
	$scope.compitoInClasse.idCompito = $routeParams.idCompito;
	$scope.calendario = rsClasse.calendario({}
	,function(response,headers){
		//successo
	},function(response,headers){
		//fallimento
		erroreSistema($rootScope, response.data, true)
	})
	
	$scope.compitoInClasse.$prendiCompitoInClasse({},
		function(response,headers){
		//successo
		var miaData;
		// a questo punto il calendario è già caricato
		
		if(response.data == null && $scope.compitoInClasse.data == null)
		{
			//miaData = new Date($scope.calendario.oggi);
			
		}
		else{
			miaData = new Date(response.data)
		}
		
		$scope.compitoInClasse.data = miaData;
		
		var miaOraInizio
		if(response.oraInizio)
			miaOraInizio = new Date (response.oraInizio)
		$scope.compitoInClasse.oraInizio = miaOraInizio
		
		var miaOraFine
		if(response.oraFine)
			miaOraFine = new Date (response.oraFine)
		$scope.compitoInClasse.oraFine = miaOraFine
		//$scope.compitoInClasse.oraFine.setSeconds(00,00)
		//$scope.compitoInClasse.argomentiRS = JSON.stringify($scope.compitoInClasse.argomentiRS)

		
		//mioCompito = stateFactory.creaCompitoState("Svolto")
		
		//mioCompito.setInfo($scope.compitoInClasse.data, $scope.compitoInClasse.oraInizio,$scope.compitoInClasse.oraFine);
		//bisogna inserire la richiesta per lo stato del compito al server
		Compito.getState(
				{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito},
				function(response,headers)
				{
					//successo
					mioCompito = stateFactory.creaCompitoState(response.state)
					mioCompito.setInfo($scope.compitoInClasse.data, $scope.compitoInClasse.oraInizio,$scope.compitoInClasse.oraFine);
					$scope.currState = mioCompito.getStato()
					$scope.vecchioCompitoInClasse = angular.copy($scope.compitoInClasse)
				},
				function(response,headers)
				{
					//fallimento
					erroreSistema($rootScope, response.data, true)
				})

	},function(response,headers){
		//fallimento
		erroreSistema($rootScope, response.data, true)
	});
	
	$scope.stud_predicate = "cognome"
	$scope.args_predicate = "-data" //ordina data in ordine decrescente
	$scope.aggiungiArgomento = function(){
		var auxArgomento = {idArgomento : null};
		$scope.compitoInClasse.argomentiRS.push(auxArgomento);
		$scope.argsChecked = true;
	}
	
	$scope.salvaCompito = function(alProssimoStato){
		mioCompito.salvaCompito($scope,alProssimoStato)
		//console.log("$scope.salvaCompito: "+ compito + " ajax: "+ ajax)
	}
	$scope.aggiornaDatiCompito = function(alProssimoStato,ajax){
		//var CompitoInClasse = Compito.get({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito});
		var tmpCompito = {};
		for (key in $scope.compitoInClasse.toJSON())
		{
			tmpCompito[key] = $scope.compitoInClasse.toJSON()[key];
		}
		
//		if(tmpCompito.data.split("/").reverse().join("-"))
//		{
//			tmpCompito.data = new Date(tmpCompito.data.split("/").reverse().join("-")).getTime();
//		}
		if(tmpCompito.data != null){
			tmpCompito.data = tmpCompito.data.getTime()
		}
		else{
			tmpCompito.data = null
		}
		
		if (tmpCompito.oraInizio)
		{
			tmpCompito.oraInizio = new Date(tmpCompito.oraInizio).getTime();
		}
		else {
			tmpCompito.oraInizio = null
		}
		if (tmpCompito.oraFine)
		{
			tmpCompito.oraFine = new Date(tmpCompito.oraFine).getTime();
		}
		else{
			tmpCompito.oraFine = null
		}
		if (tmpCompito.argomentiRS.class = String.class)
		{
			tmpCompito.argomentiRS = angular.toJSON(temp.argomentiRS);
		}
		Compito.save({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpCompito,
				function(response,headers)
				{
					//successo
					if(alProssimoStato != null)
					{
						/**
						 * richiama la funzione che invocherà il cambio di stato al compito,
						 * se richiesto
						 **/
						alProssimoStato()
					}
					$scope.vecchioCompitoInClasse = angular.copy($scope.compitoInClasse)
					$scope.modal = {};
					$scope.modal.messaggio = "Il compito è stato registrato correttamente";
					$scope.modal.titolo = "Compito registrato";
					$scope.modal.colore = "modal-header-success";
					$scope.modal.bottone = "btn-success";
					$rootScope.modal = $scope.modal;
					$("#myModal").modal("show");
				},
				function(response,headers){
					//fallimento
					erroreSistema($rootScope, response.data, true)
				});
	}
	
	$scope.intervalloVoti = [0,1,2,3,4,5,6,7,8,9,10]
//	var votiAusiliari = {"1":["A","B","C","D","E"],"2":["+","++","-","--","1/2"]};
	
	$scope.votiPossibili = {};
	$scope.votiPossibili = Compito.formatoVoti();
//	for (var key in votiAusiliari)
//	{
//		$scope.votiPossibili[key] = votiAusiliari[key];
//		$scope.votiPossibili[key] = votiAusiliari[key];
//	}
	$scope.insiemeVotiStringa = {}
	$scope.inserisciVoto = function(studente,voto){
		studente.voto = voto;
	}
	$scope.inserisciVotoIndex = function(studente,votoIndex,votoValue){
		
		/** assumo che studente.voto sia un oggetto 
		 * voto = {label:{1:"A",2:"++"};
		 */
		var votoVuoto = $scope.votiPossibili

		if(!studente.voto)
		{
			studente.voto = {}
			studente.voto.label = {}
		}
		
		// assumendo che votoVuoto[1][0] == ""
		if ((votoValue == votoVuoto[1][0]) && (votoIndex == 1))
		{
			console.log("voto nullo")
			studente.voto.label[1] = "";
			studente.voto.label[2] = "";
		}
		else{
			studente.voto.label[votoIndex] = votoValue
		}
		
		if(votoValue)
		{
			$scope.insiemeVotiStringa[studente.idStudente] = convertiVotoStringa(studente.voto.label)
		}
	}

	$scope.ripristinaCompito = function(){
		mioCompito.ripristina($scope.ripristinaCompitoAjax)
	}
	$scope.ripristinaCompitoAjax = function(){
		impostaStato($scope.statiAmmissibili[$scope.statiPossibili.svolto].stato)
	}
	
	$scope.salvaAnnullaCompito = function(){
		$scope.salvaCompito($scope.annullaCompito)
	}
	$scope.annullaCompito = function(){
		mioCompito.annulla($scope.annullaCompitoAjax)
	}
	$scope.annullaCompitoAjax = function(){
		impostaStato($scope.statiAmmissibili[$scope.statiPossibili.annullato].stato)
	}
	
	$scope.salvaChiudiCompito = function(){
		$scope.salvaCompito($scope.chiudiCompito)
	}
	
	$scope.chiudiCompito = function(){
		mioCompito.chiudi($scope.chiudiCompitoAjax);
	}
	$scope.chiudiCompitoAjax = function(){
		impostaStato($scope.statiAmmissibili[$scope.statiPossibili.chiuso].stato)
	}
	
	$scope.salvaSvolgiCompito = function(){
		$scope.salvaCompito($scope.svolgiCompito);
	}
	$scope.svolgiCompito = function svolgiCompito(){
		mioCompito.svolgi($scope.svolgiCompitoAjax)
	}
	$scope.svolgiCompitoAjax = function(){
		impostaStato($scope.statiAmmissibili[$scope.statiPossibili.svolto].stato)
	}
	
	$scope.eliminaCompito = function(){
		var success = mioCompito.elimina($scope.eliminaCompitoAjax)
	}
	$scope.eliminaCompitoAjax = function(){
		Compito.eliminaCompito($routeParams,
				function(response,headers){
					//successo
					$scope.tornaAlRegistro()
				},function(response,headers){
					//fallimento
					erroreSistema($rootScope, response.data, true)
				})
	}
	
	var impostaStato = function(prossimoStato){
		var reqPayload = {state : prossimoStato}
		var parametri = {idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}
		Compito.setState(parametri,
				reqPayload,
				function(response,headers)
				{
					//successo
					$scope.currState = prossimoStato
					mioCompito.setState(stateFactory.getStatiAmmissibili()[prossimoStato])
				},
				function(response,headers)
				{
					//fallimento
					erroreSistema($rootScope, response.data, true)
				})
	}
	
	$scope.annullaRipristinaCompito = function(){
		$scope.salvaCompito();
		var success = mioCompito.annullaRipristina();
	}
	$scope.controllaVoto = function(studente){
		console.log(studente.voto);
		/**
		 * 
		 * codice per il controllo del voto valido
		 * 7+, 8- 8--
		 * 7 1/2
		 */
		var myregp = new RegExp("^[0-9]{1,2}[,.]?[0-9]{0,2}?$")
		var myregp2 = new RegExp("^[1]{1}[0-1]{1}$")
		var myregp3 = new RegExp("^[0-9]{1}$")
		var myregp4 = new RegExp("^[0-9]{1}")
		
		//console.log(myregp.exec(studente.voto))
		console.log("è 10 o 11: " + myregp2.test(studente.voto))
		console.log("è 0-9: " + myregp3.test(studente.voto))
		console.log("è 7.[,]5: " + myregp3.test(studente.voto))
	};
	$scope.salvaVoti = function(alProssimoStato,ajax)
	{
		var tmpStudenti = [];
		for (index in $scope.studentiCompito)
		{
			if($scope.studentiCompito[index].assente == false)
			{
				var stud = {};
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
					if(alProssimoStato!=null)
					{
						alProssimoStato();
					}
					$scope.modal = {};
					$scope.modal.messaggio = "Il compito è stato registrato correttamente";
					$scope.modal.titolo = "Compito registrato";
					$scope.modal.colore = "modal-header-success";
					$scope.modal.bottone = "btn-success";
					$rootScope.modal = $scope.modal;
					$("#myModal").modal("show");
				},
				function (response,headers)
				{
					//fallimento
					erroreSistema($rootScope, response.data, true)
				});
	}
	$scope.absChecked = true;
	$scope.compitiUguali = false;
	$scope.$watchGroup(["compitoInClasse","vecchioCompitoInClasse"],function(newValues, oldValues, scope){
		$scope.compitiUguali = angular.equals(newValues[0], newValues[1]);
	},true)
	$scope.$watch("compitoInClasse",function(newValue, oldValue, scope){
		$scope.compitiUguali = angular.equals(newValue, $scope.vecchioCompitoInClasse);
	},true)
	
	$scope.selezionaArgomenti = function(){
		//query per il recupero di tutti gli argomenti del compito
		$scope.argomentiSvolti = rsClasse.argomentiSvolti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente},
			function(response,headers)
			{
			//successo
			//idArgomento e nome
			$scope.modal={}
			$scope.modal.titolo = "Seleziona gli argomenti";
			$scope.modal.colore = "modal-header-info";
			$scope.modal.coloreOk = "modal-header-primary";
			$scope.modal.bottoneOk = "btn-primary";
			$scope.modal.coloreAnnulla = "modal-header-default";
			$scope.modal.bottoneAnnulla = "btn-default";
			$scope.modal.okButtonModal = function(){
				$scope.confermaArgomenti();
			}
			//fa una compia degli argomenti del compito in classe
			//per permettere l'aggiornamento in un secondo tempo
			$scope.modal.argomenti = angular.copy($scope.compitoInClasse.argomentiRS);
			$("#myModal2").modal("show")
		},function(response,headers){
			//fallimento
			erroreSistema($rootScope, response.data, true)
		});
	};
	$scope.confermaArgomenti = function(){
		//salva gli argomenti nel compito in classe mantenendo il disaccoppiamento con il modal
		$scope.compitoInClasse.argomentiRS = angular.copy($scope.modal.argomenti);
	}
	//array di date in millisecondi
	$scope.dateCalendario = {};
	$scope.dateCalendario.giorniFestivi = [];
	$scope.dateCalendario.giorniSettimanaliFestivi = []
	rsClasse.dateFestive ({idClasse : $scope.idClasse},
		function(response,headers){
			//successo
			for (var index in response.giorniFestivi)
			{
				var data = new Date(response.giorniFestivi[index]);
				/**
				 * sfasamento dell'ora poichè il calendario lavora in UTC, 
				 * cioè toglie un'ora rispetto all'ora italiana
				 */
				data.setTime( data.getTime() + (-1)*data.getTimezoneOffset()*60*1000 );
				$scope.dateCalendario.giorniFestivi[index] = data;
			}
			$scope.dateCalendario.giorniSettimanaliFestivi = response.giorniSettimanaliFestivi;
			/**
			 * 
			 * inizializzare il calendario dopo che le date sono state caricate!!!
			 * $scope.dateCalendario
			 * 
			 **/
			
			var inizioAnno = new Date($scope.calendario.inizioAnno);
			var fineAnno = new Date($scope.calendario.fineAnno);
			var dataOdierna = new Date($scope.calendario.oggi);
			$("#bootstrapCalendario").datepicker({
			    todayBtn: false,
			    todayHighlight: false,
			    format: "yyyy-mm-dd",
			    dateFormat: "yyyy-mm-dd",
			    language:"it",
			    daysOfWeekDisabled: $scope.dateCalendario.giorniSettimanaliFestivi,
			    datesDisabled: $scope.dateCalendario.giorniFestivi,
			    startDate: inizioAnno,
			    endDate: fineAnno,
			    defaultViewDate:{
			    					year: dataOdierna.getFullYear(), 
			    					month : dataOdierna.getMonth(), 
			    					day: dataOdierna.getDate()
			    				},
			    gotoCurrent: true,
			    enableOnReadonly: false,
			    disableTouchKeyboard: true
			})
		
	},function(response,headers){
		//fallimento
		//recupero della risorsa fallito
		erroreSistema($rootScope, response.data, true)
	})
	
	$scope.annullaModificheCompito = function (){
		$scope.compitoInClasse = angular.copy($scope.vecchioCompitoInClasse)
	}
	
	$scope.tornaAlRegistro = function(){
		$location.path("/"+$routeParams.idClasse+"/registriDocente/"+$routeParams.idRegistroDocente+"/compiti/")
	}
	
	$scope.$watch("compitoInClasse.data",
		function(newValue,oldValue){
		if(newValue != null)
		{
			$routeParams.data = newValue.getTime();
			$scope.studentiCompito = Compito.queryStudenti(
					{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito, data : $routeParams.data},
					function(response,headers)
					{	//successo
						if (response.length == 0)
						{
							$scope.erroreStudenti = "L'appello per la data inserita non esiste," +
													" oppure le presenze non sono atate prese"
						}
						else if (response.length > 0){
							$scope.erroreStudenti = "";
							
							for(var index in response)
							{
								var studente = response[index];
								if(response[index].voto){
									$scope.insiemeVotiStringa[studente.idStudente] = convertiVotoStringa(studente.voto.label)
								}
								//$scope.insiemeVotiStringa[studente.idStudente] = aggiornaArrayVoti(voto.label)
							}
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
		['$scope','rsClasse','Compito','$q','$location','$rootScope','$resource','$routeParams',
		 function($scope,rsClasse,Compito,$q,$location,$rootScope,$resource,$routeParams) 
		 {	
			$scope.currRegistro = {};
			$scope.registriDisponibili = rsClasse.registriDocente({idClasse : $routeParams.idClasse},
				function(response,headers)
				{
					//successo
					for(var key in $scope.registriDisponibili)
					{
						if($scope.registriDisponibili[key].idRegistroDocente == $routeParams.idRegistroDocente)
						{
							$scope.currRegistro.materia = $scope.registriDisponibili[key].materia
						}
						
					}
				},
				function(response,headers)
				{
					//fallimento
					erroreSistema($rootScope, response.data, true)
				})
			$scope.currRegistro.idRegistroDocente = $routeParams.idRegistroDocente;
			$scope.idClasse = $routeParams.idClasse;

			$rootScope.idClasse = $scope.idClasse;
			
			$scope.elencoCompiti = Compito.query(
					{idClasse : $routeParams.idClasse,idRegistroDocente : $routeParams.idRegistroDocente},
					function(response,headers){
						//successo
					},function(response,headers){
						//fallimento
						erroreSistema($rootScope, response.data, true)
					})
			
			$scope.creaCompito = function(){
				Compito.creaCompitoInClasse(
					{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente, compito : $scope.compitoInClasse},
					function(response,headers)
					{
						//successo
						var idCompito = headers().location.split("/");
						idCompito = idCompito[idCompito.length-1];
						$location.path($location.path()+idCompito+"/");
					},
					function(response,headers){
						//fallimento
						erroreSistema($rootScope, response.data, true);
					})
			}
			$scope.vaiAlCompito = function(idCompito){
				$location.path($location.path()+idCompito+"/")
			}
}])

registroControllers.controller('colonnaSinistra',
		['$scope','rsClasse','$rootScope','$routeParams',
		 function($scope,rsClasse,$rootScope,$routeParams)
		 {
			
}])
registroControllers.controller('elencoRegistri',['$scope','rsClasse','$location','$rootScope','$routeParams',function($scope,rsClasse,$location,$rootScope,$routeParams){
	
	
	$scope.idClasse = $routeParams.idClasse;
	$rootScope.idClasse = $scope.idClasse;
	$scope.registriDisponibili = [1,2,3,4];
	$scope.vaiRegistroDiClasse = function(){
		$location.path($location.path()+"registroDiClasse/");
	}
	$scope.vaiRegistroDocente = function(idRegistro){
		//$location.path($location.path()+"registroDocente/"+idRegistro);
	}
	
	$scope.registriDisponibili = rsClasse.registriDocente({idClasse : $scope.idClasse},
		function(response,headers)
			{
				//successo
				//attributi:
				//idRegistroDocente, materia
			},
			function(response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
	})
	$scope.scegliRegistro = function (idRegistro){
		if (idRegistro == null)
		{
			$location.path($location.path()+"registroDiClasse/");
		}
		else
		{
			
			$rootScope.registro = {}
			$rootScope.registro.idRegistroDocente = idRegistro;
			
			for(key in $scope.registriDisponibili)
			{
				if($scope.registriDisponibili[key].idRegistroDocente == idRegistro)
				{
					
					$rootScope.registro.materia = $scope.registriDisponibili[key].materia
				}
			}
			$location.path($location.path()+"registriDocente/"+idRegistro+"/");
		}
	}
}]);


registroControllers.controller('mediaVotiController',['$scope','rsClasse','mediaVoti','$location','$rootScope','$routeParams',function($scope,rsClasse,mediaVoti,$location,$rootScope,$routeParams){
	//console.log($scope)
	$rootScope.idClasse = $routeParams.idClasse;
	
	$scope.form = {}
	$scope.form.strategia ;
	$scope.form.altriParametri;
	$scope.form.dataInizio;
	var calendario = rsClasse.calendario({},
			function(response,headers){
		
		var dataOdierna = new Date(calendario.oggi)
		var giorniFestivi = rsClasse.dateFestive(
				{idClasse:$routeParams.idClasse},
				function(){
					var dateFestive = [];
					for( var indice in giorniFestivi.giorniFestivi)
					{
						var tmpDate = new Date(giorniFestivi.giorniFestivi[indice])
						
						dateFestive.push(new Date(tmpDate.getTime() - tmpDate.getTimezoneOffset()*60*1000))
					}
					$(".bootstrapCalendario").datepicker({
					    todayBtn: true,
					    todayHighlight: false,
					    format: "yyyy-mm-dd",
						dateFormat: "yyyy-mm-dd",
					    language:"it",
					    daysOfWeekDisabled: giorniFestivi.giorniSettimanaliFestivi,
					    datesDisabled: dateFestive,
					    startDate: new Date(calendario.inizioAnno),
					    endDate: new Date(calendario.fineAnno),
					    defaultViewDate: {year: dataOdierna.getFullYear() , month:dataOdierna.getMonth(),day:dataOdierna.getDate()},
					    gotoCurrent: true,
					    enableOnReadonly: false,
					    disableTouchKeyboard: true
					})
				},
				function(){
					
				})

	},
			function(response,headers){
		erroreSistema($rootScope, response.data, true)
	});
	
	var parametriMediaVoti = angular.copy($routeParams)
	parametriMediaVoti.strategia = ""
	parametriMediaVoti.dataInizio = new Date("2014-12-10").getTime();
	parametriMediaVoti.dataFine= new Date("2014-12-17").getTime();
	
	$scope.calcolaMedia = function(){
		parametriMediaVoti.strategia = $scope.form.strategia.className
		parametriMediaVoti.dataInizio = $scope.form.dataInizio.getTime();
		parametriMediaVoti.dataFine = $scope.form.dataFine.getTime();
		
		mediaVoti.get(parametriMediaVoti,
				function(response,headers){
			$scope.studentiMedieRS = response;
			for (var index in $scope.studentiMedieRS){
				var studente = $scope.studentiMedieRS[index]
				if(studente.idStudente)
				{
					studente.mediaScritto.stringa = convertiVotoStringa(studente.mediaScritto.label)
				}
			}
		},function(response,headers){
			erroreSistema($rootScope, response.data, true)
		})
	}
	$scope.vediVoti = function(idStudente){
		console.log("vediVoti")
		nonSupportato($rootScope,null,true)
	};
	
	$scope.impostaStrategia = function (stringaStrategia){
		$scope.form.strategia = stringaStrategia;
	};
	$scope.impostaAltriParametri = function(altriParams)
	{
		$scope.form.altriParametri = altriParams;
	};
	$scope.tipiMedia = mediaVoti.elencoStrategie(
			$routeParams,
			function(response,headers){
				console.log(response)
				$scope.form.strategia = response[0];
				parametriMediaVoti.strategia = $scope.form.strategia.className
				$scope.form.dataInizio = new Date(calendario.inizioAnno);
				$scope.form.dataFine = new Date(calendario.oggi);
				parametriMediaVoti.dataInizio = calendario.inizioAnno;
				parametriMediaVoti.dataFine = calendario.oggi;
				mediaVoti.get(parametriMediaVoti,
				function(response,headers){
			$scope.studentiMedieRS = response;
			for (var index in $scope.studentiMedieRS){
				var studente = $scope.studentiMedieRS[index]
				if(studente.idStudente)
				{
					studente.mediaScritto.stringa = convertiVotoStringa(studente.mediaScritto.label)
				}}
		},function(response,headers){
			
		})
			},
			function(response,headers){
				console.log("errore")
				erroreSistema($rootScope, response.data, true)
			}
	);
	rsClasse.registriDocente($routeParams,
			function(response,headers){
		for (var i in response){
			if (response[i].idRegistroDocente == $routeParams.idRegistroDocente)
				{
					$scope.registroSelezionato = response[i];
				}
		} 
			},function(response,headers){
				erroreSistema($rootScope, response.data, true)
			})
}]);

registroControllers.controller('funzioniRegistroDocente',['$scope','rsClasse','$location','$rootScope','$routeParams',function($scope,rsClasse,$location,$rootScope,$routeParams){
	console.log($scope)
	$scope.vaiAlCalcoloMedie = function(){
		$location.path($location.path()+"mediaVoti/")
	};
	$scope.vaiAllaListaCompiti = function(){
		$location.path($location.path()+"compiti/")
	};
	rsClasse.registriDocente($routeParams,
			function(response,headers){
		for (var i in response){
			if (response[i].idRegistroDocente == $routeParams.idRegistroDocente)
				{
					$scope.registroSelezionato = response[i];
				}
		} 
			},function(response,headers){
				erroreSistema($rootScope, response.data, true)
			})
	rsClasse.elencoClassi($routeParams,
			function(response)
			{
				console.log(response)
				for(var i in response){
					if (response[i].idClasse == $routeParams.idClasse)
					{
						$scope.classeRegistro = response[i];
						$rootScope.idClasse = $scope.classeRegistro.idClasse
					}
				}
			},
			function(response,headers){
				erroreSistema($rootScope, response.data, true)
				})
}]);

registroControllers.controller('menuSinistro',['$scope','rsClasse','$location','$rootScope','$routeParams',function($scope,rsClasse,$location,$rootScope,$routeParams){
	//console.log($scope)
}]);
registroControllers.controller('impostazioniController',['$scope','votiConverters','$location','$rootScope','$routeParams',function($scope,votiConverters,$location,$rootScope,$routeParams){
	console.log("eccomi - impostazioniController")
	$scope.tipVoti = votiConverters.query()
	$scope.currTip = votiConverters.get({},
		function(response){
		$scope.currTip = []
		$scope.currTip[0] = response[0]
		},
		function(response,headers){
			
		}
	)
	$scope.aggiornaTipologiaVoti = function(){
		console.log("invio di 'currTip' in corso "+ $scope.currTip)
		votiConverters.aggiorna({},$scope.currTip)
	}
	$scope.selezionaTipologia = function(tipVoto){
		$scope.currTip[0] = tipVoto
	}
}]);


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
	mioScope.modal.messaggio = dati.exMsg 
	mioScope.modal.titolo = "Errore nell'operazione richiesta"
	if(dati.url)
	{
		mioScope.modal.titolo = "Errore nel recupero della risorsa";
		mioScope.modal.messaggio = mioScope.modal.messaggio
		mioScope.modal.urlRisorsa = dati.url;
	}
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
	var tipo = "primary";
	mioScope.modal.colore = "modal-header-"+tipo;
	mioScope.modal.bottone = "btn-"+tipo;
	mioScope.modal.okButtonModal = function(){mioScope.confermaArgomenti()};
	$("#myModal2").modal("show")
}

function convertiVotoStringa(label){
	/**
	 * la funzione viene richiamata ogni qual volta si deve visualizzare
	 * un voto in formato stringa
	 */
	var votoStringa = "";
	var j = 1;
	for (var i in label)
	{
		if (label[1] != "" || label[i] != "" && label[j+1] != "")
		{
			
		
		votoStringa = votoStringa.concat(label[i]);
		/**
		 * inserisce uno spazio tra la prima e la seconda "cifra"
		 * dei voti:
		 * nel caso in cui il voto è espresso in decimali (0.00) allora 
		 * lo spazio non viene inserito, lo stesso per le cifre successive
		 */
		var myregp = new RegExp("^[.]{1}")
		
		if(label[j+1] && (!myregp.test(label[j+1])))
		{
			console.log(j+1)
			votoStringa = votoStringa.concat(" ");
		}
		}
		j++
		
	}
	return votoStringa;
}