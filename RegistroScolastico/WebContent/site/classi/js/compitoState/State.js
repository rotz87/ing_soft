var State = function(cCompitoInClasse){
	this.cCompitoInClasse = cCompitoInClasse;
	this.stato = "NESSUNO"
	this.label = "nessuno"
};

State.prototype.salvaCompito = function(scope){
	throw new Error("This method must be overwritten!");
};
State.prototype.inserisciInfo = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.inserisciVoti = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.svolgi = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.annulla = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.disannulla = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.chiudi = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.elimina = function(){
	throw new Error("This method must be overwritten!");
};
State.prototype.getStato = function(){
	return this.stato;
}