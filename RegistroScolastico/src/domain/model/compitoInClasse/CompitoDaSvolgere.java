package domain.model.compitoInClasse;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import org.joda.time.LocalDate;

import controller.ClasseController;
import domain.error.ErrorMessage;
import domain.model.Argomento;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.RegistroAppelli;
import domain.model.compitoCommand.SetDaSvolgereCommand;

public class CompitoDaSvolgere extends CompitoInClasseStateImp {
	static private CompitoDaSvolgere instance;
	
	private CompitoDaSvolgere() {
		super.compitoCommand = new SetDaSvolgereCommand();
	}

	static public CompitoDaSvolgere getInstance() {
		if (CompitoDaSvolgere.instance == null) {
			CompitoDaSvolgere.instance = new CompitoDaSvolgere();
		}
		return CompitoDaSvolgere.instance;
	}
	
	@Override
	public void setInfo(CompitoInClasse compitoInClasse, Date data, Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		boolean isDataCorretta;
		java.sql.Date dataCorretta;
		
		isDataCorretta = isDataCorretta(compitoInClasse, data);
		dataCorretta = data;
		if(!isDataCorretta){
			dataCorretta = compitoInClasse.getData();
		}
		
		compitoInClasse.set_data(dataCorretta);
		compitoInClasse.set_oraInizio(oraInizio);
		compitoInClasse.set_oraFine(oraFine);

		compitoInClasse.get_argomentiEsaminati().clear();
		compitoInClasse.get_argomentiEsaminati().addAll(argomenti);
		
		if(!isDataCorretta){
			throw new IllegalStateException(ErrorMessage.DATA_WRONG);

		}
	}
	
	@Override
	public void setSvolto(CompitoInClasse compitoInClasse) {
		java.sql.Date data;
		LocalDate lData;
		
		data = compitoInClasse.getData();
		lData = new LocalDate(data);
		
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

	private boolean isDataCorretta(CompitoInClasse compitoInClasse, Date data){
		RegistroAppelli registroAppelli;
		Classe classe;
		Collection<LocalDate> dateFestive;
		Collection<GiornoSettimanaleFestivo> giorniSettimanaliFestivi;
		LocalDate localDate;
		boolean rit;
		
		classe = compitoInClasse.getInsegnamento().getClasse();
		registroAppelli = classe.getRegistroAppelli();
		rit = true;
		localDate = new LocalDate(data);
		
		dateFestive = registroAppelli.getDateFestiveOSenzaAppello();
		giorniSettimanaliFestivi = Calendario.getInstance().getGiorniSettimanaliFestivi();
		
		if(dateFestive.contains(localDate)|| giorniSettimanaliFestivi.contains(new GiornoSettimanaleFestivo(localDate.getDayOfWeek())) || !Calendario.getInstance().isInAnnoCorrente(data)){
			rit = false;
		}
		return rit;

	}
	
}