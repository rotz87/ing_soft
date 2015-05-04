package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import sviluppo.Stampa;
import domain.error.ErrorMessage;
import domain.model.Voto;

public class VotoNumeroEIncrementiConverter implements VotoConverter {
	
	static private VotoNumeroEIncrementiConverter instance;
	private Map<Integer, Collection<String>> formato;

	private VotoNumeroEIncrementiConverter() {
		initializeFormato();
	}

	static public VotoNumeroEIncrementiConverter getInstance() {
		if (VotoNumeroEIncrementiConverter.instance == null) {
			VotoNumeroEIncrementiConverter.instance = new VotoNumeroEIncrementiConverter();
		}
		return VotoNumeroEIncrementiConverter.instance;
	}

	@Override
	public Map<Integer, Collection<String>> getFormato() {
		return formato;
	}

	@Override
	public Voto getVoto(VotoRS votoRS) {
		Voto voto;
		float valoreVoto;
		String cifra1;
		String cifra2;
		
		cifra1 = votoRS.getLabel().get(1);
		cifra2 = votoRS.getLabel().get(2);
		
		valoreVoto = Integer.valueOf(cifra1);
		
		switch (cifra2) {
		case "++":
			valoreVoto += 0.4f;
			break;
		case "+":
			valoreVoto += 0.2f;
			break;
		case " ":
			
			break;
		case "1/2":
			valoreVoto += 0.5f;
			break;
		case "-":
			valoreVoto -= 0.2f;
			break;
		case "--":
			valoreVoto -= 0.4f;
			break;

		default:
			throw new RuntimeException(ErrorMessage.FORMAT_VOTI_WRONG);
		}
		
		voto = new Voto(valoreVoto);
		return voto;
	}

	@Override
	public void setLabel(VotoRS votoRS, Voto voto) {
		float valoreVoto;
		float parteDecimale;
		String cifra1 = null;
		String cifra2 = null;
		String valoreString;
		int point;
		HashMap<Integer, String> label;
		
		valoreVoto = voto.getValore();
		int votoInt = (int)valoreVoto;
		parteDecimale = (10 * valoreVoto - 10 * votoInt)/10;
		
//		parteDecimale = valoreVoto - Float.valueOf(cifra1);
		
		if(parteDecimale <= 0.15f) cifra2 = " ";
		if(parteDecimale > 0.15f && parteDecimale <=0.3f) cifra2 = "+";
		if(parteDecimale > 0.3f && parteDecimale <=0.45f) cifra2 = "++";
		if(parteDecimale > 0.45f && parteDecimale <=0.55f) cifra2 = "1/2";
		if(parteDecimale > 0.55f){
			valoreVoto += 1;
			if(parteDecimale <=0.7f) cifra2 = "--";
			if(parteDecimale >0.7 && parteDecimale <=0.85f) cifra2 = "-";
			if(parteDecimale >0.85) cifra2 = " ";
		}
		
		valoreString = String.valueOf(valoreVoto);
		point = valoreString.indexOf('.');
		cifra1 = valoreString.substring(0, point);
		
		if(valoreVoto<0){
			Stampa.stampaln("NumeroEIncrementiConverter passo per valoreVoto < 0");
			cifra1 = "NC";
		}
		
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
		secondaCifra.add("--");
		secondaCifra.add("-");
		secondaCifra.add(" ");
		secondaCifra.add("1/2");
		secondaCifra.add("+");
		secondaCifra.add("++");
		
		this.formato.put(1, primaCifra);
		this.formato.put(2, secondaCifra);
	}
	
}