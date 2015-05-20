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
	  // parsing del path dell'appello selezionato
	  
	  $scope.idClasse = $routeParams.idClasse;
	  $rootScope.idRegistroDocente = "0"
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
				var idAppello = $scope.appelloUri.split("/").slice(-1)[0]
				$location.path($location.path()+"appelli/"+idAppello+"/")
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
		
		$scope.idClasse = $routeParams.idClasse;
		$scope.idAppello = $routeParams.idAppello;
		$rootScope.idRegistroDocente = "0"
		/*
		 * codice di esempio di un appello:
		 * 
		 */
		$scope.predicate = 'cognome';
		
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
	// utilizzato per il reindirizzamento dopo la creazione dell'appello
	// rimpiazzato da $location.path($location.path()+"appelli/"+idAppello)
    var risorsa = {};
    $http({method: 'GET', url: myUri }).success(function(data,header) {
        destinazione.data = data;
        destinazione.url = $scope.idClasse+"/registroDiClasse/appelli/"+data.idAppello;
        risorsa = destinazione;
        $location.path("classi/"+destinazione.url);
    });
    return risorsa;
}
function retrieveObjectFromUrl($http, resourceUrl, destinazione){
	// utilizzabile nel caso in cui sia disponibile un url come link di una risorsa
	var remoteObject = {};
	$http({method:'GET', url: resourceUrl}).success(function(data){
		remoteObject = data;
		destinazione = data;
	});
	return remoteObject;
}

registroControllers.controller('popolamentoNavigazione', ['$scope', 'rsClasse', '$q', '$rootScope', '$filter', '$location','$routeParams', '$route', function($scope, rsClasse, $q, $rootScope, $filter, $location, $routeParams, $route){

	$scope.currRegistro = {};
	$scope.elencoRegistri = []
	$scope.$watch("idClasse",
			function(newValue,oldValue){
		if(newValue != null)
		{
		// se cambio classe ricarico l'elenco delle classi disponibili
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
		$scope.selezioneAttuale = {};
		$scope.selezioneAttuale.idClasse = $scope.idClasse;
	})
	
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
	var eliminaParametri = function(){
		/**
		 * consente di eliminare gli attributi del rootScope 
		 * che prendono i valori dal routeParams
		 * 
		 */
		for (var param in $routeParams)
		
		{
			delete $rootScope[param]
		}
		if ($rootScope.idRegistroDocente)
		{
			delete $rootScope.idRegistroDocente
		}
	}
	$scope.home = function(){
		$location.path("/");
		eliminaParametri();
	};
	
	$scope.vaiAImpostazioni = function(){
	
		if ($location.path != "/impostazioni")
		{
			// eliminazione parametri che vengono usati dalla
			// barra di navigazione
			eliminaParametri();
			delete $routeParams;
			$location.path("/impostazioni/")
		}
	}
	
	$scope.vaiAlRegistro = function(idRegistroDocente)
	{
		var url = ""
		eliminaParametri()
		if (idRegistroDocente == 0)
		{
			//reindirizzo verso il registro di classe:
			//Hp: gli id dei registri dei docenti partono da 1
			url = "/classi/"+$routeParams.idClasse+"/registroDiClasse/"
		}
		else
		{
			url = "/classi/"+$routeParams.idClasse+"/registriDocente/"+idRegistroDocente+"/"
		}
		$rootScope.idRegistroDocente = idRegistroDocente
		$location.path(url)
	}
	
	
	$scope.vaiAllAppello = function(idAppello){
		// funziona manipolando direttamente i parametri 
		// della rotta "$route"
		if(idAppello != $routeParams.idAppello)
		{
			$routeParams.idAppello = idAppello
			$route.updateParams($routeParams)
			$route.reload()
		}
		//$location.path("classi/"+$routeParams.idClasse+"/appelli/"+idAppello)
	}
	$scope.vaiAllaClasse = function(idClasse){
			eliminaParametri()
			$location.path("classi/"+idClasse)
	}
	$scope.$watch("idRegistroDocente",function (newValue,oldValue){
		if(newValue != null)
		{
			if (newValue != oldValue)
			{
				rsClasse.registriDocente({idClasse : $routeParams.idClasse},
					function(response,headers){
					$scope.elencoRegistri = []
					for (var i in response)
					{
						if (response[i].idRegistroDocente == newValue)
						{
							$scope.currRegistro = response[i]
						}
						if(response[i].idRegistroDocente)
						{
							$scope.elencoRegistri.push(response[i]);
						}
					}
				},function(response,headers){
					erroreSistema($rootScope, response.data, true)
				});
			}
		}
		else
		{
			//delete $scope.idRegistroDocente
		}
	})
}]).directive('registroScolasticoModal', function() {
	  return {
			transclude:true,
		    templateUrl: 'partials/directives/registroScolasticoModal.html'
		  };
		});

registroControllers.controller('riempiElencoClassi', ['$scope','rsClasse','$q','$location','$rootScope', function($scope,rsClasse,$q,$location,$rootScope) {
	
	$scope.elencoClassi = rsClasse.elencoClassi({},
			function(response,header)
			{
				//successo
			},
			function(response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
			})
	$scope.scegliClasse = function(idClasse){
		$location.path("/classi/"+idClasse)
	}
	}])

registroControllers.controller('recuperaCompitoInClasse', ['$scope','rsClasse','Compito','$q','$location','$rootScope','$routeParams','$route',
    function($scope,rsClasse,Compito,$q,$location,$rootScope,$routeParams,$route) {
	
	var mioCompito = new CompitoInClasse();
	var stateFactory = new CompitoInClasseStateFactory();
	$scope.statiAmmissibili = stateFactory.getStatiAmmissibili();
	$scope.statiPossibili = enumStatesCompito;
	$scope.erroreVoto = []
	$scope.erroriVoto = false;
	$scope.modal = {};
	$scope.eliminaCompitoModal = function(funzioneDaEseguire){
		$scope.modal.titolo = "Eliminazione del Compito in corso";
		var tipo = "warning";
		$scope.modal.messaggio = "confermi di voler eliminare il corrente compito? eliminando il compito tornerai al tuo registro docente"
		$scope.modal.colore = "modal-header-"+tipo;
		$scope.modal.bottoneAnnulla = "btn-default"
		$scope.modal.bottoneOk = "btn-"+tipo;
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
	
	$rootScope.idRegistroDocente = $routeParams.idRegistroDocente;
	
	$scope.vecchioCompitoInClasse = {};
	$scope.compitoInClasse = new Compito();
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
	
	$scope.compitoInClasse = Compito.get($routeParams,
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
					// imposto lo stato del compito in classe 
					// in base a quello ricevuto dal server
					mioCompito.setState(stateFactory.creaCompitoState(response.state))
					mioCompito.setInfo($scope.compitoInClasse.data, $scope.compitoInClasse.oraInizio,$scope.compitoInClasse.oraFine);
					$scope.currState = mioCompito.getStato()
					$scope.vecchioCompitoInClasse = angular.copy($scope.compitoInClasse)
					impostaCalendario("#bootstrapCalendario",$scope.calendario,$scope.dateCalendario,$scope.compitoInClasse.data)
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
	
	//valori dell'ordinamento predefinito delle liste
	$scope.stud_predicate = "cognome"
	$scope.args_predicate = "-data" //ordina data in ordine decrescente
	
	$scope.aggiungiArgomento = function(){
		var auxArgomento = {idArgomento : null};
		$scope.compitoInClasse.argomentiRS.push(auxArgomento);
		$scope.argsChecked = true;
	}
	
	$scope.salvaCompito = function(alProssimoStato){
		mioCompito.salvaCompito($scope,alProssimoStato)
	}
	$scope.aggiornaDatiCompito = function(alProssimoStato,ajax){
		
		var tmpCompito = {};
		for (key in $scope.compitoInClasse.toJSON())
		{
			tmpCompito[key] = $scope.compitoInClasse.toJSON()[key];
		}
		
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
					$scope.registratoCompitoModal()
				},
				function(response,headers){
					//fallimento
					erroreSistema($rootScope, response.data, true)
				});
	}
	
	
	$scope.registratoCompitoModal = function(){
		$scope.modal = {};
		$scope.modal.messaggio = "Il compito è stato registrato correttamente";
		$scope.modal.titolo = "Compito registrato";
		$scope.modal.colore = "modal-header-success";
		$scope.modal.bottone = "btn-success";
		$rootScope.modal = $scope.modal;
		$("#myModal").modal("show");
	}
	
	$scope.intervalloVoti = [0,1,2,3,4,5,6,7,8,9,10]
//	var votiAusiliari = {"1":["A","B","C","D","E"],"2":["+","++","-","--","1/2"]};
	
	$scope.votiPossibili = {};
	var formatoVoti = Compito.formatoVoti(
			{},
			function(response,headers){
				//caricamento dei voti ammessi (non delle combinazioni di essi)
				$scope.votiPossibili = response.cifre;
				
				},
			function(response,headers){
					erroreSistema($rootScope, response.data, true)
				});
	$scope.insiemeVotiStringa = {}
	$scope.inserisciVoto = function(studente,voto){
		studente.voto = voto;
	}
	$scope.inserisciVotoIndex = function(studente,votoIndex,votoValue){
		
		/** 
		 * assumo che studente.voto sia un oggetto 
		 * voto = {label:{1:"A",2:"++"};
		 */
		
		var votoVuoto = $scope.votiPossibili

		if(!studente.voto)
		{
			studente.voto = {}
			studente.voto.label = {}
		}
		
		/**
		 * assumendo che votoVuoto[1][0] == ""
		 * cioè che il server invii anche il voto vuoto e che sia al primo
		 * posto nella map
		 * */ 
		if ((votoValue == votoVuoto[1][0]) && (votoIndex == 1))
		{
			studente.voto.label[1] = "";
			studente.voto.label[2] = "";
		}
		else{
			studente.voto.label[votoIndex] = votoValue
		}
		$scope.controllaVoto(studente)
		$scope.insiemeVotiStringa[studente.idStudente] = convertiVotoStringa(studente.voto.label)
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
				function(response,headers)
				{
					//successo
					//rimozione del div dovuto al modal
					$('.modal-backdrop').remove();
					$scope.tornaAiCompiti()
					
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
		/**
		 * 
		 * codice per il controllo del voto valido
		 * 7+, 8- 8--
		 * 7 1/2
		 */
		var votiNonAmmessi = formatoVoti.votiNonAmmessi
		var votoControllando = studente.voto.label;
		var trovato = false;
		for(var index in votiNonAmmessi)
		{
			var currVotoNonAmmesso = votiNonAmmessi[index]
			var tmpTrovato = 0;
			for(var index2 in currVotoNonAmmesso)
			{
				if (currVotoNonAmmesso[index2] == votoControllando[index2])
				{
					tmpTrovato++;
				}
			}
			if(tmpTrovato == 2)
			{
				trovato = true
			}
		}
		
		$scope.erroreVoto[studente.idStudente] = trovato
		checkTuttiVoti()
	};
	var checkTuttiVoti = function(){
		var errori = false
		for(var index in $scope.erroreVoto)
		{
			if ($scope.erroreVoto[index] == true)
			{
				errori = true
			}
		}
		$scope.erroriVoto = errori;
	}
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
		
		Compito.inviaVoti({idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito}, tmpStudenti,
				function (response,headers)
				{
					//successo
					if(alProssimoStato!=null)
					{
						alProssimoStato();
					}
					$scope.registratoCompitoModal()
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
				argomentiModal($scope)
	//			$scope.modal={}
				$scope.modal.titolo = "Seleziona gli argomenti";
				$scope.modal.colore = "modal-header-info";
				$scope.modal.coloreOk = "modal-header-info";
				$scope.modal.bottoneOk = "btn-info";
				$scope.modal.coloreAnnulla = "modal-header-default";
				$scope.modal.bottoneAnnulla = "btn-default";
				$scope.modal.okButtonModal = function(){
					$scope.confermaArgomenti();
			}
			//fa una copia degli argomenti del compito in classe
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
			
			
			impostaCalendario("#bootstrapCalendario",$scope.calendario,$scope.dateCalendario,$scope.compitoInClasse.data)
			
			
		
	},function(response,headers){
		//fallimento
		//recupero della risorsa fallito
		erroreSistema($rootScope, response.data, true);
	})
	
	$scope.annullaModificheCompito = function (){
		$scope.compitoInClasse = angular.copy($scope.vecchioCompitoInClasse)
	}
	
	$scope.tornaAiCompiti = function(){
		$location.path("/classi/"+$routeParams.idClasse+"/registriDocente/"+$routeParams.idRegistroDocente+"/compiti/")
	}
	
	$scope.$watch("compitoInClasse.data",
		function(newValue,oldValue){
		if (oldValue != null && newValue == null)
		{
			$scope.compitoInClasse.data = oldValue
		}
		
		if(newValue != null)
		{
			var tmpData = newValue.getTime();
			$scope.studentiCompito = Compito.queryStudenti(
					{idClasse : $routeParams.idClasse, idRegistroDocente : $routeParams.idRegistroDocente,idCompito : $routeParams.idCompito, data : tmpData},
					function(response,headers)
					{	//successo
						if (response.length == 0)
						{
							$scope.erroreStudenti = "L'appello per la data inserita non esiste," +
													" oppure le presenze non sono state prese"
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
			$scope.dataFissata = new Date(newValue).getTime();
		}
		else{
			$scope.erroreStudenti = "Data non impostata"
		}
		
		//abilito lo svolgimento se la data non è nulla e se la data fissata è antecedente il giorno odierno
		//in realtà è un disabilitaSvolgi
		$scope.disabilitaSvolgi = !(($scope.dataFissata != null) && ($scope.dataFissata <= $scope.calendario.oggi))
		
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
			$rootScope.idRegistroDocente = $routeParams.idRegistroDocente;
			
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
			//non viene utilizzato
			$scope.parametri = $routeParams
}])
registroControllers.controller('elencoRegistri',['$scope','rsClasse','$location','$rootScope','$routeParams',function($scope,rsClasse,$location,$rootScope,$routeParams){
	
	
	$scope.idClasse = $routeParams.idClasse;
	$rootScope.idClasse = $scope.idClasse;
	
	$rootScope.idRegistroDocente = $routeParams.idRegistroDocente;
	
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
	
	$rootScope.idRegistroDocente = $routeParams.idRegistroDocente;
	
	$scope.form = {}
	$scope.form.strategia ;
	$scope.form.altriParametri;
	$scope.form.dataInizio;
	var calendario = rsClasse.calendario({},
			function(response,headers){
		var dateCalendario = {};
			dateCalendario.giorniFestivi = [];
			dateCalendario.giorniSettimanaliFestivi = []
		var dataOdierna = new Date(calendario.oggi)
		var giorniFestivi = rsClasse.dateFestive(
				{idClasse:$routeParams.idClasse},
				function(response,headers){
					var dateFestive = [];
					for( var indice in giorniFestivi.giorniFestivi)
					{
						var tmpDate = new Date(giorniFestivi.giorniFestivi[indice])
						
						dateFestive.push(new Date(tmpDate.getTime() - tmpDate.getTimezoneOffset()*60*1000))
					}
					dateCalendario.giorniFestivi = dateFestive;
					dateCalendario.giorniSettimanaliFestivi = giorniFestivi.giorniSettimanaliFestivi;
					while(!$scope.form){
						
					}
					console.log(calendario)
					impostaCalendario("#bootstrapCalendarioInizioMedia", calendario, dateCalendario,new Date(calendario.inizioAnno))
					impostaCalendario("#bootstrapCalendarioFineMedia", calendario, dateCalendario,dataOdierna)
				},
				function(response,headers){
					//fallimento
					erroreSistema($rootScope, response.data, true)
				})
	},
			function(response,headers){
		erroreSistema($rootScope, response.data, true)
	});
	//inizializzazione ad un valore predefinito delle date
	var parametriMediaVoti = angular.copy($routeParams)
	parametriMediaVoti.strategia = ""
	parametriMediaVoti.dataInizio = new Date("2014-12-10").getTime();
	parametriMediaVoti.dataFine= new Date("2014-12-17").getTime();
	$scope.$watch("form.dataInizio",function(newValue,oldValue){

		if (oldValue != null && newValue == null)
		{
			$scope.form.dataInizio = oldValue
		}
	})
	$scope.$watch("form.dataFine",function(newValue,oldValue){

		if (oldValue != null && newValue == null)
		{
			$scope.form.dataFine = oldValue
		}
	})
	$scope.calcolaMedia = function(){
		parametriMediaVoti.strategia = $scope.form.strategia.className
		parametriMediaVoti.dataInizio = $scope.form.dataInizio.getTime();
		parametriMediaVoti.dataFine = $scope.form.dataFine.getTime();
		
		var resMediavoti = mediaVoti.get(parametriMediaVoti,
				function(response,headers){
			$scope.studentiMedieRS = response;
			for (var index in $scope.studentiMedieRS){
				var studente = $scope.studentiMedieRS[index]
				if(studente.idStudente)
				{
					studente.mediaScritto.stringa = convertiVotoStringa(studente.mediaScritto.label)
				}
			}
			//console.log("caricamento OK")
		},function(response,headers){
			erroreSistema($rootScope, response.data, true)
			//console.log("caricamento FALLITO")
		})
		//console.log("caricamento")
		
	}
	$scope.vediVoti = function(idStudente){
		
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
				
				$scope.form.strategia = response[0];
				
				$scope.form.dataInizio = new Date(calendario.inizioAnno);
				$scope.form.dataFine = new Date(calendario.oggi);
				
				parametriMediaVoti.strategia = $scope.form.strategia.className
				parametriMediaVoti.dataInizio = calendario.inizioAnno;
				parametriMediaVoti.dataFine = calendario.oggi;
				
				mediaVoti.get(parametriMediaVoti,
				function(response,headers)
				{
					$scope.studentiMedieRS = response;
					for (var index in $scope.studentiMedieRS){
						var studente = $scope.studentiMedieRS[index]
						if(studente.idStudente)
						{
							studente.mediaScritto.stringa = convertiVotoStringa(studente.mediaScritto.label)
						}
					}
				},
				function(response,headers){
					erroreSistema($rootScope, response.data, true)
					})
			},
			function(response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
			}
	);
	rsClasse.registriDocente($routeParams,
			function(response,headers)
			{
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
	
	
	$rootScope.idRegistroDocente = $routeParams.idRegistroDocente
	
	$scope.vaiAlCalcoloMedie = function(){
		$location.path($location.path()+"mediaVoti/")
	};
	$scope.vaiAllaListaCompiti = function(){
		$location.path($location.path()+"compiti/")
	};
	rsClasse.registriDocente({idClasse : $routeParams.idClasse},
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
	rsClasse.elencoClassi({},
			function(response,headers)
			{
				
				for(var i in response){
					if (response[i].idClasse == $routeParams.idClasse)
					{
						$scope.classeRegistro = response[i];
						$rootScope.idClasse = $scope.classeRegistro.idClasse
					}
				}
			},
			function(response,headers){
				//fallimento
				erroreSistema($rootScope, response.data, true)
				})
}]);

registroControllers.controller('menuSinistro',['$scope','rsClasse','$location','$rootScope','$routeParams',function($scope,rsClasse,$location,$rootScope,$routeParams){
	//console.log($scope)
}]);
registroControllers.controller('impostazioniController',['$scope','votiConverters','$location','$rootScope','$routeParams',function($scope,votiConverters,$location,$rootScope,$routeParams){
	
	$scope.tipVoti = votiConverters.query(
			{},
			function(response,headers){},
			function(response,headers){erroreSistema($rootScope, response.data, true)}
			)
	$scope.currTip = votiConverters.get(
			{},
			function(response){
				$scope.currTip = []
				$scope.currTip[0] = response[0]
			},
			function(response,headers){
				erroreSistema($rootscope, response.data, true)
			}
		)
	$scope.aggiornaTipologiaVoti = function(){
		$scope.feedbackAggiornamento = {}
		$scope.feedbackAggiornamento.msg = "invio in corso"
		votiConverters.aggiorna({},$scope.currTip,
				function(){
			$scope.feedbackAggiornamento.status = true
			$scope.feedbackAggiornamento.msg = "cambio della tipologia di voto riuscito: "+ $scope.currTip;
		},
				function(){
			erroreSistema($rootScope, response.data, true)
			$scope.feedbackAggiornamento.status = false
			$scope.feedbackAggiornamento.msg = "cambio della tipologia di voto fallito: "+ $scope.currTip;
		})
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
	console.group("=================== Eccezione: ===================")
	console.log(dati)
	console.log("==================================================");
	console.groupEnd();
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
			votoStringa = votoStringa.concat(" ");
		}
		j++
		
	}
	return votoStringa;
}

var impostaCalendario = function(containerCalendario,calendario,dateCalendario,dataSelezionata){
	var dataOdierna = new Date(calendario.oggi);
	$(containerCalendario).datepicker({
	    todayBtn: false,
	    todayHighlight: false,
	    format: "yyyy-mm-dd",
	    dateFormat: "yyyy-mm-dd",
	    language:"it",
	    daysOfWeekDisabled: dateCalendario.giorniSettimanaliFestivi,
	    datesDisabled: dateCalendario.giorniFestivi,
	    startDate: new Date(calendario.inizioAnno),
	    endDate: new Date(calendario.fineAnno),
	    defaultViewDate:{
	    					year: dataOdierna.getFullYear(), 
	    					month : dataOdierna.getMonth(), 
	    					day: dataOdierna.getDate()
	    				},
	    gotoCurrent: true,
	    enableOnReadonly: false,
	    disableTouchKeyboard: true
	}).datepicker('update',dataSelezionata)
}