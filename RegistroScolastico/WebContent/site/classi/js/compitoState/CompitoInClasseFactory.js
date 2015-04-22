var CompitoInClasseFactory = function(){
    this.statiAmmissibili = {}
	this.cState = {}
    this.inizializzaStatiAmmissibili()
};

CompitoInClasseFactory.prototype.inizializzaStatiAmmissibili = function(){
	var compito = new CompitoInClasse();
	var stato = compito.getAnnullatoState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getChiusoState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getDaSvolgereState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getSvoltoState();
	this.statiAmmissibili[stato.getStato()] = stato
};

CompitoInClasseFactory.prototype.getStatiAmmissibili = function(){
	return this.statiAmmissibili;
};

CompitoInClasseFactory.prototype.creaCompitoState = function (stato,compito) {
	var compito = new CompitoInClasse();
	if (this.statiAmmissibili[stato])
	{
		compito.setState(this.statiAmmissibili[stato])
	}
    return compito;
};