package domain.model.compitoInClasse;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import org.joda.time.LocalDate;

import domain.model.Argomento;
import domain.model.Calendario;

public class CompitoDaSvolgere extends CompitoInClasseStateImp {
	static private CompitoDaSvolgere instance;

	private final CompitoInClasseStateEnum stateEnum = CompitoInClasseStateEnum.DA_SVOLGERE;
	
	private CompitoDaSvolgere() {
	}

	static public CompitoDaSvolgere getInstance() {
		if (CompitoDaSvolgere.instance == null) {
			CompitoDaSvolgere.instance = new CompitoDaSvolgere();
		}
		return CompitoDaSvolgere.instance;
	}
	
	@Override
	public void setInfo(CompitoInClasse compitoInClasse, Date data, Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		compitoInClasse.set_data(data);
		compitoInClasse.set_oraInizio(oraInizio);
		compitoInClasse.set_oraFine(oraFine);

		compitoInClasse.get_argomentiEsaminati().clear();
		compitoInClasse.get_argomentiEsaminati().addAll(argomenti);
		
	}
	
	@Override
	public void svolgi(CompitoInClasse compitoInClasse) {
		java.sql.Date data;
		LocalDate lData;
		
		data = compitoInClasse.getData();
		lData = new LocalDate(data);
		
		// TODO aggiungere altri controlli!!
		if(lData.equals(Calendario.getInstance().getDataOdierna()) || lData.isBefore(Calendario.getInstance().getDataOdierna())){
			compitoInClasse.set_state(CompitoSvolto.getInstance());
		}else{
			throw new IllegalStateException(super.WRONG_STATE);
		}
	}
	
	@Override
	public void elimina(CompitoInClasse compitoInClasse) {
		compitoInClasse.getInsegnamento().eliminaCompito(compitoInClasse);
		compitoInClasse.set_insegnamento(null);
	}
	
	@Override
	public CompitoInClasseStateEnum getStateEnum() {
		return this.stateEnum;
	}
}