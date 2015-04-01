var DaSvolgereState = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = "DA_SVOLGERE"
	this.label = "da svolgere"
};

DaSvolgereState.prototype.salvaCompito = function(obj){
	this.inserisciInfo(obj)
	console.log("DaSvolgereState - informazioni salvate")
	return true;
};

DaSvolgereState.prototype.inserisciInfo = function(obj){
	obj.aggiornaDatiCompito();
	console.log("info cambiate");
	return true;
};
DaSvolgereState.prototype.inserisciVoti = function(){
	console.log("non puoi inserire voti ad un compito non ancora svolto");
	return false;
};
DaSvolgereState.prototype.svolgi = function(funzioneEsterna){
	console.log("il compito è svolto");
	//this.cCompitoInClasse.setState(this.cCompitoInClasse.getSvoltoState())
	//valutare se è il caso di cambiare
	funzioneEsterna()
	console.log(funzioneEsterna)
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
DaSvolgereState.prototype.elimina = function(){
	console.log("compito eliminato");
	return true;
};
DaSvolgereState.prototype.getStato = function(){
	return this.stato;
}