package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.error.ErrorMessage;
import domain.model.Voto;

public class VotoLettereConverter  implements VotoConverter {
	
	static private VotoLettereConverter instance;
	private Map<Integer, Collection<String>> formato;

	private VotoLettereConverter() {
		initializeFormato();
	}

	static public VotoLettereConverter getInstance() {
		if (VotoLettereConverter.instance == null) {
			VotoLettereConverter.instance = new VotoLettereConverter();
		}
		return VotoLettereConverter.instance;
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
		
		switch (cifra1) {//FIXME sostituire lo switch con qualcosaltro
		case "A":
			valoreVoto = 10f;
			break;
		case "B":
			valoreVoto = 8.66f;
			break;
		case "C":
			valoreVoto = 7.33f;
			break;
		case "D":
			valoreVoto = 6f;
			break;
		case "E":
			valoreVoto = 5f;
			break;
		case "F":
			valoreVoto = 4f;
			break;
		default:
			throw new RuntimeException(ErrorMessage.FORMAT_VOTI_WRONG);
		}
		
		switch (cifra2) {
		case "++":
			valoreVoto += 0.4f;
			break;
		case "+":
			valoreVoto += 0.2f;
			break;
		case " ":
			
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
		String cifra1 = null;
		String cifra2 = null;
		HashMap<Integer, String> label;
		
		valoreVoto = voto.getValore();
		
		if(valoreVoto<0){
			cifra1 = "NC";
		}
		
		if(valoreVoto>= 0 && valoreVoto <=4.5f){
			cifra1 = "F";
			if(valoreVoto<=3.6) cifra2 = "--";
			if(valoreVoto>3.6 && valoreVoto<=3.8) cifra2 = "-";
			if(valoreVoto>3.8 && valoreVoto<4.2) cifra2 = " ";
			if(valoreVoto>=4.2 && valoreVoto<4.4) cifra2 = "+";
			if(valoreVoto>=4.4 && valoreVoto<=4.5) cifra2 = "++";
			
		}
		if(valoreVoto>4.5 && valoreVoto <=5.5){
			cifra1 = "E";
			if(valoreVoto<=4.6) cifra2 = "--";
			if(valoreVoto>4.6 && valoreVoto<=4.8) cifra2 = "-";
			if(valoreVoto>4.8 && valoreVoto<5.2) cifra2 = " ";
			if(valoreVoto>=5.2 && valoreVoto<5.4) cifra2 = "+";
			if(valoreVoto>=5.4 && valoreVoto<=5.5) cifra2 = "++";
		}
		if(valoreVoto>5.5 && valoreVoto <=6.6){
			cifra1 = "D";
			if(valoreVoto<=5.6) cifra2 = "--";
			if(valoreVoto>5.6 && valoreVoto<=5.8) cifra2 = "-";
			if(valoreVoto>5.8 && valoreVoto<6.2) cifra2 = " ";
			if(valoreVoto>=6.2 && valoreVoto<6.4) cifra2 = "+";
			if(valoreVoto>=6.4 && valoreVoto<=6.6) cifra2 = "++";
		}
		if(valoreVoto>6.7 && valoreVoto <=7.85){
			cifra1 = "C";
			if(valoreVoto<=6.8) cifra2 = "--";
			if(valoreVoto>6.8 && valoreVoto<=7.1) cifra2 = "-";
			if(valoreVoto>7.1 && valoreVoto<7.45) cifra2 = " ";
			if(valoreVoto>=7.45 && valoreVoto<7.65) cifra2 = "+";
			if(valoreVoto>=7.65 && valoreVoto<=7.85) cifra2 = "++";
		}
		if(valoreVoto>7.85 && valoreVoto <=9.33){
			cifra1 = "B";
			if(valoreVoto<=8.1) cifra2 = "--";
			if(valoreVoto>8.1 && valoreVoto<=8.4) cifra2 = "-";
			if(valoreVoto>8.4 && valoreVoto<8.85) cifra2 = " ";
			if(valoreVoto>=8.85 && valoreVoto<9.05) cifra2 = "+";
			if(valoreVoto>=9.05 && valoreVoto<=9.33) cifra2 = "++";
		}
		if(valoreVoto>9.33){
			cifra1 = "A";
			if(valoreVoto<=9.6) cifra2 = "--";
			if(valoreVoto>9.6 && valoreVoto<=9.9) cifra2 = "-";
			if(valoreVoto>9.9 && valoreVoto<10.1) cifra2 = " ";
			if(valoreVoto>=10.1) cifra2 = "+";
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

		for(char c = 'A'; c<'G'; c++){
			primaCifra.add(String.valueOf(c));
		}
		secondaCifra.add("--");
		secondaCifra.add("-");
		secondaCifra.add(" ");
		secondaCifra.add("+");
		secondaCifra.add("++");
		
		this.formato.put(1, primaCifra);
		this.formato.put(2, secondaCifra);
	}

}
