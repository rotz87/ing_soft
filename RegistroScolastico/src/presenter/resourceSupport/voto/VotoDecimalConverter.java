package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public class VotoDecimalConverter extends VotoConverter{

	static private VotoDecimalConverter instance;
	private String separatore = ".";
	
	private VotoDecimalConverter() {
		initializeFormato();
	}
	
	static public VotoDecimalConverter getInstance() {
		if (VotoDecimalConverter.instance == null) {
			VotoDecimalConverter.instance = new VotoDecimalConverter();
		}
		return VotoDecimalConverter.instance;
	}

	@Override
	public Voto getVoto(VotoRS votoRS) {
		Map<Integer, String> label;
		Float valore;
		String cifra1;
		String cifra2;
		String sepECifra2;
		float iPart;
		float fPart;
		int point; 
		
		super.checkFormatoCorretto(votoRS);
		
		label = votoRS.getLabel();
		
		cifra1 = label.get(1);
		sepECifra2 = label.get(2);
		point = sepECifra2.indexOf('.');
		cifra2 = sepECifra2.substring(point+1, point+2);
		
		iPart = Float.valueOf(cifra1);		
		fPart = Float.valueOf(cifra2);
		
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
		if(valoreVoto<0f){
			cifra1 = "NC";
			cifra2 = " ";
		}
		
		label = new HashMap<Integer, String>();
		label.put(1, cifra1);
		label.put(2, this.separatore+cifra2);
		
		votoRS.setLabel(label);
		
	}
	
	private void initializeFormato(){
		super.formato = new HashMap<Integer, Collection<String>>();
		Collection<String> primaCifra = new LinkedList<String>();
		Collection<String> secondaCifra = new LinkedList<String>();
		for(int i = 0; i<=10; i++){
			primaCifra.add(String.valueOf(i));
		}
		for(int i = 0; i<=9; i++){
			secondaCifra.add(this.separatore+String.valueOf(i));
		}
//		Collection<String> separatore = new LinkedList<String>();
//		separatore.add(".");
		super.formato.put(1, primaCifra);
//		this.formato.put(2, separatore);
		super.formato.put(2, secondaCifra);
	}

}
