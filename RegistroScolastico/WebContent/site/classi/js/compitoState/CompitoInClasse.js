var CompitoInClasse = function(){
	this.cState = new DaSvolgereState(this);
	this.info = {};
};
// inserisciInfo, inserisciVoti, svolgi, annulla, disannulla, chiudi, elimina

CompitoInClasse.prototype.setState = function(cState){
	//controllo del cambio di stato
	this.cState = cState;
};

CompitoInClasse.prototype.salvaCompito = function(funzioneEsterna){
	ret = this.cState.salvaCompito(funzioneEsterna);
	return ret;
};

CompitoInClasse.prototype.inserisciInfo = function(funzioneEsterna){
	ret = this.cState.inserisciInfo(funzioneEsterna);
	console.log("inserisciInfo")
	return ret;
};
CompitoInClasse.prototype.inserisciVoti = function(funzioneEsterna){
	ret = this.cState.inserisciVoti();
	console.log("inserisciVoti")
	return ret;
};
CompitoInClasse.prototype.svolgi = function(funzioneEsterna){
	ret = this.cState.svolgi(funzioneEsterna);
	console.log("svolgi")
	return ret;
};
CompitoInClasse.prototype.annullaRipristina = function(funzioneEsterna){
	ret = this.cState.annullaRipristina();
	return ret;
}
CompitoInClasse.prototype.annulla = function(funzioneEsterna){
	ret = this.cState.annulla(funzioneEsterna);
	console.log("annulla")
	return ret;
};
CompitoInClasse.prototype.ripristina = function(funzioneEsterna){
	ret = this.cState.disannulla(funzioneEsterna);
	console.log("ripristina")
	return ret;
};
CompitoInClasse.prototype.chiudi = function(funzioneEsterna){
	ret = this.cState.chiudi(funzioneEsterna);
	console.log("chiudi")
	return ret;
};
CompitoInClasse.prototype.elimina = function(funzioneEsterna){
	ret = this.cState.elimina();
	console.log("elimina")
	return ret;
};

CompitoInClasse.prototype.getAnnullatoState = function(){
	return new AnnullatoState(this);
};
CompitoInClasse.prototype.getChiusoState = function(){
	return new ChiusoState(this);
};
CompitoInClasse.prototype.getDaSvolgereState = function(){
	return new DaSvolgereState(this);
};
CompitoInClasse.prototype.getSvoltoState = function(){
	return new SvoltoState(this);
};

CompitoInClasse.prototype.getStato = function(){
	return this.cState.getStato()
}


CompitoInClasse.prototype.setInfo = function(data,inizio,fine)
{
	this.info.data = data;
	this.info.oraInizio = inizio;
	this.info.oraFine = fine;
}