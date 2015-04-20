var SvoltoState = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = "SVOLTO"
	this.label = "svolto"
};

SvoltoState.prototype.salvaCompito = function(obj,compito,ajax){
	this.inserisciVoti(obj,compito,ajax);
	console.log("SvoltoState - informazioni salvate")
	return true;
};

SvoltoState.prototype.inserisciInfo = function(){
	console.log("non puoi cambiare le info ad un compito svolto");
	return false;
};
SvoltoState.prototype.inserisciVoti = function(obj,compito,ajax){
	console.log("i voti sono stati inseriti");
	obj.salvaVoti(compito,ajax)
	return true;
};
SvoltoState.prototype.svolgi = function(){
	console.log("il compito è già svolto");
	var b = "false";
	return b;
};
SvoltoState.prototype.annullaRipristina = function(funzioneEsterna){
	console.log("il compito è svolto, dunque annullo");
	this.annulla(funzioneEsterna)
	return true;
};
SvoltoState.prototype.annulla = function(funzioneEsterna){
	funzioneEsterna()
	console.log("il compito è annullato");
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getAnnullatoState())
	return true;
};
SvoltoState.prototype.disannulla = function(){
	console.log("non puoi riattivare/ripristinare un compito non annullato (SVOLTO)");
	return false;
};
SvoltoState.prototype.chiudi = function(funzioneEsterna){
	funzioneEsterna();
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getChiusoState())
	return true;
};
SvoltoState.prototype.elimina = function(){
	console.log("il compito è eliminato");
	return false;
	//procedura eliminazione compito
};
SvoltoState.prototype.getStato = function(){
	return this.stato
};