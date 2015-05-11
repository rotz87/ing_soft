package controller.votoConverter;

import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public abstract class VotoConverter {
	protected FormatoVoti formato;
	protected final String cifraNulla = "";
	
	
	public abstract Voto labelToVoto(Map<Integer, String> label);
	
	public abstract Map<Integer, String> votoToLabel(Voto voto);
	
	public FormatoVoti getFormato(){
		return formato;
	}
	
	protected void checkFormatoCorretto(Map<Integer, String> label){
//		Map<Integer, String> label;
		boolean erroreFormato = false;
//		label = votoRS.getLabel();
		for(Integer i : formato.cifre.keySet()){
			if (!formato.cifre.get(i).contains(label.get(i))){
				erroreFormato = true;
			}
		}
		if(erroreFormato){
			throw new RuntimeException(ErrorMessage.WRONG_FORMAT_VOTO);
		}
		
		if(formato.votiNonAmmessi.contains(label)){
			throw new RuntimeException(ErrorMessage.VOTO_NON_AMMESSO);
		}
	}
	
}
