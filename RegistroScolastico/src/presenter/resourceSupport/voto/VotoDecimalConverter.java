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
	public void setLabel(VotoRS votoRS, Voto voto) {
		Map<Integer, String> label;
		String cifra1;
		String cifra2;
		String valoreString;
		Float valoreVoto;
		int point;
		
		
		
		if(voto == null || voto.getValore() == null){
			cifra1 = super.cifraNulla;
			cifra2 = super.cifraNulla;
		}else{
			valoreVoto = voto.getValore();
			valoreString = String.valueOf(valoreVoto);
			point = valoreString.indexOf('.');
			
			cifra1 = valoreString.substring(0, point);
			cifra2 = valoreString.substring(point+1, point+2);
			cifra2 = this.separatore + cifra2;
		}


		
		label = new HashMap<Integer, String>();
		label.put(1, cifra1);
		label.put(2, cifra2);
		
		votoRS.setLabel(label);
		
	}
	
	private void initializeFormato(){
		super.formato = new HashMap<Integer, Collection<String>>();
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
		super.formato.put(1, primaCifra);
		super.formato.put(2, secondaCifra);
	}

}
