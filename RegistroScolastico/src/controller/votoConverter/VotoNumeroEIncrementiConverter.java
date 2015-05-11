package controller.votoConverter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public class VotoNumeroEIncrementiConverter extends VotoConverter {
	
	static private VotoNumeroEIncrementiConverter instance;

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
	public Voto labelToVoto(Map<Integer, String> label) {

		Voto voto;
		Float valoreVoto;
		String cifra1;
		String cifra2;
		
		super.checkFormatoCorretto(label);
		
		cifra1 = label.get(1);
		cifra2 = label.get(2);
		
		if(cifra1 == super.cifraNulla){
			valoreVoto = null;
		}else{
		
			valoreVoto = (float)((int)Integer.valueOf(cifra1));
		
			switch (cifra2) {
			case "++":
				valoreVoto += 0.4f;
				break;
			case "+":
				valoreVoto += 0.2f;
				break;
			case cifraNulla:
				
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
		}
		voto = new Voto(valoreVoto);
		return voto;
	}

	@Override
	public Map<Integer, String> votoToLabel( Voto voto) {
		Float valoreVoto;
		Float parteDecimale;
		String cifra1 = null;
		String cifra2 = null;
		String valoreString;
		int point;
		HashMap<Integer, String> label;
		
		
		
		if(voto == null || voto.getValore() == null){
				cifra1 = super.cifraNulla;
				cifra2 = super.cifraNulla;	
		}else{
			valoreVoto = voto.getValore();
			int votoInt = (int)valoreVoto.floatValue();
			parteDecimale = (10 * valoreVoto - 10 * votoInt)/10;
			
	//		parteDecimale = valoreVoto - Float.valueOf(cifra1);
			
			if(parteDecimale <= 0.15f) cifra2 = super.cifraNulla;
			if(parteDecimale > 0.15f && parteDecimale <=0.3f) cifra2 = "+";
			if(parteDecimale > 0.3f && parteDecimale <=0.45f) cifra2 = "++";
			if(parteDecimale > 0.45f && parteDecimale <=0.55f) cifra2 = "1/2";
			if(parteDecimale > 0.55f){
				valoreVoto += 1;
				if(parteDecimale <=0.7f) cifra2 = "--";
				if(parteDecimale >0.7 && parteDecimale <=0.85f) cifra2 = "-";
				if(parteDecimale >0.85) cifra2 = cifraNulla;
			}
			
			valoreString = String.valueOf(valoreVoto);
			point = valoreString.indexOf('.');
			cifra1 = valoreString.substring(0, point);
		}
		
		
		label = new HashMap<Integer, String>();
		label.put(1, cifra1);
		label.put(2, cifra2);
		
		return label;
	}
	
	
	private void initializeFormato(){
		super.formato = new FormatoVoti();
		Collection<String> primaCifra = new LinkedList<String>();
		Collection<String> secondaCifra = new LinkedList<String>();
		Map<Integer, String> labelNonAmmessa;
		
		primaCifra.add(super.cifraNulla);
		for(int i = 0; i<=10; i++){
			primaCifra.add(String.valueOf(i));
		}
		secondaCifra.add("--");
		secondaCifra.add("-");
		secondaCifra.add(super.cifraNulla);
		secondaCifra.add("1/2");
		secondaCifra.add("+");
		secondaCifra.add("++");
		
		super.formato.cifre.put(1, primaCifra);
		super.formato.cifre.put(2, secondaCifra);
		
		labelNonAmmessa = new HashMap<Integer, String>();
		labelNonAmmessa.put(1, "0");
		labelNonAmmessa.put(2, "--");
		super.formato.votiNonAmmessi.add(labelNonAmmessa);
		
		labelNonAmmessa = new HashMap<Integer, String>();
		labelNonAmmessa.put(1, "0");
		labelNonAmmessa.put(2, "-");
		super.formato.votiNonAmmessi.add(labelNonAmmessa);
		
		labelNonAmmessa = new HashMap<Integer, String>();
		labelNonAmmessa.put(1, "10");
		labelNonAmmessa.put(2, "++");
		super.formato.votiNonAmmessi.add(labelNonAmmessa);
		
		labelNonAmmessa = new HashMap<Integer, String>();
		labelNonAmmessa.put(1, "10");
		labelNonAmmessa.put(2, "1/2");
		super.formato.votiNonAmmessi.add(labelNonAmmessa);
	}
	
}
