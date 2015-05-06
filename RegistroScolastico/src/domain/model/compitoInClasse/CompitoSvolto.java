package domain.model.compitoInClasse;

import java.util.Map;
import java.util.Set;

import sviluppo.Stampa;
import domain.error.ErrorMessage;
import domain.model.LibrettoVoti;
import domain.model.LibrettoVotiLineItem;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoCommand.CompitoCommand;
import domain.model.compitoCommand.SetSvoltoCommand;

public class CompitoSvolto extends CompitoInClasseStateImp {
	static private CompitoSvolto instance;

	private CompitoSvolto() {
		super.compitoCommand = new SetSvoltoCommand();
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
		boolean almenoUnVotoInserito = false;
		Set<Studente> studenti = compitoInClasse.getInsegnamento().getClasse().getStudenti();
		Voto voto;
		for(Studente studente : studenti){
			if(studente.getLibrettoVoti().esisteLineItem(compitoInClasse)){
				voto = studente.getLibrettoVoti().getLibrettoLineItem(compitoInClasse).getVoto();
				if(!(voto == null || voto.getValore() == null)){
					almenoUnVotoInserito = studente.getLibrettoVoti().esisteLineItem(compitoInClasse);
				}
			}
		}
		if(almenoUnVotoInserito){
			compitoInClasse.set_state(CompitoChiuso.getInstance());
		}else{
			throw new IllegalStateException(ErrorMessage.COMPITO_UNCLOSABLE);
		}
	}

}