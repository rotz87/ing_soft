package test;

import java.util.HashMap;
import java.util.Map;

import domain.error.DomainCheckedException;
import domain.model.Voto;
import presenter.resourceSupport.voto.VotoDecimalConveter;
import presenter.resourceSupport.voto.VotoLettereConverter;
import presenter.resourceSupport.voto.VotoNumeroEIncrementiConverter;
import presenter.resourceSupport.voto.VotoRS;
import sviluppo.Stampa;

public class TestVotoConverter {

	public static void main(String[] args) {
//		float valoreVoto = 10.2f;
//		float parteDecimale;
//		
//		int votoInt = (int)valoreVoto;
//		parteDecimale = (10 * valoreVoto - 10 * votoInt)/10;
//		
//		Stampa.stampaln("parte decimale: " + parteDecimale);

		Map<Integer, String> labelDecimal = new HashMap<Integer, String>();
		labelDecimal.put(1, "8");
		labelDecimal.put(2, ".5");
		
		VotoRS votoRSDecimal = new VotoRS();
		votoRSDecimal.setLabel(labelDecimal);
		
		Voto votoDecimal = VotoDecimalConveter.getInstance().getVoto(votoRSDecimal);
		Stampa.stampaln(votoDecimal.getValore());
		
		Map<Integer, String> labelLettere = new HashMap<Integer, String>();
		labelLettere.put(1, "A");
		labelLettere.put(2, "--");
		
		VotoRS votoRSLettere = new VotoRS();
		votoRSLettere.setLabel(labelLettere);
		
		Voto votoLettere = VotoLettereConverter.getInstance().getVoto(votoRSLettere);
		Stampa.stampaln(votoLettere.getValore());
		
		Map<Integer, String> labelIncrementi = new HashMap<Integer, String>();
		labelIncrementi.put(1, "8");
		labelIncrementi.put(2, "--");
		
		VotoRS votoRSIncrementi = new VotoRS();
		votoRSIncrementi.setLabel(labelIncrementi);
		
		Voto votoIncrementi = VotoNumeroEIncrementiConverter.getInstance().getVoto(votoRSIncrementi);
		Stampa.stampaln(votoIncrementi.getValore());

	}

}
