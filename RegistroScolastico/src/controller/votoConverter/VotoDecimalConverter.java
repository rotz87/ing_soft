package controller.votoConverter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
	public Voto labelToVoto(Map<Integer, String> label) {
//		Map<Integer, String> label;
		Float valore;
		String cifra1;
		String cifra2;
		String sepECifra2;
		float iPart;
		float fPart;
		int point; 
		
		super.checkFormatoCorretto(label);
		
//		label = votoRS.getLabel();
		
		cifra1 = label.get(1);
		
		if(cifra1 == super.cifraNulla){
			valore = null;
		}else{
			iPart = Float.valueOf(cifra1);
			sepECifra2 = label.get(2);
			if(sepECifra2 == super.cifraNulla){
				fPart = 0;
			}else{
				point = sepECifra2.indexOf('.');
				cifra2 = sepECifra2.substring(point+1, point+2);
					
				fPart = Float.valueOf(cifra2);
			}
			valore = iPart + fPart/10;
		}
		return new Voto(valore);
	}

	@Override
	public Map<Integer, String> votoToLabel(Voto voto) {
		Map<Integer, String> label;
		String cifra1;
		String cifra2;
		
		if(voto == null || voto.getValore() == null){
			label = new HashMap<Integer, String>();
			cifra1 = super.cifraNulla;
			cifra2 = super.cifraNulla;
			label.put(1, cifra1);
			label.put(2, cifra2);
		}else{
			label = getLabel(voto.getValore());
		}

		return label;
		
	}
	
	private void initializeFormato(){
		super.formato = new FormatoVoti();
		Collection<String> primaCifra = new LinkedList<String>();
		Collection<String> secondaCifra = new LinkedList<String>();
		
		primaCifra.add(super.cifraNulla);
		for(int i = 0; i<=10; i++){
			primaCifra.add(String.valueOf(i));
		}
		secondaCifra.add(super.cifraNulla);
		for(int i = 0; i<=9; i++){
			secondaCifra.add(this.separatore+String.valueOf(i));
		}
		super.formato.cifre.put(1, primaCifra);
		super.formato.cifre.put(2, secondaCifra);

		for(float valoreVoto = 10.3f; valoreVoto < 10.91f; valoreVoto += 0.1){
			super.formato.votiNonAmmessi.add(getLabel(valoreVoto));
		}
	}
	
	private Map<Integer, String> getLabel(float valoreVoto){
		String valoreString;
		int point;
		String cifra1;
		String cifra2;
		Map<Integer, String> rit;
		
		valoreString = String.valueOf(valoreVoto);
		point = valoreString.indexOf('.');
		
		cifra1 = valoreString.substring(0, point);
		cifra2 = valoreString.substring(point+1, point+2);
		cifra2 = this.separatore + cifra2;
		
		rit = new HashMap<Integer, String>();
		rit.put(1,cifra1);
		rit.put(2,cifra2);
		
		return rit;
	}

}
