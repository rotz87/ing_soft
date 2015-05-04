package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public abstract class VotoConverter {
	protected Map<Integer, Collection<String>> formato;

	
	
	public abstract Voto getVoto(VotoRS votoRS);
	
	public abstract void setLabel(VotoRS votoRS, Voto voto);
	
	public Map<Integer, Collection<String>> getFormato(){
		return formato;
	}
	
	protected void checkFormatoCorretto(VotoRS votoRS){
		Map<Integer, String> label;
		boolean erroreFormato = false;
		label = votoRS.getLabel();
		for(Integer i : formato.keySet()){
			if (!formato.get(i).contains(label.get(i))){
				erroreFormato = true;
			}
		}
		if(erroreFormato){
			throw new RuntimeException(ErrorMessage.WRONG_FORMAT_VOTO);
		}
	}
	
	
}
