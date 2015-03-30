package domain.model.compitoInClasse;

import java.util.Map;

import domain.model.Studente;
import domain.model.Voto;

public class CompitoSvolto extends CompitoInClasseStateImp {
	static private CompitoSvolto instance;
	
	private final CompitoInClasseStateEnum stateEnum = CompitoInClasseStateEnum.SVOLTO;

	private CompitoSvolto() {
	}

	static public CompitoSvolto getInstance() {
		if (CompitoSvolto.instance == null) {
			CompitoSvolto.instance = new CompitoSvolto();
		}
		return CompitoSvolto.instance;
	}
	
	@Override
	public void inserisciVoti(CompitoInClasse compito, Map<Studente, Voto> mapVoti) {
		compito.get_insegnamento().inserisciVoti(compito, mapVoti);
	}
	
	@Override
	public void annulla(CompitoInClasse compitoInClasse) {
		 compitoInClasse.set_state(CompitoAnnullato.getInstance());
	}
	
	@Override
	public void chiudi(CompitoInClasse compitoInClasse) {
		compitoInClasse.set_state(CompitoChiuso.getInstance());
	}
	
	@Override
	public CompitoInClasseStateEnum getStateEnum() {
		return this.stateEnum;
	}
	
}