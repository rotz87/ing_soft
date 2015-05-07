package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public abstract class VotoConverter {
	protected FormatoVoti formato;
	protected final String cifraNulla = "";
	
	
	public abstract Voto getVoto(VotoRS votoRS);
	
	public abstract void setLabel(VotoRS votoRS, Voto voto);
	
	public FormatoVoti getFormato(){
		return formato;
	}
	
	protected void checkFormatoCorretto(VotoRS votoRS){
		Map<Integer, String> label;
		boolean erroreFormato = false;
		label = votoRS.getLabel();
		for(Integer i : formato.cifre.keySet()){
			if (!formato.cifre.get(i).contains(label.get(i))){
				erroreFormato = true;
			}
		}
		if(erroreFormato){
			throw new RuntimeException(ErrorMessage.WRONG_FORMAT_VOTO);
		}
		
		if(formato.votiNonAmmessi.contains(votoRS.getLabel())){
			throw new RuntimeException(ErrorMessage.VOTO_NON_AMMESSO);
		}
	}
	
}
