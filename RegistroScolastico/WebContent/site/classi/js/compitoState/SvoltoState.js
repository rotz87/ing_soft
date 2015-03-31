var SvoltoState = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stao = "SVOLTO"
};

SvoltoState.prototype.salvaCompito = function(scope){
	scope.salvaVoti();
	console.log("SvoltoState - informazioni salvate")
	return true;
};

SvoltoState.prototype.inserisciInfo = function(){
	console.log("non puoi cambiare le info ad un compito svolto");
	return false;
};
SvoltoState.prototype.inserisciVoti = function(funzioneEsterna){
	console.log("i voti sono stati inseriti");
	funzioneEsterna()
	return true;
};
SvoltoState.prototype.svolgi = function(){
	console.log("il compito è già svolto");
	var b = "false";
	return b;
};
SvoltoState.prototype.annullaRipristina = function(){
	console.log("il compito è svolto, dunque annullo");
	return true;
};
SvoltoState.prototype.annulla = function(){
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getAnnullatoState())
	console.log("il compito è annullato");
	return true;
};
SvoltoState.prototype.disannulla = function(){
	console.log("non puoi riattivare/ripristinare un compito non annullato");
	return false;
};
SvoltoState.prototype.chiudi = function(){
	console.log("il compito è chiuso");
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getChiusoState())
	return true;
};
SvoltoState.prototype.elimina = function(){
	console.log("il compito è eliminato");
	return false;
	//procedura eliminazione compito
};
SvoltoState.prototype.getStato = function(){
	return "SVOLTO"
}