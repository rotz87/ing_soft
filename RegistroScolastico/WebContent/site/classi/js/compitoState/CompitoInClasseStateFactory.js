var CompitoInClasseStateFactory = function(){
    this.statiAmmissibili = []
	this.cState = {}
    this.inizializzaStatiAmmissibili()
};

CompitoInClasseStateFactory.prototype.inizializzaStatiAmmissibili = function(){
	var compito = new CompitoInClasse();
	stato = compito.getAnnullatoState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getChiusoState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getDaSvolgereState();
	this.statiAmmissibili[stato.getStato()] = stato
	stato = compito.getSvoltoState();
	this.statiAmmissibili[stato.getStato()] = stato
};

CompitoInClasseStateFactory.prototype.getStatiAmmissibili = function(){
	return this.statiAmmissibili;
}

CompitoInClasseStateFactory.prototype.creaCompitoState = function (stato) {
    	var compito = new CompitoInClasse();
    	if (this.statiAmmissibili[stato])
    	{
        compito.setState(this.statiAmmissibili[stato])
    	}
        return compito;
    };