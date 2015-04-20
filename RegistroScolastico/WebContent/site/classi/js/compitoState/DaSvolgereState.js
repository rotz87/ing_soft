var DaSvolgereState = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = "DA_SVOLGERE"
	this.label = "da svolgere"
};

DaSvolgereState.prototype.salvaCompito = function(obj,compito,ajax){
	//console.log("parametri in stato.salvaCompito "+ compito + "ajax" + ajax)
	this.inserisciInfo(obj,compito,ajax)
	//console.log("DaSvolgereState - informazioni salvate")
	return true;
};

DaSvolgereState.prototype.inserisciInfo = function(obj,compito,ajax){
	//console.log("parametri nello stato: " + compito + " ajax " + ajax)
	obj.aggiornaDatiCompito(compito,ajax);
	//console.log("info cambiate");
	return true;
};
DaSvolgereState.prototype.inserisciVoti = function(){
	console.log("non puoi inserire voti ad un compito non ancora svolto");
	return false;
};
DaSvolgereState.prototype.svolgi = function(funzioneEsterna){
	console.log("il compito è svolto");
	//valutare se è il caso di cambiare
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getSvoltoState())
	funzioneEsterna()
	return true;
};
DaSvolgereState.prototype.annullaRipristina = function(){
	console.log("non puoi annullare un compito ancora non svolto");
	return false;
};
DaSvolgereState.prototype.annulla = function(){
	console.log("non puoi annullare un compito ancora non svolto");
	return false;
};
DaSvolgereState.prototype.disannulla = function(){
	console.log("non puoi riaprire un compito non annullato");
	return false;
};
DaSvolgereState.prototype.chiudi = function(){
	console.log("non puoi chiudere un compito non ancora svolto");
	return false;
};
DaSvolgereState.prototype.elimina = function(funzioneEsterna){
	funzioneEsterna();
	console.log("compito eliminato");
	return true;
};
DaSvolgereState.prototype.getStato = function(){
	return this.stato;
}