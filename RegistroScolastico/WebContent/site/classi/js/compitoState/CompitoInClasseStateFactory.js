function CompitoStateFactory() {
    this.creaCompitoState = function (stato) {
    	var compito = new CompitoInClasse();
    	
        if (stato === "ANNULLATO") {
        	compito.setState(compito.getAnnullatoState())
        } else if (stato === "CHIUSO") {
        	compito.setState(compito.getChiusoState())
        } else if (stato === "DA_SVOLGERE") {
        	compito.setState(compito.getDaSvolgereState())
        } else if (stato === "SVOLTO") {
        	compito.setState(compito.getSvoltoState())
        }
        return compito;
    }
}