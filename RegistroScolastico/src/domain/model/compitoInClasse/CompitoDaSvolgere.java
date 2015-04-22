package domain.model.compitoInClasse;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import org.joda.time.LocalDate;

import domain.error.ErrorMessage;
import domain.model.Argomento;
import domain.model.Calendario;
import domain.model.compitoCommand.CompitoCommand;

public class CompitoDaSvolgere extends CompitoInClasseStateImp {
	static private CompitoDaSvolgere instance;

//	private CompitoInClasseStateEnum stateEnum;//final = CompitoInClasseStateEnum.DA_SVOLGERE;
	
	private CompitoDaSvolgere() {
		super.compitoCommand = null;
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
	public void setSvolto(CompitoInClasse compitoInClasse) {
		java.sql.Date data;
		LocalDate lData;
		
		data = compitoInClasse.getData();
		lData = new LocalDate(data);
		
		// FIXME aggiungere altri controlli!!
		if(lData.equals(Calendario.getInstance().getDataOdierna()) || lData.isBefore(Calendario.getInstance().getDataOdierna())){
			compitoInClasse.set_state(CompitoSvolto.getInstance());
		}else{
			throw new IllegalStateException(ErrorMessage.DATA_FUTURE);
		}
	}
	
	@Override
	public void elimina(CompitoInClasse compitoInClasse) {
		compitoInClasse.getInsegnamento().eliminaCompito(compitoInClasse);
		compitoInClasse.set_insegnamento(null);
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