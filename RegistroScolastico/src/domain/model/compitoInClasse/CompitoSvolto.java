package domain.model.compitoInClasse;

import java.util.Map;
import java.util.Set;

import service.Stampa;
import domain.error.ErrorMessage;
import domain.model.LibrettoVoti;
import domain.model.LibrettoVotiLineItem;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoCommand.CompitoCommand;
import domain.model.compitoCommand.SetSvoltoCommand;

public class CompitoSvolto extends CompitoInClasseStateImp {
	static private CompitoSvolto instance;
	
//	private CompitoInClasseStateEnum stateEnum;//final = CompitoInClasseStateEnum.SVOLTO;

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
		Stampa.stampaln();
		for(Studente studente : studenti){
//			LibrettoVotiLineItem lvli = studente.getLibrettoVoti().getLibrettoLineItem(compitoInClasse);
//			Stampa.stampaln("LineItem = "+lvli);
			if(studente.getLibrettoVoti().esisteLineItem(compitoInClasse)){
				almenoUnVotoInserito = studente.getLibrettoVoti().esisteLineItem(compitoInClasse);
			}
		}Stampa.stampaln();
		if(almenoUnVotoInserito){
			compitoInClasse.set_state(CompitoChiuso.getInstance());
		}else{
			throw new IllegalStateException(ErrorMessage.COMPITO_UNCLOSABLE);
		}
	}
	
//	@Override
//	public CompitoInClasseStateEnum getStateEnum() {
//		return this.stateEnum;
//	}
//	
//	public void setStateEnum(CompitoInClasseStateEnum stateEmum){
//		this.stateEnum = stateEmum;
//	}
	

}