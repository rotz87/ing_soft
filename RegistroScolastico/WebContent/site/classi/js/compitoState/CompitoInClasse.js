var CompitoInClasse = function(){
	this.cState = new State(this);
	this.info = {};
	this.argomentiRS = [];
};
CompitoInClasse.prototype.setState = function(cState){
	//controllo del cambio di stato
	this.cState = cState;
};
CompitoInClasse.prototype.salvaCompito = function(funzioneEsterna,compito,ajax){
	this.cState.salvaCompito(funzioneEsterna,compito,ajax);
	
};
CompitoInClasse.prototype.inserisciInfo = function(funzioneEsterna){
	this.cState.inserisciInfo(funzioneEsterna);
};
CompitoInClasse.prototype.inserisciVoti = function(funzioneEsterna){
	this.cState.inserisciVoti();
};
CompitoInClasse.prototype.svolgi = function (funzioneEsterna){
	var ret = this.cState.svolgi(funzioneEsterna);
};
CompitoInClasse.prototype.annullaRipristina = function(funzioneEsterna){
	this.cState.annullaRipristina();
}
CompitoInClasse.prototype.annulla = function(funzioneEsterna){
	this.cState.annulla(funzioneEsterna);
};
CompitoInClasse.prototype.ripristina = function(funzioneEsterna){
	this.cState.disannulla(funzioneEsterna);
};
CompitoInClasse.prototype.chiudi = function(funzioneEsterna){
	this.cState.chiudi(funzioneEsterna);
};
CompitoInClasse.prototype.elimina = function(funzioneEsterna){
	this.cState.elimina(funzioneEsterna);
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
};
CompitoInClasse.prototype.setInfo = function(data,inizio,fine)
{
	this.info.data = data;
	this.info.oraInizio = inizio;
	this.info.oraFine = fine;
};