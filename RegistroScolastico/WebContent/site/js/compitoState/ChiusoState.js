var ChiusoState = function(cCompitoInClasse){
	this.prototype = new State();
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = enumStatesCompito.chiuso
	this.label = "chiuso"
};
ChiusoState.prototype.salvaCompito = function(scope){
	console.log("non è possibile salvare un compito chiuso")
	return false;
};
ChiusoState.prototype.inserisciVoti = function(){
	console.log("non puoi inserire i voti in un compito chiuso");
	return false;
};
ChiusoState.prototype.svolgi = function(){
	console.log("non puoi svolgere un compito che è già stato chiuso");
	return false;
};
ChiusoState.prototype.annullaRipristina = function(){
	console.log("non puoi annullare un compito chiuso");
	return false;
};
ChiusoState.prototype.annulla = function(){
	console.log("non puoi annullare un compito già chiuso");
	return false;
};
ChiusoState.prototype.disannulla = function(){
	console.log("non si può riattivare un compito chiuso");
	return false;
};
ChiusoState.prototype.chiudi = function(){
	console.log("il compito è già stato chiuso");
	return false;
};
ChiusoState.prototype.elimina = function(){
	console.log("il compito è eliminato");
	return false;
};
ChiusoState.prototype.getStato = function(){
	return this.stato
}