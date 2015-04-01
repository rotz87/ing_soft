var AnnullatoState = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = "ANNULLATO"
	this.label = "annullato"
};
AnnullatoState.prototype.salvaCompito = function(scope){
	console.log("non è possibile salvare un compito annullato")
	return false;
};
AnnullatoState.prototype.inserisciVoti = function(){
	console.log("non puoi inserire i voti in un compito annullato");
	return false;
};
AnnullatoState.prototype.svolgi = function(){
	console.log("non puoi svolgere un compito annullato");
	return false;
};
AnnullatoState.prototype.annullaRipristina = function(){
	console.log("il compito è annullato, dunque ripristino");
	return true;
};
AnnullatoState.prototype.annulla = function(){
	console.log("il compito è già annullato");
	return false;
};
AnnullatoState.prototype.disannulla = function(funzioneEsterna){
	console.log("il compito è riattivato/ripristinato");
	this.cCompitoInClasse.setState(this.cCompitoInClasse.getSvoltoState())
	funzioneEsterna()
	return true;
};
AnnullatoState.prototype.chiudi = function(){
	console.log("non puoi chiudere un compito annullato");
	return false;
};
AnnullatoState.prototype.elimina = function(){
	console.log("non puoi eliminare un compito annullato");
	return false;
};
AnnullatoState.prototype.getStato = function(){
	return this.stato
}