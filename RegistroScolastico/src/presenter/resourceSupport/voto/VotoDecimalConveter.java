package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public class VotoDecimalConveter implements VotoConverter{

	static private VotoDecimalConveter instance;
	private Map<Integer, Collection<String>> formato;
	
	private VotoDecimalConveter() {
		initializeFormato();
	}
	
	static public VotoDecimalConveter getInstance() {
		if (VotoDecimalConveter.instance == null) {
			VotoDecimalConveter.instance = new VotoDecimalConveter();
		}
		return VotoDecimalConveter.instance;
	}
	
	@Override
	public Map<Integer, Collection<String>> getFormato() {

		return formato;
	}

	@Override
	public Voto getVoto(VotoRS votoRS) {
		Map<Integer, String> label;
		Float valore;
		float iPart;
		float fPart;
		
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
		
		iPart = Float.valueOf(label.get(1));
		fPart = Float.valueOf(label.get(2));
		
		valore = iPart + fPart/10;
		
		return new Voto(valore);
	}

	@Override
	public void setLabel(VotoRS votoRS, Voto voto) {
		Map<Integer, String> label;
		String cifra1;
		String cifra2;
		String valoreString;
		float valoreVoto;
		int point;
		
		valoreVoto = voto.getValore();
		valoreString = String.valueOf(valoreVoto);
		point = valoreString.indexOf('.');
		
		cifra1 = valoreString.substring(0, point);
		cifra2 = valoreString.substring(point+1, point+2);
		
		label = new HashMap<Integer, String>();
		label.put(1, cifra1);
		label.put(2, cifra2);
		
		votoRS.setLabel(label);
		
	}
	
	private void initializeFormato(){
		this.formato = new HashMap<Integer, Collection<String>>();
		Collection<String> primaCifra = new LinkedList<String>();
		Collection<String> secondaCifra = new LinkedList<String>();
		for(int i = 0; i<=10; i++){
			primaCifra.add(String.valueOf(i));
		}
		for(int i = 0; i<=9; i++){
			secondaCifra.add(String.valueOf(i));
		}
		this.formato.put(1, primaCifra);
		this.formato.put(2, secondaCifra);
	}

}
